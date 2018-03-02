package xyz.service.msg.mqueue.handler;

import org.springframework.validation.Errors;
import xyz.service.msg.mqueue.domain.Message;
import xyz.service.msg.mqueue.domain.Phone;
import xyz.service.msg.mqueue.validator.MessageValidator;
import xyz.service.msg.mqueue.validator.PhoneValidator;

/**
 * PACKAGE : xyz.service.msg.mqueue.handler
 * USER    : Kudzai Sean Huni
 * TIME    : 11:49
 * DATE    : Friday-02-March-2018
 * E-MAIL  : kudzai@tangentsolutions.co.za
 * CELL    : +27-78-683-1982
 */
public class ValidationHandler {
    private MessageValidator messageValidator = new MessageValidator();
    private PhoneValidator phoneValidator = new PhoneValidator();

    public void validateMessageInput(Message message, Errors errors) {
        if (messageValidator.supports(Message.class)) {
            messageValidator.validate(message, errors);
        }

        if (phoneValidator.supports(Phone.class)) {
            phoneValidator.validate(message.getPhone(), errors);
        }
    }
}
