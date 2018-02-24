package xyz.service.msg.mqueue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.service.msg.mqueue.domain.Queue;
import xyz.service.msg.mqueue.repo.QueueRepo;
import xyz.service.msg.mqueue.service.QueueService;

/**
 * PROJECT   : mqueue
 * PACKAGE   : xyz.service.msg.mqueue.service.impl
 * USER      : sean
 * DATE      : 24-February-2018
 * TIME      : 06:44
 */
@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueRepo queueRepo;

    @Override
    public Iterable<?> findAll() {
        return queueRepo.findAll();
    }

    @Override
    public Queue findById(Integer id) {
        return queueRepo.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        queueRepo.delete(id);
    }

    @Override
    public Queue saveOrUpdate(Queue domainObject) {
        return queueRepo.save(domainObject);
    }
}
