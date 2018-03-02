package xyz.service.msg.mqueue.component;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import xyz.service.msg.mqueue.dao.DBOpsService;
import xyz.service.msg.mqueue.domain.Message;
import xyz.service.msg.mqueue.handler.ValidationHandler;
import xyz.service.msg.mqueue.util.Util;

import java.util.concurrent.CountDownLatch;

import static xyz.service.msg.mqueue.constant.Constant.*;

/**
 * PROJECT   : msg-consumer
 * PACKAGE   : xyz.service.msg.controller
 * USER      : sean
 * DATE      : 10-February-2018
 * TIME      : 13:52
 */

@Component("mqReceiver")
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private DBOpsService opsService;

    public CountDownLatch getLatch() {
        return latch;
    }

    /**
     * ActiveMq {@link JmsListener} for intercepting queued-messages on ActiveMq.
     *
     * @param input {@link String} message to be received from the ActiveMq.
     */
    @JmsListener(destination = QUEUE_NAME) //, containerFactory = "smsFactory")
    public void onMessage(String input) {
        final String uuid = new Util().getUUID();
        ValidationHandler validationHandler = new ValidationHandler();

        LOGGER.info(LINE_SEPARATOR, Receiver.class);
        LOGGER.info("Incoming ActiveMq...");
        LOGGER.info("Message Received='{}'", input);

        Gson gson = new Gson();
        Message message = gson.fromJson(input, Message.class);
        Errors errors = new BeanPropertyBindingResult(message, "message");

        LOGGER.info("Performing validation.");
        validationHandler.validateMessageInput(message, errors);

        //Save only when passed validation.
        if (errors.hasErrors()) {
            LOGGER.info("Saving to Database...");
            opsService.saveToDb(uuid, ACTIVEMQ, input, QUEUE_STATUS_DEQUEUED);
            LOGGER.info("Saved to Database!");
        } else {
            LOGGER.error("Errors found: {}", errors.getAllErrors());
        }

        LOGGER.info(LINE_SEPARATOR, Receiver.class);
    }

    /**
     * {@link RabbitListener} that intercepts RabbitMq messages.
     *
     * @param message {@link String} text message.
     */
    @RabbitListener(queues = QUEUE_NAME)
    public void inMessage(String message) {
        final String uuid = new Util().getUUID();
        LOGGER.info(LINE_SEPARATOR, Receiver.class);
        LOGGER.info("Incoming RabbitMq...");
        LOGGER.info("Message Received='{}'", message);
        LOGGER.info("Saving to Database...");
        opsService.saveToDb(uuid, RABBITMQ, message, QUEUE_STATUS_DEQUEUED);
        LOGGER.info("Saved to Database!");
        LOGGER.info(LINE_SEPARATOR, Receiver.class);
    }
}
