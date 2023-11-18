package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.UsuarioDTO;
import br.com.pizzariaapi.api.entity.Usuario;
import br.com.pizzariaapi.api.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    private UsuarioDTO findByID (Long id){
        return toDTO(repository.findById(id).orElse(null));
    }
    private List<UsuarioDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    private UsuarioDTO post(UsuarioDTO usuarioDTO){
        return toDTO(repository.save(toEntity(usuarioDTO)));
    }
    private UsuarioDTO put(UsuarioDTO usuarioDTO, Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        return toDTO(repository.save(toEntity(usuarioDTO)));
    }
    private void delete(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    };




}
