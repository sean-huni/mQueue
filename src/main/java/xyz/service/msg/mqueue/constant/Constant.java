package xyz.service.msg.mqueue.constant;


/**
 * PROJECT   : consumer
 * PACKAGE   : xyz.service.msg
 * USER      : sean
 * DATE      : 18-February-2018
 * TIME      : 14:14
 */
public class Constant {
    public static final String QUEUE_NAME = "sms";
    private static final String LINE_DIVIDER = "************************************************";
    public static final String LINE_SEPARATOR = "\n" + LINE_DIVIDER + "\n{}\n" + LINE_DIVIDER;

    public static final String QUEUE_STATUS_DEQUEUED = "dequeued";
    public static final String QUEUE_STATUS_QUEUED = "queued";
    public static final String ACTIVEMQ = "activeMq";
    public static final String RABBITMQ = "rabbitMq";
}
