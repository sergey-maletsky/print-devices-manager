package com.printing.devices.statistics.dto.statistics;

import com.printing.devices.statistics.dto.type.Direction;
import com.printing.devices.statistics.dto.type.SearchOperation;

public class SearchRequest {

    private String key;
    private Object value;
    private SearchOperation operation;
    private Direction direction;

    public String getKey() {
        return key;
    }

    public SearchRequest setKey(final String key) {
        this.key = key;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public SearchRequest setValue(final Object value) {
        this.value = value;
        return this;
    }

    public SearchOperation getOperation() {
        return operation;
    }

    public SearchRequest setOperation(final SearchOperation operation) {
        this.operation = operation;
        return this;
    }

    public Direction getDirection() {
        return direction;
    }

    public SearchRequest setDirection(final Direction direction) {
        this.direction = direction;
        return this;
    }
}
