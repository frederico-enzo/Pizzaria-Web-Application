package br.com.pizzariaapi.api.Authentication;


import br.com.pizzariaapi.api.entity.Role;

public record RegisterDTO(String login, String password, Role role) {

}
