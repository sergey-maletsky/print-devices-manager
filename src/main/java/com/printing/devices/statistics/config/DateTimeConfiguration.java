package com.printing.devices.statistics.config;

import static com.printing.devices.statistics.util.Constants.DATE_FORMAT_STR;
import static com.printing.devices.statistics.util.Constants.DATE_TIME_FORMAT_STR;

import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
class DateTimeConfiguration {

    @Bean
    public FormattingConversionService conversionService() {
        DefaultFormattingConversionService conversionService =
                new DefaultFormattingConversionService(false);

        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ofPattern(DATE_FORMAT_STR));
        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_STR));
        registrar.registerFormatters(conversionService);

        return conversionService;
    }
}
