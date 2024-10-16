package com.cibertec.edu.dto;

import java.util.Date;

public record LogoutResponseDTO(
        Boolean resultado,
        Date fecha,
        String mensajeError) { }
