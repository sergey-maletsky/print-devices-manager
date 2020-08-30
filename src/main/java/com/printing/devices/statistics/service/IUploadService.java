package com.printing.devices.statistics.service;

import com.printing.devices.statistics.dto.upload.JobsUploadRequestDto;
import java.util.Map;

public interface IUploadService {

    Map<String, String> upload(JobsUploadRequestDto dto);
}
