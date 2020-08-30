package com.printing.devices.statistics.dto.statistics;

import com.printing.devices.statistics.dto.type.JobType;

public class JobStatisticsRequestDto {

    private String user;
    private JobType type;
    private String device;
    private String timeFrom;
    private String timeTo;

    public JobStatisticsRequestDto(final String user,
                                   final JobType type,
                                   final String device,
                                   final String timeFrom,
                                   final String timeTo) {
        this.user = user;
        this.type = type;
        this.device = device;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }
}
