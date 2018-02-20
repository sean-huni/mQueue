package xyz.service.msg.mqueue.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static org.springframework.amqp.core.MessageProperties.CONTENT_TYPE_TEXT_PLAIN;
import static xyz.service.msg.mqueue.constant.Constant.LINE_SEPARATOR;
import static xyz.service.msg.mqueue.constant.Constant.QUEUE_NAME;

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

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;


    /**
     * Sends a new message to the RabbitMq
     *
     * @param msg String message to be sent to the RabbitMq.
     */
//    @Async
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
        LOGGER.info(LINE_SEPARATOR, Sender.class);
    }

    /**
     * Sends a new message to the ActiveMq
     *
     * @param sms String message to be sent to the RabbitMq.
     */
    private void sendToActiveMq(String sms) {
        LOGGER.info(LINE_SEPARATOR, Sender.class);
        LOGGER.info("Sending ActiveMq Message: {}", sms);
        jmsTemplate.setDefaultDestinationName(QUEUE_NAME);
        jmsTemplate.convertAndSend(sms);
        LOGGER.info("Outgoing ActiveMq Message sent!");
        LOGGER.info(LINE_SEPARATOR, Sender.class);
    }
}
