package com.printing.devices.statistics.domain.specification;

import com.printing.devices.statistics.dto.statistics.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class SearchSpecificationBuilder<T> {

    private final List<SearchRequest> searchRequests;

    public SearchSpecificationBuilder() {
        this.searchRequests = new ArrayList<>();
    }

    public SearchSpecificationBuilder(final List<SearchRequest> searchRequests) {
        this.searchRequests = searchRequests;
    }

    public Specification<T> build() {

        return new SearchSpecification<>(searchRequests);
    }

    public SearchSpecificationBuilder with(final SearchRequest searchParameter) {

        searchRequests.add(searchParameter);
        return this;
    }
}
