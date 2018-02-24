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

    /**
     * Generates a Unique Transaction ID.
     *
     * @return String Unique Transaction ID.
     */
    public String getUUID() {
        return UUID.randomUUID().toString();
    }
}
