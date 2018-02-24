package xyz.service.msg.mqueue.util;

import java.util.UUID;

/**
 * PROJECT   : mqueue
 * PACKAGE   : xyz.service.msg.mqueue.util
 * USER      : sean
 * DATE      : 24-February-2018
 * TIME      : 07:28
 */
public class Util {

    public String uuid() {
        return new UUID(999999, 9999999).toString();
    }
}
