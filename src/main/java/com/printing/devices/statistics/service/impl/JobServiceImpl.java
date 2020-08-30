package com.printing.devices.statistics.service.impl;

import com.printing.devices.statistics.domain.Job;
import com.printing.devices.statistics.repository.JobRepository;
import com.printing.devices.statistics.service.IJobService;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class JobServiceImpl implements IJobService {

    private final JobRepository repository;

    @Autowired
    JobServiceImpl(final JobRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public @Nullable Job read(@NotNull final String jobId, @NotNull final String deviceName) {

        return repository.findOneByJobIdAndDeviceName(jobId, deviceName);
    }

    @Override
    public @Nullable Job create(@Nullable final Job job) {
        if (job != null) {
            job.setCreatedAt(new Date());
        }

        return repository.saveAndFlush(job);
    }

    @Override
    @Transactional
    public @NotNull List<Job> createAll(@NotNull final List<Job> jobs) {

        final List<Job> filteredRealtyOffers = jobs.stream()
                .filter(Objects::nonNull)
                .filter(job -> read(job.getJobId(), job.getDeviceName()) == null)
                .map(job -> {
                    job.setCreatedAt(new Date());
                    return job;
                })
                .collect(Collectors.toList());

        return repository.saveAll(filteredRealtyOffers);
    }
}
