package com.cibertec.edu.dto;

public record LoginResponseDTO(
        String codigo,
        String mensaje,
        String nombreUsuario,
        String correoUsuario,
        String tipoDocumento,
        String numeroDocumento) { }
