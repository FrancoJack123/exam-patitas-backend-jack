package com.cibertec.edu.controller;

import com.cibertec.edu.dto.LoginRequestDTO;
import com.cibertec.edu.dto.LoginResponseDTO;
import com.cibertec.edu.dto.LogoutRequestDTO;
import com.cibertec.edu.dto.LogoutResponseDTO;
import com.cibertec.edu.service.AutenticacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        try {
            Thread.sleep(Duration.ofSeconds(5));
            String[] datosUsuario = autenticacionService.validarUsuario(loginRequestDTO);

            if (datosUsuario == null) {
                return new LoginResponseDTO(
                        "01",
                        "Error: Usuario no encontrado",
                        "", "", "", "");
            }
            return new LoginResponseDTO(
                    "00",
                    "",
                    datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3]);

        } catch (Exception e) {
            return new LoginResponseDTO(
                    "99",
                    "Error: Ocurrió un problema".concat(e.getMessage()),
                    "", "", "", "");
        }

    }

    @PostMapping("/logout")
    public LogoutResponseDTO logout(@RequestBody LogoutRequestDTO logoutRequestDTO) {
        try {
            Thread.sleep(Duration.ofSeconds(5));
            Date fechaLogout = autenticacionService.cerrarSesionUsuario(logoutRequestDTO);

            if (fechaLogout == null) {
                return new LogoutResponseDTO(
                        false,
                        null,
                        "Error: No se pudo registrar auditoría");
            }
            return new LogoutResponseDTO(
                    true,
                    fechaLogout,
                    "");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new LogoutResponseDTO(
                    false,
                    null,
                    "Error: Ocurrió un problema: " + e.getMessage());
        }

    }

}
