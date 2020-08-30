package com.printing.devices.statistics.dto.statistics;

import java.util.ArrayList;
import java.util.List;

public final class SearchRequests {

    private List<SearchRequest> filters = new ArrayList<>();

    public SearchRequests() {
    }

    public List<SearchRequest> getFilters() {
        return filters;
    }

    public SearchRequests setFilters(final List<SearchRequest> filters) {
        this.filters = filters;
        return this;
    }
}
