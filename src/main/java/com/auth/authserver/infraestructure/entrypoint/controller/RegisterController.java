package com.auth.authserver.infraestructure.entrypoint.controller;


import com.auth.authserver.domain.model.user.UserRequestDTO;
import com.auth.authserver.domain.model.user.UserResponseDTO;
import com.auth.authserver.domain.usecases.registeruser.RegisterUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200"})
public class RegisterController {

     private final RegisterUserUseCase registerUserUseCase;

    public RegisterController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO requestDTO) throws Exception {

        var response = registerUserUseCase.registerUser(requestDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
     }

     @GetMapping("/register/status")
     public ResponseEntity<?> getHealth(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("ok");
     }


}
