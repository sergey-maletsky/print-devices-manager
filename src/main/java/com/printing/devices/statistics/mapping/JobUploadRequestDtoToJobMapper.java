package com.printing.devices.statistics.mapping;

import com.printing.devices.statistics.domain.Job;
import com.printing.devices.statistics.dto.upload.JobUploadRequestDto;
import java.util.Date;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobUploadRequestDtoToJobMapper implements BaseMapper<JobUploadRequestDto, Job> {

    @Override
    public @Nullable Job map(@Nullable final JobUploadRequestDto source) {
        if (source == null) {
            return null;
        }

        final Job job = new Job();
        job.setJobId(source.getId());
        job.setDeviceName(source.getDeviceName());
        job.setUsername(source.getUsername());
        job.setType(source.getType());
        job.setAmountPages(source.getAmountPages());
        job.setCreatedAt(new Date());

        return job;
    }
}
