package br.com.ifg.service;

import br.com.ifg.model.dto.LoginDTO;
import br.com.ifg.model.dto.LoginResponseDTO;
import br.com.ifg.model.entity.User;
import br.com.ifg.repository.UserRepository;
import br.com.ifg.util.GenerateToken;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotAuthorizedException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Optional;

@ApplicationScoped
public class LoginService {

    @Inject
    UserRepository userRepository;

    @Inject
    GenerateToken generateToken;

    public LoginResponseDTO login(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findByEmail(loginDTO.getEmail());

        if(userOptional.isEmpty()) {
            throw new NotAuthorizedException("Usuário inexistente");
        }

        if(!BCrypt.checkpw(loginDTO.getPassword(), userOptional.get().getPassword())) {
            throw new NotAuthorizedException("E-mail ou senha incorreto(s)!");
        }

        String token = generateToken.generateTokenJST(userOptional.get());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setEmail(userOptional.get().getEmail());
        response.setToken(token);

        return response;
    }
}
