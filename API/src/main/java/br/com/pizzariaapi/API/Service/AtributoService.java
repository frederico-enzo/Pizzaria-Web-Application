package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.AtributoDTO;
import br.com.pizzariaapi.API.DTO.IngredientesDTO;
import br.com.pizzariaapi.API.Entity.Atributo;
import br.com.pizzariaapi.API.Entity.Cliente;
import br.com.pizzariaapi.API.Entity.Ingrediente;
import br.com.pizzariaapi.API.Repository.AtributoRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtributoService {
    @Autowired
    private AtributoRepository atributoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional(rollbackFor = Exception.class)
    public Atributo findById(Long id) {
        return atributoRepository.findById(id).orElse(null);
    }
    @Transactional(rollbackFor = Exception.class)
    public Atributo create(AtributoDTO atributoDTO){
        Assert.notNull(atributoDTO.getDescricao(),"Descrição inválida");
        Assert.notNull(atributoDTO.getTamanho(),"Tamanho inválida");
        Assert.notNull(atributoDTO.getDescricao(),"Descrição inválida");
        Atributo atributo = modelMapper.map(atributoDTO, Atributo.class);
        return atributoRepository.save(atributo);
    }
    @Transactional(rollbackFor = Exception.class)
    public Atributo update(Long id, AtributoDTO atributoDTO){
        Atributo validation = atributoRepository.findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("Atributo não encontrado com o ID: " + id));
        Assert.notNull(atributoDTO.getDescricao(),"Descrição inválida");
        Assert.notNull(atributoDTO.getTamanho(),"Tamanho inválida");
        Assert.notNull(atributoDTO.getDescricao(),"Descrição inválida");
        Atributo atributo = modelMapper.map(atributoDTO, Atributo.class);
        return atributoRepository.save(atributo);
    }



    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Atributo validation = atributoRepository.findById(id).orElse(null);
        atributoRepository.delete(validation);
    }


}
