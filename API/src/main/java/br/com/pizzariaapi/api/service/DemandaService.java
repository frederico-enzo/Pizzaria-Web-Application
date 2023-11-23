package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.DemandaDTO;
import br.com.pizzariaapi.api.entity.Demanda;
import br.com.pizzariaapi.api.repository.DemandaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class DemandaService {
    @Autowired
    private DemandaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    private Demanda toEntity(DemandaDTO itemDTO){
        return modelMapper.map(itemDTO, Demanda.class);
    }
    private DemandaDTO toDTO(Demanda item){
        return modelMapper.map(item, DemandaDTO.class);
    }
    public List<DemandaDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    public DemandaDTO findById(Long id) {
        return toDTO(repository.findById(id).orElse(null));
    }

    public DemandaDTO post(DemandaDTO itemDTO) {
        return toDTO(repository.save(toEntity(itemDTO)));
    }
    public DemandaDTO put(DemandaDTO itemDTO, Long id) {
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        return toDTO(repository.save(toEntity(itemDTO)));
    }
    public void delete(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }
}
