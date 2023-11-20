package br.com.pizzariaapi.api.auth;

import br.com.pizzariaapi.api.entity.Role;

public record RegisterDTO(String login, String password, Role role) {
}
