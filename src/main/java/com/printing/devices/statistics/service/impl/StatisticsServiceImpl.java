package com.printing.devices.statistics.service.impl;

import com.printing.devices.statistics.domain.Job;
import com.printing.devices.statistics.domain.specification.SearchSpecificationBuilder;
import com.printing.devices.statistics.dto.statistics.JobStatisticsRequestDto;
import com.printing.devices.statistics.dto.statistics.JobStatisticsResponseDto;
import com.printing.devices.statistics.dto.statistics.SearchRequests;
import com.printing.devices.statistics.mapping.JobStatisticsRequestDtoToSearchRequestsMapper;
import com.printing.devices.statistics.mapping.JobToJobStatisticsResponseDtoMapper;
import com.printing.devices.statistics.repository.JobRepository;
import com.printing.devices.statistics.service.IStatisticsService;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
class StatisticsServiceImpl implements IStatisticsService {

    private final JobRepository jobRepository;
    private final JobStatisticsRequestDtoToSearchRequestsMapper jobStatisticsRequestDtoToSearchRequestsMapper;
    private final JobToJobStatisticsResponseDtoMapper jobToJobStatisticsResponseDtoMapper;

    @Autowired
    StatisticsServiceImpl(final JobRepository jobRepository,
                          final JobStatisticsRequestDtoToSearchRequestsMapper
                                  jobStatisticsRequestDtoToSearchRequestsMapper,
                          final JobToJobStatisticsResponseDtoMapper jobToJobStatisticsResponseDtoMapper) {
        this.jobRepository = jobRepository;
        this.jobStatisticsRequestDtoToSearchRequestsMapper = jobStatisticsRequestDtoToSearchRequestsMapper;
        this.jobToJobStatisticsResponseDtoMapper = jobToJobStatisticsResponseDtoMapper;
    }

    @Override
    public List<JobStatisticsResponseDto> getJobsStatistics(@NotNull final JobStatisticsRequestDto dto) {

        final SearchRequests searchRequests = jobStatisticsRequestDtoToSearchRequestsMapper.map(dto);
        final SearchSpecificationBuilder<Job> searchSpecificationBuilder =
                new SearchSpecificationBuilder<>(searchRequests.getFilters());

        final List<Job> jobs = jobRepository
                .findAll(searchSpecificationBuilder.build(), Sort.by(Sort.Direction.ASC, "createdAt"));
        return jobToJobStatisticsResponseDtoMapper.map(jobs);
    }
}
