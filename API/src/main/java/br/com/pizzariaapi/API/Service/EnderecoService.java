package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Entity.Endereco;
import br.com.pizzariaapi.API.Repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ModelMapper modelMapper;

    private Endereco toEndereco(EnderecoDTO enderecoDTO){
        return modelMapper.map(enderecoDTO, Endereco.class);
    }
    private EnderecoDTO toEnderecoDTO(Endereco endereco){
        return modelMapper.map(endereco, EnderecoDTO.class);
    }
    private void validationEnderecoDTO(EnderecoDTO enderecoDTO){
        Assert.isTrue(!enderecoDTO.getRua().isBlank(), "Informe o Rua!");
        Assert.isTrue(!enderecoDTO.getCep().isBlank(), "Informe o Cep!");
        Assert.isTrue(!enderecoDTO.getBairro().isBlank(), "Informe o Bairro!");
    }
    public EnderecoDTO findById(Long id){
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        return toEnderecoDTO(endereco);
    }
    public List<EnderecoDTO> findAll(){
        return enderecoRepository.findAll().stream().map(this::toEnderecoDTO).toList();
    }
    @Transactional(rollbackFor = Exception.class)
    public String create(EnderecoDTO enderecoDTO){
        validationEnderecoDTO(enderecoDTO);
        toEnderecoDTO(enderecoRepository.save(toEndereco(enderecoDTO)));
        return "Sucesso ao cadastrar novo Registro";
    }
    @Transactional(rollbackFor = Exception.class)
    public String update(Long id, EnderecoDTO enderecoDTO){
        validationEnderecoDTO(enderecoDTO);
        toEnderecoDTO(enderecoRepository.save(toEndereco(enderecoDTO)));
        return "Sucesso ao atualizar Registro do ID:" + id + " Cliente";
    }
    public void delete(Long id){
        Assert.notNull(enderecoRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado", id));
        enderecoRepository.deleteById(id);
    }



}
