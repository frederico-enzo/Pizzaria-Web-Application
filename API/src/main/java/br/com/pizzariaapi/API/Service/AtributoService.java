package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.ClienteDTO;
import br.com.pizzariaapi.api.entity.Atributo;
import br.com.pizzariaapi.api.entity.Cliente;
import br.com.pizzariaapi.api.repository.AtributoRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private void idNotNull(Long id){
        org.springframework.util.Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
    private void validationAtributoDTO(AtributoDTO atributoDTO){
        Assert.notNull(atributoDTO.getDescricao(), "Descrição inválida");
        Assert.notNull(atributoDTO.getTamanho(), "Tamanho inválido");
        Assert.notNull(atributoDTO.getPreco(), "Preço inválido");
    }
    @Transactional(rollbackFor = Exception.class)
    public AtributoDTO findById(Long id) {
        Atributo atributo = repository.findById(id).orElse(null);
        return toAtributoDTO(atributo);
    }
    @Transactional(rollbackFor = Exception.class)
    public AtributoDTO post(AtributoDTO atributoDTO) {
        validationAtributoDTO(atributoDTO);
        return toAtributoDTO(repository.save(toAtributo(atributoDTO)));
    }
    @Transactional(rollbackFor = Exception.class)
    public AtributoDTO put(AtributoDTO atributoDTO) {
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
