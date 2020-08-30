package com.printing.devices.statistics.dto.statistics;

import static com.printing.devices.statistics.util.Constants.DATE_TIME_FORMAT_STR;
import static com.printing.devices.statistics.util.DateTimeUtil.MOSCOW_TIME_ZONE;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.printing.devices.statistics.dto.type.JobType;
import java.io.Serializable;
import java.util.Date;

public class JobStatisticsResponseDto implements Serializable {

    @JsonProperty("jobId")
    private long id;
    @JsonProperty("device")
    private String deviceName;
    @JsonProperty("user")
    private String username;
    @JsonProperty("type")
    private JobType type;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT_STR, timezone = MOSCOW_TIME_ZONE)
    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
