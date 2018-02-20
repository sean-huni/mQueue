package xyz.service.msg.mqueue.service;

import org.springframework.stereotype.Service;
import xyz.service.msg.mqueue.domain.Queue;

/**
 * PROJECT   : mQueue
 * PACKAGE   : xyz.service.msg.domain
 * USER      : sean
 * DATE      : 18-February-2018
 * TIME      : 14:45
 */

@Service
public interface QueueService extends CRUDService<Queue> {

}
