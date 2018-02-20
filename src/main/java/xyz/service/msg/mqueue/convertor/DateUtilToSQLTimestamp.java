package xyz.service.msg.mqueue.convertor;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;

/**
 * PROJECT   : resume
 * PACKAGE   : info.resume.convertor
 * USER      : sean
 * DATE      : 25-September-2017
 * TIME      : 15:41
 */
public class DateUtilToSQLTimestamp implements Converter<Date, Timestamp> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Timestamp convert(Date source) {
        return new Timestamp(source.getTime());
    }
}
