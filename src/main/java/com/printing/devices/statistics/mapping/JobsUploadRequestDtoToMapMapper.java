package com.printing.devices.statistics.mapping;

import com.printing.devices.statistics.dto.upload.JobUploadRequestDto;
import com.printing.devices.statistics.dto.upload.JobsUploadRequestDto;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class JobsUploadRequestDtoToMapMapper
        implements BaseMapper<JobsUploadRequestDto, Map<String, String>> {

    @Override
    public @NotNull Map<String, String> map(@Nullable final JobsUploadRequestDto source) {
        if (source == null
            || CollectionUtils.isEmpty(source.getJobs())) {
            return new HashMap<>();
        }

        return source.getJobs().stream()
                .collect(Collectors.toMap(
                        JobUploadRequestDto::getUsername, j -> String.valueOf(j.getAmountPages()),
                        (oldV, newV) -> String.valueOf(Integer.parseInt(oldV) + Integer.parseInt(newV))));
    }
}
