package com.printing.devices.statistics.domain.specification;

import com.printing.devices.statistics.dto.statistics.SearchRequest;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SearchSpecification<T> implements Specification<T> {

    private List<SearchRequest> searchRequests;

    SearchSpecification(final List<SearchRequest> searchRequests) {
        this.searchRequests = searchRequests;
    }

    @Override
    public Predicate toPredicate(final Root root, final CriteriaQuery query, final CriteriaBuilder builder) {

        Predicate predicate = builder.conjunction();
        for (final SearchRequest searchRequest : searchRequests) {
            final Path path = root.get(searchRequest.getKey());
            switch (searchRequest.getOperation()) {
                case LIKE:
                    if (searchRequest.getValue() != null && path.getJavaType() == String.class) {
                        predicate = builder.and(
                                predicate, builder.like(builder.lower(path),
                                        "%" + searchRequest.getValue().toString().toLowerCase() + "%"));
                    } else {
                        predicate = builder.and(predicate, builder.equal(path, searchRequest.getValue()));
                    }
                    break;
                case EQUALITY:
                    predicate = builder.and(predicate, builder.equal(path, searchRequest.getValue()));
                    break;
                case LESS_THAN:
                    if (searchRequest.getValue() != null && path.getJavaType() == Date.class) {
                        final Date dateTo = (Date) searchRequest.getValue();
                        predicate = builder.and(predicate, builder.lessThanOrEqualTo(path, dateTo));
                    }
                    break;
                case GREATER_THAN:
                    if (searchRequest.getValue() != null && path.getJavaType() == Date.class) {
                        final Date dateFrom = (Date) searchRequest.getValue();
                        predicate = builder.and(predicate, builder.greaterThanOrEqualTo(path, dateFrom));
                    }
                    break;
                case NEGATION:
                case IN:
                    break;
            }
        }
        return predicate;
    }
}
