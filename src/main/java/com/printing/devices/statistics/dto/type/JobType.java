package com.printing.devices.statistics.dto.type;

import com.fasterxml.jackson.annotation.JsonValue;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "type")
@XmlEnum
public enum JobType {

    @XmlEnumValue("print")
    PRINT(1, "print"),
    @XmlEnumValue("copy")
    COPY(2, "copy"),
    @XmlEnumValue("scan")
    SCAN(3, "scan"),
    @XmlEnumValue("fax")
    FAX(4, "fax"),
    UNKNOWN(0, "unknown");

    private final int code;
    private final String value;

    JobType(final int code, final String value) {
        this.code = code;
        this.value = value;
    }

    public int code() {
        return code;
    }

    @JsonValue
    public String value() {
        return value;
    }

    public static JobType fromValue(final String value) {
        for (final JobType type : JobType.values()) {
            if (type.value.equals(value)
                    || type.value.equals(value.toLowerCase())) {
                return type;
            }
        }
        return JobType.UNKNOWN;
    }
}
