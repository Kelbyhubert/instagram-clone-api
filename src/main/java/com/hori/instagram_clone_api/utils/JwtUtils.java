package com.hori.instagram_clone_api.utils;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.hori.instagram_clone_api.auth.model.AuthDetail;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    @Value("${ig.jwt.secretkey}")
    private String secretKey;

    @Value("${ig.jwt.jwtExpirationMs}")
    private int jwtExpiredDate;

    public String generateJwtToken(Authentication auth){

        AuthDetail authDetail = (AuthDetail) auth.getPrincipal();

        return generateTokenFromUserDetail(authDetail);
    }

    public String generateTokenFromUserDetail(AuthDetail authDetail) {
        return Jwts.builder()
                .setSubject(authDetail.getUserId().toString())
                .claim("username", authDetail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiredDate))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    public Claims getToken(String token) {

        token = token.replace("Bearer ","");
        
        System.out.println(token);
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
    }

    public Long getTokenSubject(String token){
        return Long.parseLong(getToken(token).getSubject());
    }


    public String getTokenClaim(String token , String claimKey){
        Claims claims = getToken(token);
        
        return (String) claims.get(claimKey);
    }

    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
