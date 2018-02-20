package xyz.service.msg.mqueue.service;

import org.springframework.stereotype.Service;

/**
 * PROJECT   : mQueue
 * PACKAGE   : xyz.service.msg.service
 * USER      : sean
 * DATE      : 18-February-2018
 * TIME      : 14:22
 */
@Service
public interface CRUDService<T> {
    Iterable<?> findAll();

    T findById(Integer id);

    void delete(Integer id);

    T saveOrUpdate(T domainObject);
}
