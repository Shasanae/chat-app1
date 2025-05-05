package com.example.chatapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatapp.dto.reponse.AuthenticationReponse;
import com.example.chatapp.dto.reponse.IntrospectReponse;
import com.example.chatapp.dto.request.AuthenticationRequest;
import com.example.chatapp.dto.request.IntrospectRequest;
import com.example.chatapp.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    AuthenticationReponse  authenticate(@RequestBody AuthenticationRequest request) { 

    return authenticationService.authenticate((request));

    } 
    

    @PostMapping("/introspect")
    IntrospectReponse  introspectrequest(@RequestBody IntrospectRequest request) { 

    return authenticationService.introspectReponse((request));


    }
    
}