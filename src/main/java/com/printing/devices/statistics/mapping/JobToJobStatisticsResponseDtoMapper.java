package com.printing.devices.statistics.mapping;

import com.printing.devices.statistics.domain.Job;
import com.printing.devices.statistics.dto.statistics.JobStatisticsResponseDto;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobToJobStatisticsResponseDtoMapper implements BaseMapper<Job, JobStatisticsResponseDto> {

    @Override
    public @Nullable JobStatisticsResponseDto map(@Nullable final Job source) {
        if (source == null) {
            return null;
        }

        final JobStatisticsResponseDto result = new JobStatisticsResponseDto();
        result.setId(Long.parseLong(source.getJobId()));
        result.setDeviceName(source.getDeviceName());
        result.setUsername(source.getUsername());
        result.setType(source.getType());
        result.setAmount(source.getAmountPages());
        result.setCreatedAt(source.getCreatedAt());

        return result;
    }
}
