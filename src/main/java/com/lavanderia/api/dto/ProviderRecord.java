package com.lavanderia.api.dto;

import com.lavanderia.api.entities.Applicant;

public record ProviderRecord(String providerName, String providerEmail, String providerPhone, String providerCnpj, Applicant providerApplicant) {
}
