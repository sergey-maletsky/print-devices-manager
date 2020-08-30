package com.printing.devices.statistics.config;

import com.printing.devices.statistics.converter.StringJobTypeToJobTypeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringJobTypeToJobTypeConverter());
    }
}
