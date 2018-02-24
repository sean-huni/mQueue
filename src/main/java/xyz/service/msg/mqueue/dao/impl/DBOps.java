package xyz.service.msg.mqueue.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.service.msg.mqueue.convertor.DateUtilToSQLTimestamp;
import xyz.service.msg.mqueue.dao.DBOpsService;
import xyz.service.msg.mqueue.domain.Queue;
import xyz.service.msg.mqueue.service.QueueService;

import java.util.Date;

import static xyz.service.msg.mqueue.constant.Constant.QUEUE_NAME;

/**
 * PROJECT   : mqueue
 * PACKAGE   : xyz.service.msg.mqueue.component
 * USER      : sean
 * DATE      : 18-February-2018
 * TIME      : 21:11
 */
@Service
public class DBOps implements DBOpsService{
    private static final Logger LOGGER = LoggerFactory.getLogger(DBOps.class);

    @Autowired
    private QueueService queueService;

    /**
     * Save to Database operation.
     *
     * @param system Queueing Service: either ActiveMq or RabbitMq.
     * @param msg Payload passed as string.
     * @param status Queued or Dequeued.
     */
    public void saveToDb(final String system, final String msg, final String status, final String uuid) {
        Queue queueObj = new Queue();
//        queueObj.setId(1);
        queueObj.setChannel(QUEUE_NAME);
        queueObj.setSystem(system);
        queueObj.setMessage(msg);
        queueObj.setUuid(uuid);
        queueObj.setStatus(status);
        queueObj.setDtCreated(new DateUtilToSQLTimestamp().convert(new Date()));
        queueObj.setDtUpdated(new DateUtilToSQLTimestamp().convert(new Date()));
        LOGGER.info("Queue-Entry: {}", queueObj);

        queueService.saveOrUpdate(queueObj);
    }

    @Override
    public Iterable<Queue> findAll() {
        return (Iterable<Queue>) queueService.findAll();
    }
}
