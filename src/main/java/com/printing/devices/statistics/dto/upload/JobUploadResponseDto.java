package com.printing.devices.statistics.dto.upload;

import java.io.Serializable;

public class JobUploadResponseDto implements Serializable {

    private String username;
    private String amountProcessedPages;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getAmountProcessedPages() {
        return amountProcessedPages;
    }

    public void setAmountProcessedPages(final String amountProcessedPages) {
        this.amountProcessedPages = amountProcessedPages;
    }
}
