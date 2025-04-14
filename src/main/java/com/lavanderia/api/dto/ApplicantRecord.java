package com.lavanderia.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ApplicantRecord(@NotBlank String name,
                              @NotBlank @Email String email,
                              @NotBlank String cpf,
                              @NotBlank String phone,
                              @NotBlank String responsible) {
}
