package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.SaborDTO;
import br.com.pizzariaapi.api.entity.Sabor;
import br.com.pizzariaapi.api.repository.SaborRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SaborService {
    @Autowired
    private SaborRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    private Sabor toEntity(SaborDTO saborDTO){
        return modelMapper.map(saborDTO, Sabor.class);
    }
    private SaborDTO toDTO(Sabor sabor){
        return modelMapper.map(sabor, SaborDTO.class);
    }
    public List<SaborDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    public SaborDTO findById(Long id) {
        return toDTO(repository.findById(id).orElse(null));
    }

    public SaborDTO post(SaborDTO saborDTO) {
        return toDTO(repository.save(toEntity(saborDTO)));
    }
    public SaborDTO put(SaborDTO saborDTO,Long id) {
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        return toDTO(repository.save(toEntity(saborDTO)));
    }
    public void delete(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }

}
