package com.printing.devices.statistics.web.api;

import com.printing.devices.statistics.dto.statistics.JobStatisticsRequestDto;
import com.printing.devices.statistics.dto.statistics.JobStatisticsResponseDto;
import com.printing.devices.statistics.dto.type.JobType;
import com.printing.devices.statistics.service.IStatisticsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
final class StatisticsController {

    private final IStatisticsService statisticsService;

    @Autowired
    private StatisticsController(final IStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    @ResponseStatus(HttpStatus.OK)
    List<JobStatisticsResponseDto> getJobsStatistics(
            @RequestParam(name = "user", required = false) final String user,
            @RequestParam(name = "type", required = false) final JobType type,
            @RequestParam(name = "device", required = false) final String device,
            @RequestParam(name = "timeFrom", required = false) final String timeFrom,
            @RequestParam(name = "timeTo", required = false) final String timeTo) {
        return statisticsService.getJobsStatistics(new JobStatisticsRequestDto(user, type, device, timeFrom, timeTo));
    }
}
