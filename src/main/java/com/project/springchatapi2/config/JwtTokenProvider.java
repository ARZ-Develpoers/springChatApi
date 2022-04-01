package com.project.springchatapi2.config;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${spring.jwt.secret}")
    private String secretKey;

    private long tokenValidMilisecode = 1000L * 6000;

    public String generateToken(String name){
        Date now = new Date();
        return Jwts.builder()
                .setId(name)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMilisecode))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String getUserNameFroJwt(String jwt){
        return getClaims(jwt).getBody().getId();
    }

    public boolean validateToken(String jwt){
        return this.getClaims(jwt) != null;
    }

    private Jws<Claims> getClaims(String jwt){
        try{
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt);
        } catch (SignatureException ex){
            log.error("Invalid JWT signature");
            throw ex;
        } catch (MalformedJwtException ex){
            log.error("Invalid JWT token");
            throw ex;
        } catch (ExpiredJwtException ex){
            log.error("Expired JWT token");
            throw ex;
        } catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT token");
            throw ex;
        } catch (IllegalArgumentException ex){
            log.error("JWT claims string is empty");
            throw ex;
        }
    }
    
}
