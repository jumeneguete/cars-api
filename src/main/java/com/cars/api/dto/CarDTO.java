package com.cars.api.dto;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarDTO(
        @NotBlank String modelo,
        @NotBlank String fabricante,
        @Past Date dataFabricacao,
        @NotNull double valor,
        @Max(2023) int anoModelo) {

}
