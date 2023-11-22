package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.PropriedadeDTO;
import br.com.pizzariaapi.api.entity.Propriedade;
import br.com.pizzariaapi.api.repository.PropriedadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropriedadeService {
    @Autowired
    private PropriedadeRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    private Propriedade toEntity(PropriedadeDTO propriedadeDTO){
        return modelMapper.map(propriedadeDTO, Propriedade.class);
    }
    private PropriedadeDTO toDTO(Propriedade propriedade){
        return modelMapper.map(propriedade, PropriedadeDTO.class);
    }
    public List<PropriedadeDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    public PropriedadeDTO findById(Long id) {
        return toDTO(repository.findById(id).orElse(null));
    }

    public PropriedadeDTO post(PropriedadeDTO propriedadeDTO) {
        return toDTO(repository.save(toEntity(propriedadeDTO)));
    }
    public PropriedadeDTO put(PropriedadeDTO propriedadeDTO,Long id) {
        org.springframework.util.Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        return toDTO(repository.save(toEntity(propriedadeDTO)));
    }
    public void delete(Long id){
        org.springframework.util.Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }
}
