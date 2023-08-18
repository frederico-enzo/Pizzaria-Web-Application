package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.IngredientesDTO;
import br.com.pizzariaapi.API.Entity.Cliente;
import br.com.pizzariaapi.API.Entity.Endereco;
import br.com.pizzariaapi.API.Entity.Ingrediente;
import br.com.pizzariaapi.API.Repository.IngredienteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional(rollbackFor = Exception.class)
    public Ingrediente findById(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }
    @Transactional(rollbackFor = Exception.class)
    public Ingrediente create(IngredientesDTO ingredientesDTO){
        Assert.notNull(ingredientesDTO.getIngrediente(), "Ingredeiente inválido");
        Ingrediente ingrediente = modelMapper.map(ingredientesDTO, Ingrediente.class);
        return ingredienteRepository.save(ingrediente);
    }
    @Transactional(rollbackFor = Exception.class)
    public Ingrediente update(Long id, IngredientesDTO ingredientesDTO){
        Ingrediente validation = ingredienteRepository.findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("Ingredeiente não encontrado com o ID: " + id));
        Assert.notNull(ingredientesDTO.getIngrediente(), "Ingredeiente inválido");
        Ingrediente ingrediente = modelMapper.map(ingredientesDTO, Ingrediente.class);
        return ingredienteRepository.save(ingrediente);
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Ingrediente validation = ingredienteRepository.findById(id).orElse(null);
        ingredienteRepository.delete(validation);
    }

}
