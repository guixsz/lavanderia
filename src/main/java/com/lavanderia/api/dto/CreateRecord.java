package com.lavanderia.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateRecord(@NotBlank String applicantName,
                           @NotBlank @Email String applicantEmail,
                           @NotBlank String applicantCpf,
                           @NotBlank String applicantPhone,
                           @NotBlank String applicantResponsible,
                           @NotBlank String providerName,
                           @NotBlank @Email String providerEmail,
                           @NotBlank String providerCnpj,
                           @NotBlank String providerPhone,
                           @NotBlank String productType,
                           @NotNull  Integer productQuantity,
                           @NotNull  Double productValue,
                           @NotNull  Double productSubTotal) {
}
