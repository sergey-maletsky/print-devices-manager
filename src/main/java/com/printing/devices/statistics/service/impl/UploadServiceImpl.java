package com.printing.devices.statistics.service.impl;

import com.printing.devices.statistics.dto.upload.JobsUploadRequestDto;
import com.printing.devices.statistics.mapping.JobUploadRequestDtoToJobMapper;
import com.printing.devices.statistics.mapping.JobsUploadRequestDtoToMapMapper;
import com.printing.devices.statistics.service.IJobService;
import com.printing.devices.statistics.service.IUploadService;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UploadServiceImpl implements IUploadService {

    private final IJobService jobService;
    private final JobUploadRequestDtoToJobMapper jobUploadRequestDtoToJobMapper;
    private final JobsUploadRequestDtoToMapMapper jobsUploadRequestDtoToMapMapper;

    @Autowired
    private UploadServiceImpl(final IJobService jobService,
                              final JobUploadRequestDtoToJobMapper jobUploadRequestDtoToJobMapper,
                              final JobsUploadRequestDtoToMapMapper jobsUploadRequestDtoToMapMapper) {
        this.jobService = jobService;
        this.jobUploadRequestDtoToJobMapper = jobUploadRequestDtoToJobMapper;
        this.jobsUploadRequestDtoToMapMapper = jobsUploadRequestDtoToMapMapper;
    }

    @Override
    public Map<String, String> upload(@NotNull final JobsUploadRequestDto dto) {

        jobService.createAll(jobUploadRequestDtoToJobMapper.map(dto.getJobs()));
        return jobsUploadRequestDtoToMapMapper.map(dto);
    }
}
