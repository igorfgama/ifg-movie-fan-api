package br.com.ifg.util;

import br.com.ifg.model.entity.User;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class GenerateToken {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    public String generateTokenJST(User user) {
        String token =
                Jwt.issuer(issuer)
                        .expiresAt(Instant.now().plus(Duration.ofMinutes(15)))
                        .upn(user.getEmail())
                        .groups(new HashSet<>(Arrays.asList("User")))
                        .claim(Claims.birthdate.name(), LocalDate.now())
                        .sign();
        System.out.println(token);

        return token;
    }
}
