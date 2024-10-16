package com.cibertec.edu.service;

import com.cibertec.edu.dto.LoginRequestDTO;
import com.cibertec.edu.dto.LogoutRequestDTO;

import java.io.IOException;
import java.util.Date;

public interface AutenticacionService {
    String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;
    Date cerrarSesionUsuario(LogoutRequestDTO logoutRequestDTO) throws IOException;
}
