package com.lavanderia.api.dto;

public record ApplicantPut(String responsible,
                           String name,
                           String phone,
                           String cpf,
                           String email
)   {
}
