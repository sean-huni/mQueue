package xyz.service.msg.mqueue.dao;

import org.springframework.stereotype.Service;

/**
 * PACKAGE : xyz.service.msg.mqueue.dao
 * USER    : Kudzai Sean Huni
 * TIME    : 11:38
 * DATE    : Thursday-22-February-2018
 * E-MAIL  : kudzai@tangentsolutions.co.za
 * CELL    : +27-78-683-1982
 */
@Service
public interface DBOpsService {
    void saveToDb(final String system, final String msg, final String status);
}
