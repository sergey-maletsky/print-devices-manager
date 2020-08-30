package com.printing.devices.statistics.service;

import com.printing.devices.statistics.domain.Job;
import java.util.List;

public interface IJobService {

    Job create(Job job);

    List<Job> createAll(final List<Job> jobs);

    Job read(final String jobId, final String deviceName);
}
