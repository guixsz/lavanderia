package com.lavanderia.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DetailsRequest(String applicantName,
                             Long applicantId,
                             String applicantCpf,
                             String applicantPhone,
                             String applicantResponsible,
                             String providerName,
                             String providerPhone,
                             String productName,
                             BigDecimal productSubtotal,
                             String addressNumberApartment,
                             String addressFloor,

                             @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
                             LocalDateTime orderDate,
                             @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
                             LocalDateTime pickupDate
                             ) {
}
