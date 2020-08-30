package com.printing.devices.statistics.service;

import com.printing.devices.statistics.dto.statistics.JobStatisticsRequestDto;
import com.printing.devices.statistics.dto.statistics.JobStatisticsResponseDto;
import java.util.List;

public interface IStatisticsService {

    List<JobStatisticsResponseDto> getJobsStatistics(JobStatisticsRequestDto dto);
}
