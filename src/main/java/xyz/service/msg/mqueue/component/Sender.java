package xyz.service.msg.mqueue.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import xyz.service.msg.mqueue.dao.DBOpsService;
import xyz.service.msg.mqueue.util.Util;

import static org.springframework.amqp.core.MessageProperties.CONTENT_TYPE_TEXT_PLAIN;
import static xyz.service.msg.mqueue.constant.Constant.*;

/**
 * PROJECT   : msg-consumer
 * PACKAGE   : xyz.service.msg.component
 * USER      : sean
 * DATE      : 11-February-2018
 * TIME      : 10:47
 */
@Component("mqSender")
public class Sender {
    private static final String ROUTING_KEY_NAME = "sms";
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    private RabbitTemplate rabbitTemplate;
    private JmsTemplate jmsTemplate;
    private DBOpsService opsService;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Autowired
    public void setOpsService(DBOpsService opsService) {
        this.opsService = opsService;
    }

    /**
     * Sends a new message to the RabbitMq
     *
     * @param msg String message to be sent to the RabbitMq.
     */
    public void sendRabbitMqMsg(String msg) {
        sendToRabbitMq(msg);
    }

    /**
     * Sends a new message to the ActiveMq
     *
     * @param msg String message to be sent to the RabbitMq.
     */
//    @Async
    public void sendActiveMqMsg(String msg) {
        sendToActiveMq(msg);
    }

    //*************************************************/
    //*************************************************/

    //*************************************************/
    //*************************************************/

    /**
     * Sends a new message to the RabbitMq
     *
     * @param sms String message to be sent to the RabbitMq.
     */
    private void sendToRabbitMq(String sms) {
        final String uuid = new Util().getUUID();
        LOGGER.info(LINE_SEPARATOR, Sender.class);
        LOGGER.info("Sending RabbitMq message: {}", sms);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(CONTENT_TYPE_TEXT_PLAIN);

        final byte[] body = sms.getBytes();
        Message message = new Message(body, messageProperties);
        rabbitTemplate.setRoutingKey(ROUTING_KEY_NAME);
        rabbitTemplate.setQueue(QUEUE_NAME);
        rabbitTemplate.send(message);
        LOGGER.info("Outgoing RabbitMq Message sent!");
        LOGGER.info("Saving RabbitMq Message...");
        opsService.saveToDb(uuid, RABBITMQ, sms, QUEUE_STATUS_QUEUED);
        LOGGER.info("RabbitMq Message Saved!!!");
        LOGGER.info(LINE_SEPARATOR, Sender.class);
    }

    /**
     * Sends a new message to the ActiveMq
     *
     * @param sms String message to be sent to the RabbitMq.
     */
    private void sendToActiveMq(String sms) {
        final String uuid = new Util().getUUID();
        LOGGER.info(LINE_SEPARATOR, Sender.class);
        LOGGER.info("Sending ActiveMq Message: {}", sms);
        jmsTemplate.setDefaultDestinationName(QUEUE_NAME);
        jmsTemplate.convertAndSend(sms);
        LOGGER.info("Outgoing ActiveMq Message sent!");
        LOGGER.info("Saving ActiveMq Message...");
        opsService.saveToDb(uuid, ACTIVEMQ, sms, QUEUE_STATUS_QUEUED);
        LOGGER.info("ActiveMq Message Saved!!!");
        LOGGER.info(LINE_SEPARATOR, Sender.class);
    }
}
