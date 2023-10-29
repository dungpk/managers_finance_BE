package com.example.cg_finance_managers.cofig;

import com.example.cg_finance_managers.model.User;
import com.example.cg_finance_managers.service.user.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class Jwt {
    @Autowired
    private IUserService userService;
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private static final long EXPIRATION_TIME_MS = 3600000;
//Phuong thuc tao JWT
    public static String createJWT(User user) {
        Date now = new Date();
        Date expirationTime = new Date(now.getTime() + EXPIRATION_TIME_MS);
        return Jwts.builder()
                .setSubject(user.getPassword())
                .setIssuer(user.getEmail())
                .setIssuedAt(now)
                .setExpiration(expirationTime)
                .claim("email", user.getEmail())
                .claim("password", user.getPassword())
                .signWith(SECRET_KEY)
                .compact();
    }
    // Giải mã JWT
    public static Claims decryptionJwt(String jwt) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build().parseClaimsJws(jwt);
        Claims claimsJwt = claimsJws.getBody();
        Date expirationDate = claimsJwt.getExpiration();
        Date date = new Date();
        if (date.before(expirationDate)) {
            // JWT is still valid
        }
        return claimsJwt;
    }
//    Phuong thuc dung de giải
    public String checkAuthenticateRequest(HttpServletRequest request){
        String jwt=extractJWTFromRequest(request);
        if(jwt!=null){
            Claims claims=decryptionJwt(jwt);
            String email=claims.get("email",String.class);
            String password=claims.get("password",String.class);
            userService.checkIsValidUser(email,password);
            return email;
        }
        return null;
    }
//    / Phương thức trích JWT từ tiêu đề (Yêu cầu gửi về)
    public static String extractJWTFromRequest(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7).trim(); // Loại bỏ "Bearer " để lấy JWT
        }
        return null;
    }
}
