package com.printing.devices.statistics.repository;

import com.printing.devices.statistics.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

    Job findOneByJobIdAndDeviceName(String jobId, String deviceName);
}
