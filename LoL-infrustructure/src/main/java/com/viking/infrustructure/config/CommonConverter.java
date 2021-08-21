package com.viking.infrustructure.config;

import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Mapper(componentModel = "spring", uses = {}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CommonConverter {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    /**
     * 将SQL Timestamp转换成毫秒级时间戳
     *
     * @param timestamp SQL Timestamp
     * @return 毫秒级时间戳
     */
    default Long sqlTimestamp2MilliSecLong(Timestamp timestamp) {
        return timestamp.getTime();
    }

    /**
     * 将毫秒级时间戳转换成SQL Timestamp
     *
     * @param timestamp 毫秒级时间戳
     * @return SQL Timestamp
     */
    default Timestamp milliSecLong2SqlTimestamp(Long timestamp) {
        return Timestamp.from(Instant.ofEpochMilli(timestamp));
    }

    default String toTimeString(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return Strings.EMPTY;
        }
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    default String toTimeString(LocalDate LocalDate) {
        if (LocalDate == null) {
            return Strings.EMPTY;
        }
        return LocalDate.format(DATE_FORMATTER);
    }

    default Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    default Integer toInteger(Boolean booleanValue) {
        if (booleanValue) {
            return 1;
        } else {
            return 0;
        }
    }

    default Boolean toBoolean(Integer booleanValue) {
        if (booleanValue == null) {
            return Boolean.FALSE;
        }
        if (booleanValue == 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    default LocalTime stringToLocaltime(String str){
        return LocalTime.parse(str);
    }

    default String localTimeToString(LocalTime time){
        return time.toString();
    }


}
