package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Entity.Cliente;
import br.com.pizzariaapi.API.Entity.Endereco;
import br.com.pizzariaapi.API.Repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Endereco findById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }
    @Transactional(rollbackFor = Exception.class)
    public Endereco create(EnderecoDTO enderecoDTO){
        Assert.notNull(enderecoDTO.getBairro(), "Bairro inválido");
        Assert.notNull(enderecoDTO.getRua(), "Rua inválido");
        Assert.notNull(enderecoDTO.getNumero(), "Numero inválido");
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);

        return enderecoRepository.save(endereco);
    }





}
