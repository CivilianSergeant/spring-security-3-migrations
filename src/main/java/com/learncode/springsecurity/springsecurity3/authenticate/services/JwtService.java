package com.learncode.springsecurity.springsecurity3.authenticate.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
    
    private static final long ISSUED_AT_MILISECONDS = System.currentTimeMillis();
    private static final long EXPIRATION_IN_MILISECONDS = ISSUED_AT_MILISECONDS+1000*60*30L;
    private static final String SALT="salfliwerksfliregsdgstrttsrtsrtertete";

    public String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String,Object> claims, String username){
        return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(username)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(EXPIRATION_IN_MILISECONDS))
                    .signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
                    
    }

    private Key getSignKey(){
        return Keys.hmacShaKeyFor(SALT.getBytes());
    }

    private Claims extractToken(String token){
        Claims claims = Jwts.parserBuilder().setSigningKey(getSignKey())
                .build().parseClaimsJws(token).getBody();
        return claims;
    }

    private Boolean isTokenExpired(String token){
        System.out.println((new Date()).before(extractExpiration(token)));
        System.out.println(extractExpiration(token)+" ---- "+new Date());
        return (new Date()).before(extractExpiration(token));
    }

    public String extractUsername(String token){
        return extractToken(token).getSubject();
    }

    public Date extractExpiration(String token){
        return extractToken(token).getExpiration();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && isTokenExpired(token));
    }

}
