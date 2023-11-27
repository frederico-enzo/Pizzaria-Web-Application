package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.config.JwtServiceGenerator;
import br.com.pizzariaapi.api.dto.ClienteDTO;
import br.com.pizzariaapi.api.dto.LoginDTO;
import br.com.pizzariaapi.api.entity.Cliente;
import br.com.pizzariaapi.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private JwtServiceGenerator jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    public ClienteDTO logar(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );
        UserDetails userDetails = repository.findByUsername(loginDTO.getUsername());
        Cliente cliente = (Cliente) userDetails;
        var jwtToken = jwtService.generateToken(cliente);

        return toUserDTO(cliente    , jwtToken);
    }


    private ClienteDTO toUserDTO(Cliente user, String token) {
        ClienteDTO userDTO = new ClienteDTO();
        userDTO.setId(user.getId());
        userDTO.setRole(user.getRole());
        userDTO.setToken(token);
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

}