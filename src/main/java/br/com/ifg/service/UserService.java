package br.com.ifg.service;

import br.com.ifg.model.dto.UserDTO;
import br.com.ifg.model.dto.UserResponseDTO;
import br.com.ifg.model.entity.User;
import br.com.ifg.repository.UserRepository;
import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotAuthorizedException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public UserResponseDTO create(UserDTO userDTO) {
        if(userDTO == null) {
            throw new RuntimeException("REQUISIÇÃO NULA");
        }

        Optional<User> userOptional = userRepository.findByEmail(userDTO.getEmail());

        if(userOptional.isPresent()) {
            throw new RuntimeException("Usuário já existente!");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()));
        user.setSex(userDTO.getSex());

        userRepository.persist(user);

        UserResponseDTO userResponse = new UserResponseDTO();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setSex(user.getSex());

        return userResponse;
    }
}
