package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Entity.Endereco;
import br.com.pizzariaapi.API.Repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
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
        validationEnderecoDTO(enderecoDTO);
        Endereco endereco = toEndereco(enderecoDTO);
        return enderecoRepository.save(endereco);
    }
    @Transactional(rollbackFor = Exception.class)
    public Endereco update(Long id, EnderecoDTO enderecoDTO){
        final Endereco validation = enderecoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Endereco não encontrado com o ID: " + id));
        validationEnderecoDTO(enderecoDTO);
        Endereco endereco = toEndereco(enderecoDTO);
        return enderecoRepository.save(endereco);
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Endereco validation = enderecoRepository.findById(id).orElse(null);
        enderecoRepository.delete(validation);
    }
    private Endereco toEndereco(EnderecoDTO enderecoDTO){
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        return endereco;
    }
    private EnderecoDTO toEndrecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
        return enderecoDTO;
    }
    private void validationEnderecoDTO(EnderecoDTO enderecoDTO){
        assert StringUtils.isBlank(enderecoDTO.getRua()) : "Rua inválido";
        assert StringUtils.isBlank(enderecoDTO.getBairro()) : "Rua inválido";
        Assert.notNull(enderecoDTO.getNumero(), "Numero inválido");
    }
}
