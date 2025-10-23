package com.erp.infrastructure.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Value("${jwt.secret}") //Se hace lectura desde el application.properties
    private String SECRET_KEY;


    
}
