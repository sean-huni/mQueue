package xyz.service.msg.mqueue.dao;

import xyz.service.msg.mqueue.domain.Queue;

/**
 * PACKAGE : xyz.service.msg.mqueue.dao
 * USER    : Kudzai Sean Huni
 * TIME    : 11:38
 * DATE    : Thursday-22-February-2018
 * E-MAIL  : kudzai@tangentsolutions.co.za
 * CELL    : +27-78-683-1982
 */
public interface DBOpsService {
    /**
     * Upper-layer Save Operation to the Database.
     *
     * @param uuid   Unique Transaction Identifier
     * @param system ActiveMq or RabbitMq
     * @param msg    Message tom be saved.
     * @param status Queued or Dequeued.
     */
    void saveToDb(final String uuid, final String system, final String msg, final String status);

    Iterable<Queue> findAll();
}
