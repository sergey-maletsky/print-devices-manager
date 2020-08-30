package com.printing.devices.statistics.mapping;

import static com.printing.devices.statistics.util.DateTimeUtil.DATE_TIME_FORMATTER;

import com.printing.devices.statistics.dto.statistics.JobStatisticsRequestDto;
import com.printing.devices.statistics.dto.statistics.SearchRequest;
import com.printing.devices.statistics.dto.statistics.SearchRequests;
import com.printing.devices.statistics.dto.type.SearchOperation;
import com.printing.devices.statistics.util.DateTimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobStatisticsRequestDtoToSearchRequestsMapper
        implements BaseMapper<JobStatisticsRequestDto, SearchRequests> {

    @Override
    public @Nullable SearchRequests map(@Nullable final JobStatisticsRequestDto source) {
        if (source == null) {
            return null;
        }

        final SearchRequests searchRequests = new SearchRequests();
        searchRequests.setFilters(getFilters(source));
        return searchRequests;
    }

    private List<SearchRequest> getFilters(final JobStatisticsRequestDto dto) {

        final List<SearchRequest> filters = new ArrayList<>();
        if (StringUtils.isNotBlank(dto.getDevice())) {
            filters.add(createSearchRequest("deviceName", dto.getDevice(), SearchOperation.LIKE));
        }
        if (StringUtils.isNotBlank(dto.getUser())) {
            filters.add(createSearchRequest("username", dto.getUser(), SearchOperation.LIKE));
        }
        if (dto.getType() != null) {
            filters.add(createSearchRequest("type", dto.getType(), SearchOperation.EQUALITY));
        }
        if (dto.getTimeFrom() != null) {
            final Date timeFrom = DateTimeUtil.multiConvert(dto.getTimeFrom(), DATE_TIME_FORMATTER);
            filters.add(createSearchRequest("createdAt", timeFrom, SearchOperation.GREATER_THAN));
        }
        if (dto.getTimeTo() != null) {
            final Date timeTo = DateTimeUtil.multiConvert(dto.getTimeTo(), DATE_TIME_FORMATTER);
            filters.add(createSearchRequest("createdAt", timeTo, SearchOperation.LESS_THAN));
        }
        return filters;
    }

    private SearchRequest createSearchRequest(final String key, final Object value, final SearchOperation operation) {
        return new SearchRequest()
                .setKey(key)
                .setValue(value)
                .setOperation(operation);
    }
}
