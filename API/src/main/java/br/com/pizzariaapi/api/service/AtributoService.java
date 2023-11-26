package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.ClienteDTO;
import br.com.pizzariaapi.api.entity.Atributo;
import br.com.pizzariaapi.api.entity.Tamanho;
import br.com.pizzariaapi.api.repository.AtributoRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtributoService {
    @Autowired
    private AtributoRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    private Atributo toAtributo(AtributoDTO atributoDTO){
        return modelMapper.map(atributoDTO, Atributo.class);
    }
    private AtributoDTO toAtributoDTO(Atributo atributo){
        return modelMapper.map(atributo, AtributoDTO.class);
    }
    public List<AtributoDTO> findAll(){
        return repository.findAll().stream().map(this::toAtributoDTO).toList();
    }

    void idNotNull(Long id){
        org.springframework.util.Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
     void validationAtributoDTO(AtributoDTO atributoDTO){
        Assert.notNull(atributoDTO.getTamanho(), "Tamanho inválido");
    }
    void setDescricao(AtributoDTO atributo) {
        Tamanho tamanho = atributo.getTamanho();
        switch (tamanho) {
            case PEQUENO:
                atributo.setDescricao("25 cm, 4 fatias – até 2 sabores.");
                atributo.setPreco(10.0);
                break;
            case MEDIA:
                atributo.setDescricao("30 cm, 6 fatias – até 3 sabores.");
                atributo.setPreco(20.0);
                break;
            case GRANDE:
                atributo.setDescricao("35 cm, 8 fatias – até 3 sabores.");
                atributo.setPreco(35.0);
                break;
            case GIGANTE:
                atributo.setDescricao("50 cm, 12 fatias – até 4 sabores.");
                atributo.setPreco(55.0);
                break;
            default:
                break;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public AtributoDTO findById(Long id) {
        Atributo atributo = repository.findById(id).orElse(null);
        return toAtributoDTO(atributo);
    }
    @Transactional(rollbackFor = Exception.class)
    public AtributoDTO post(AtributoDTO atributoDTO) {
        setDescricao(atributoDTO);
        validationAtributoDTO(atributoDTO);
        return toAtributoDTO(repository.save(toAtributo(atributoDTO)));
    }
    @Transactional(rollbackFor = Exception.class)
    public AtributoDTO put(AtributoDTO atributoDTO,Long id) {
        idNotNull(atributoDTO.getId());
        validationAtributoDTO(atributoDTO);
        return toAtributoDTO(repository.save(toAtributo(atributoDTO)));
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        idNotNull(id);
        repository.deleteById(id);
    }

}
