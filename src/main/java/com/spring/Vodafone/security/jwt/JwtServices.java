package com.spring.Vodafone.security.jwt;
import com.spring.Vodafone.security.model.entity.AppUser;
import com.spring.Vodafone.security.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServices {

    private static final String SECRET_KEY = "LLMk0WHH53SWsBi2tlLXbI1UVO7UVpult765D7GFFgeBcxPLlBAdlZI97eleAkJijh";

    private static final Long EXPIRATION_TIME = 36000L;
    private final UserRepository userRepository;

    public JwtServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extractClaim, UserDetails userDetails) {
        AppUser user = userRepository.findByUsername(userDetails.getUsername()).get();
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", user.getName());
        claims.put("id", user.getId().toString());
        return Jwts.builder()
                .setId(user.getId().toString())
                .setClaims(extractClaim)
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * EXPIRATION_TIME)))
                .signWith(getSercurtKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractEXPIRATION(token).before(new Date());
    }

    private Date extractEXPIRATION(String token) {

        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsTResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsTResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSercurtKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSercurtKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractRole(String token) {
        return extractClaim(token, claims -> claims.get("authority", String.class));
    }

}
