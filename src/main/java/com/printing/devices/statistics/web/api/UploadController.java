package com.printing.devices.statistics.web.api;

import com.printing.devices.statistics.dto.upload.JobsUploadRequestDto;
import com.printing.devices.statistics.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/upload")
final class UploadController {

    private final IUploadService uploadService;

    @Autowired
    private UploadController(final IUploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping(value = "/jobs",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity uploadJobs(@RequestBody final JobsUploadRequestDto dto) {
        return ResponseEntity.ok(uploadService.upload(dto));
    }
}
