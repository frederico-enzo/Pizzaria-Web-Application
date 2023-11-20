package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.UsuarioDTO;
import br.com.pizzariaapi.api.entity.Usuario;
import br.com.pizzariaapi.api.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.util.Assert;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    private Usuario toEntity(UsuarioDTO usuarioDTO){
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
    private UsuarioDTO toDTO(Usuario usuario){
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    private void Valid(UsuarioDTO usuarioDTO){
        Assert.notNull(usuarioDTO.getLogin(),"Por favor, digite um login!");
        Assert.hasText(usuarioDTO.getLogin(),"Por favor, digite um login válido!");
        Assert.notNull(usuarioDTO.getPassword(),"Por favor, digite um passaword!");
        Assert.hasText(usuarioDTO.getPassword(),"Por favor, digite um passaword válido!");
        Assert.notNull(usuarioDTO.getCpf(),"Por favor, digite um cpf!");
        Assert.hasText(usuarioDTO.getCpf(),"Por favor, digite um cpf válido!");
    }
    public UsuarioDTO findById(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        return toDTO(repository.findById(id).orElse(null));
    }
    public List<UsuarioDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    public UsuarioDTO post(UsuarioDTO usuarioDTO){
        Valid(usuarioDTO);
        return toDTO(repository.save(toEntity(usuarioDTO)));
    }
    public UsuarioDTO put(UsuarioDTO usuarioDTO, Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        Valid(usuarioDTO);
        return toDTO(repository.save(toEntity(usuarioDTO)));
    }
    public void delete(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }


}
