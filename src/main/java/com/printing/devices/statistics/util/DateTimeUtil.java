package com.printing.devices.statistics.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.time.FastDateFormat;

public final class DateTimeUtil {

    public static final String MOSCOW_TIME_ZONE = "Europe/Moscow";

    public static final String ISO_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final String DEFAULT_DATE_PATTERN = "dd.MM.yyyy";
    public static final String DATE_TIME_FORMAT_WITHOUT_SECONDS_PATTERN = "dd.MM.yyyy'T'HH:mm";
    public static final String DATE_TIME_FORMAT_PATTERN = "dd.MM.yyyy'T'HH:mm:ss";
    public static final FastDateFormat ISO_DATE_TIME_FORMATTER =
            FastDateFormat.getInstance(ISO_DATE_TIME_FORMAT_PATTERN, TimeZone.getTimeZone(MOSCOW_TIME_ZONE));
    public static final FastDateFormat DEFAULT_DATE_FORMATTER =
            FastDateFormat.getInstance(DEFAULT_DATE_PATTERN, TimeZone.getTimeZone(MOSCOW_TIME_ZONE));
    public static final FastDateFormat DATE_TIME_WITHOUT_SECONDS_FORMATTER =
            FastDateFormat.getInstance(DATE_TIME_FORMAT_WITHOUT_SECONDS_PATTERN, TimeZone.getTimeZone(MOSCOW_TIME_ZONE));
    public static final FastDateFormat DATE_TIME_FORMATTER =
            FastDateFormat.getInstance(DATE_TIME_FORMAT_PATTERN, TimeZone.getTimeZone(MOSCOW_TIME_ZONE));

    private DateTimeUtil() { }

    public static Date convertToDate(final LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDate(final Date date, final FastDateFormat formatter) {
        return formatter.format(date);
    }

    public static Date convert(final String dateString,
                               final String sourcePattern,
                               final FastDateFormat targetFormatter) {
        if (dateString == null) {
            return null;
        }

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sourcePattern);
        simpleDateFormat.setLenient(false);

        try {
            final Date date = simpleDateFormat.parse(dateString);
            return targetFormatter.parse(targetFormatter.format(date));
        } catch (final ParseException e) {
            return null;
        }
    }

    public static Date multiConvert(final String dateString, final FastDateFormat targetFormatter) {
        Date date = convert(dateString, DATE_TIME_FORMAT_WITHOUT_SECONDS_PATTERN, targetFormatter);
        date = date == null ? convert(dateString, DATE_TIME_FORMAT_PATTERN, targetFormatter) : date;
        date = date == null ? convert(dateString, DEFAULT_DATE_PATTERN, targetFormatter) : date;
        return date;
    }
}
