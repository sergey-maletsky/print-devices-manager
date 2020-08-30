package com.printing.devices.statistics.dto.upload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "jobs")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobsUploadRequestDto implements Serializable {

    @XmlElement(name = "job")
    private List<JobUploadRequestDto> jobs;

    public List<JobUploadRequestDto> getJobs() {
        if (jobs == null) {
            jobs = new ArrayList<>();
        }
        return jobs;
    }
}
