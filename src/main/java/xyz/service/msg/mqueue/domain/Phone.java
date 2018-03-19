package xyz.service.msg.mqueue.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * PACKAGE : xyz.service.msg.mqueue.domain
 * USER    : Kudzai Sean Huni
 * TIME    : 11:29
 * DATE    : Friday-02-March-2018
 * E-MAIL  : kudzai@tangentsolutions.co.za
 * CELL    : +27-78-683-1982
 */
@Getter
@Setter
public class Phone {
    private String code;
    private String isdn;

    @Override
    public String toString() {
        return "Phone{" +
                "code='" + code + '\'' +
                ", isdn='" + isdn + '\'' +
                '}';
    }
}
