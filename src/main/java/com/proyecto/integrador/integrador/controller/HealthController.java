package com.proyecto.integrador.integrador.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@Tag(name = "Saludos", description = "Endpoint para validar el funcionamiento de la API")
public class HealthController {

    @GetMapping
    @Operation(summary = "Validar API", description = "Obtener un mensaje de confirmacion de la API", responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = String.class)))}
    )
    public String checkAPI() {
        return "<h1>The API is working ok!</h1>";
    }

}
