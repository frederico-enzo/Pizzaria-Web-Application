package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.EnderecoDTO;
import br.com.pizzariaapi.api.entity.Endereco;
import br.com.pizzariaapi.api.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    private Endereco toEntity(EnderecoDTO enderecoDTO){
        return modelMapper.map(enderecoDTO, Endereco.class);
    }
    private EnderecoDTO toDTO(Endereco endereco){
        return modelMapper.map(endereco, EnderecoDTO.class);
    }
    private void Valid(EnderecoDTO enderecoDTO){
        Assert.notNull(enderecoDTO.getBairro(), "Informe o Bairro!");
        Assert.hasText(enderecoDTO.getBairro(), "Informe o Bairro!");
        Assert.notNull(enderecoDTO.getNumero(), "Informe o Numero!");
        Assert.notNull(enderecoDTO.getCep(), "Informe o Cep!");
        Assert.notNull(enderecoDTO.getRua(), "Informe o Rua!");
        Assert.hasText(enderecoDTO.getRua(), "Informe o Rua!");
    }
    public EnderecoDTO findById(Long id){
        Endereco endereco = repository.findById(id).orElse(null);
        return toDTO(endereco);
    }
    public List<EnderecoDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    @Transactional(rollbackFor = Exception.class)
    public EnderecoDTO post(EnderecoDTO enderecoDTO){
        Valid(enderecoDTO);
        return toDTO(repository.save(toEntity(enderecoDTO)));
    }
    @Transactional(rollbackFor = Exception.class)
    public EnderecoDTO put(Long id, EnderecoDTO enderecoDTO){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        Valid(enderecoDTO);
        return toDTO(repository.save(toEntity(enderecoDTO)));
    }
    public void delete(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }

}