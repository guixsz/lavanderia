package com.lavanderia.api.dto;

import java.math.BigDecimal;

public record DetailsRequest(String applicantName,
                             Long applicantId,
                             String applicantCpf,
                             String applicantPhone,
                             String applicantResponsible,
                             String providerName,
                             String providerPhone,
                             String productName,
                             BigDecimal productSubtotal
                             ) {
}
