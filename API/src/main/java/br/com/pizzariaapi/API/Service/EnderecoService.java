package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Entity.ClienteEntity;
import br.com.pizzariaapi.API.Entity.EnderecoEntity;
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

    @Transactional(rollbackFor = Exception.class)
    public EnderecoEntity findById(Long id){
        final EnderecoEntity endereco  = enderecoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Endereço não encontrado com o ID: \" + id"));
        return endereco;
    }
    @Transactional(rollbackFor = Exception.class)
    public EnderecoEntity create(EnderecoDTO enderecoDTO){

        Assert.notNull(enderecoDTO.getBairro(), "Bairro inválido");
        Assert.notNull(enderecoDTO.getRua(), "Rua inválido");
        Assert.notNull(enderecoDTO.getNumero(), "Numero inválido");

        EnderecoEntity endereco = modelMapper.map(enderecoDTO, EnderecoEntity.class);

        return enderecoRepository.save(endereco);
    }





    public EnderecoEntity update(EnderecoDTO enderecoDTO){return null;}
    public void delete(Long id){}

}
