package xyz.service.msg.mqueue.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.service.msg.mqueue.domain.Queue;

/**
 * PROJECT   : mqueue
 * PACKAGE   : xyz.service.msg.mqueue.repo
 * USER      : sean
 * DATE      : 24-February-2018
 * TIME      : 06:42
 */
@Repository
public interface QueueRepo extends CrudRepository<Queue, Integer> {
}
