package com.printing.devices.statistics.dto.upload;

import com.printing.devices.statistics.dto.type.JobType;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class JobUploadRequestDto implements Serializable {

    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(required = true)
    private JobType type;
    @XmlElement(name = "user")
    private String username;
    @XmlElement(name = "device")
    private String deviceName;
    @XmlElement(name = "amount")
    private int amountPages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public void setAmountPages(int amountPages) {
        this.amountPages = amountPages;
    }
}
