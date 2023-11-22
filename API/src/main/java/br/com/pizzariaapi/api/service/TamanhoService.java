package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.PropriedadeDTO;
import br.com.pizzariaapi.api.dto.TamanhoDTO;
import br.com.pizzariaapi.api.entity.Propriedade;
import br.com.pizzariaapi.api.entity.Tamanho;
import br.com.pizzariaapi.api.repository.TamanhoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TamanhoService {
    @Autowired
    private TamanhoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    private Tamanho toEntity(TamanhoDTO tamanhoDTO){
        return modelMapper.map(tamanhoDTO, Tamanho.class);
    }
    private TamanhoDTO toDTO(Tamanho tamanho){
        return modelMapper.map(tamanho, TamanhoDTO.class);
    }
    public List<TamanhoDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    public TamanhoDTO findById(Long id) {
        return toDTO(repository.findById(id).orElse(null));
    }

    public TamanhoDTO post(TamanhoDTO tamanhoDTO) {
        return toDTO(repository.save(toEntity(tamanhoDTO)));
    }
    public TamanhoDTO put(TamanhoDTO tamanhoDTO,Long id) {
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        return toDTO(repository.save(toEntity(tamanhoDTO)));
    }
    public void delete(Long id){
        org.springframework.util.Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }

}
