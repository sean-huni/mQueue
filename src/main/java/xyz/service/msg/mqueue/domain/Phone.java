package xyz.service.msg.mqueue.domain;

/**
 * PACKAGE : xyz.service.msg.mqueue.domain
 * USER    : Kudzai Sean Huni
 * TIME    : 11:29
 * DATE    : Friday-02-March-2018
 * E-MAIL  : kudzai@tangentsolutions.co.za
 * CELL    : +27-78-683-1982
 */
public class Phone {
    private String code;
    private String isdn;


    public String getCode() {
        return this.code;
    }

    public String getIsdn() {
        return this.isdn;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }
}
