package com.printing.devices.statistics.converter;

import com.printing.devices.statistics.dto.type.JobType;
import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
class JobTypeConverter implements AttributeConverter<JobType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final JobType jobType) {
        if (jobType == null) {
            return null;
        }
        return jobType.code();
    }

    @Override
    public JobType convertToEntityAttribute(final Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(JobType.values())
                .filter(type -> type.code() == code)
                .findFirst()
                .orElse(null);
    }
}
