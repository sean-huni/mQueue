package xyz.service.msg.mqueue.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * PROJECT   : mQueue
 * PACKAGE   : xyz.service.msg.domain
 * USER      : sean
 * DATE      : 18-February-2018
 * TIME      : 14:26
 */
@Getter
@Setter
@Entity
@Table(name = "queue", schema = "logs")
public class Queue{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Integer id;
    private String system;   //Queueing Service
    private String channel;  //Queue Name
    private String status;   //Queued/De-Queued
    private String message;
    private String uuid;
    private Timestamp dtCreated;
    private Timestamp dtUpdated;

    //Used Lombok to cater for boilerplate code (Getters & Setters).

    @Override
    public String toString() {
        return "Queue{" +
                "id=" + id +
                ", system='" + system + '\'' +
                ", channel='" + channel + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", uuid='" + uuid + '\'' +
                ", dtCreated=" + dtCreated +
                ", dtUpdated=" + dtUpdated +
                '}';
    }
}
