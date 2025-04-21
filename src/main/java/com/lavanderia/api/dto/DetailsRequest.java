package com.lavanderia.api.dto;

public record DetailsRequest(String applicantName,
                             Long applicantId,
                             String applicantCpf,
                             String applicantPhone,
                             String applicantResponsible,
                             String providerName,
                             String providerPhone,
                             String productName,
                             Double productSubtotal
                             ) {
}
