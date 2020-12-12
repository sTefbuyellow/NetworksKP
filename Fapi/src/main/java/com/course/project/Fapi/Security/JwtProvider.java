package com.course.project.Fapi.Security;


import com.course.project.Fapi.exceptions.JksLoadingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

@Service
public class JwtProvider {

    private KeyStore keyStore;

    @PostConstruct
    public void init(){
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/order.jks");
            keyStore.load(resourceAsStream, "colt1911".toCharArray());
        }catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e){
            throw new JksLoadingException("Cannot load keystore");
        }
    }

    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey(){
        try {
            return (PrivateKey) keyStore.getKey("order", "colt1911".toCharArray());
        }catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e){
            throw new JksLoadingException("Cannot get the private key from keystore");
        }
    }

    public boolean validateToken(String jwt){
        Jwts.parser().setSigningKey(getPublicKey()).parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublicKey() {
        try {
            return keyStore.getCertificate("order").getPublicKey();
        } catch (KeyStoreException e){
            throw new JksLoadingException("Cannot get the public key from keystore");
        }
    }

    public String getUsernameFromJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(getPublicKey())
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }
}
