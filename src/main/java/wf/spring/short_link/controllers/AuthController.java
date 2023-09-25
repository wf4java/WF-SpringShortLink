package wf.spring.short_link.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wf.spring.short_link.dto.ErrorMessageResponseDTO;
import wf.spring.short_link.dto.auth.AuthenticationRequestDTO;
import wf.spring.short_link.dto.auth.JwtTokenResponseDTO;
import wf.spring.short_link.dto.auth.RegisterRequestDTO;
import wf.spring.short_link.mappers.PersonMapper;
import wf.spring.short_link.models.entities.Person;
import wf.spring.short_link.models.exceptions.*;
import wf.spring.short_link.services.JwtAuthService;
import wf.spring.short_link.services.PersonService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtAuthService jwtAuthService;
    private final PersonMapper personMapper;
    private final PersonService personService;

    @PostMapping("/login")
    public JwtTokenResponseDTO login(@RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        return new JwtTokenResponseDTO(jwtAuthService.validateAndGenerateToken(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword()));
    }


    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        Person person = personMapper.toPerson(registerRequestDTO);
        //personRegisterValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        personService.save(person);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessageResponseDTO> authenticationExceptionHandler(AuthenticationException e){
        return new ResponseEntity<>(new ErrorMessageResponseDTO(e), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({NotFoundException.class, BadRequestException.class, AccessException.class, ConflictException.class})
    private ResponseEntity<ErrorMessageResponseDTO> exceptionHandler(HttpException e){
        return new ResponseEntity<>(new ErrorMessageResponseDTO(e.getMessage()), e.getHttpStatus());
    }

}
