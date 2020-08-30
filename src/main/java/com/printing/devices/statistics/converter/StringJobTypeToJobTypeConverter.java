package com.printing.devices.statistics.converter;

import com.printing.devices.statistics.dto.type.JobType;
import org.springframework.core.convert.converter.Converter;

public class StringJobTypeToJobTypeConverter implements Converter<String, JobType> {

    @Override
    public JobType convert(final String source) {
        return JobType.fromValue(source);
    }
}
