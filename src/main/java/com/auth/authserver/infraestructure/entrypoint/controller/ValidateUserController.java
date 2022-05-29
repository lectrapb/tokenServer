package com.auth.authserver.infraestructure.entrypoint.controller;


import com.auth.authserver.domain.model.login.Login;
import com.auth.authserver.domain.model.login.LoginRequestDTO;
import com.auth.authserver.domain.model.user.UserResponseDTO;
import com.auth.authserver.domain.usecases.loginusecase.LoginUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ValidateUserController {

    private final LoginUseCase loginUseCase;

    public ValidateUserController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/validate")
    public ResponseEntity<Login> validteUser(@RequestBody  LoginRequestDTO requestDTO){

        var response = loginUseCase.validateUser(requestDTO);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }
    @PostMapping("/validate/token")
    public ResponseEntity<UserResponseDTO> validateUserByToken(@RequestParam("token") String token) throws Exception {

        var response = loginUseCase.validateUserByToken(token);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }
}
