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

import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private ModelMapper modelMapper;
    private Ingrediente toIngrediente(IngredientesDTO ingredientesDTO){
        return modelMapper.map(ingredientesDTO, Ingrediente.class);
    }
    private IngredientesDTO toIngredienteDTO(Ingrediente ingrediente){
        return modelMapper.map(ingrediente, IngredientesDTO.class);
    }
    private void idNotNull(Long id){
        Assert.notNull(ingredienteRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
    private void validationIngredienteDTO(IngredientesDTO ingredientesDTO){
        Assert.notNull(ingredientesDTO.getSabor(),"Ingforme os Sabor!");
        Assert.notNull(ingredientesDTO.getIngrediente(),"Ingforme os ingredientes!");
        Assert.isTrue(!ingredientesDTO.getSabor().isBlank(), "Ingforme o nome do Sabor!");
        Assert.isTrue(!ingredientesDTO.getIngrediente().isEmpty(),"Ingforme os ingredientes!");

    }
    public IngredientesDTO findById(Long id) {
        Ingrediente ingrediente = ingredienteRepository.findById(id).orElse(null);
        return toIngredienteDTO(ingrediente);
    }
    public List<IngredientesDTO>findAll(){
        return ingredienteRepository.findAll().stream().map(this::toIngredienteDTO).toList();
    }
    @Transactional(rollbackFor = Exception.class)
    public String create(IngredientesDTO ingredientesDTO){
        validationIngredienteDTO(ingredientesDTO);
        toIngredienteDTO(ingredienteRepository.save(toIngrediente(ingredientesDTO)));
        return "Sucesso ao cadastrar novo Registro";
    }
    @Transactional(rollbackFor = Exception.class)
    public String update(Long id, IngredientesDTO ingredientesDTO){
        idNotNull(id);
        validationIngredienteDTO(ingredientesDTO);
        toIngredienteDTO(ingredienteRepository.save(toIngrediente(ingredientesDTO)));
        return "Sucesso ao atualizar Registro do ID:" + id + " Cliente";
    }
    public void delete(Long id){
        idNotNull(id);
        ingredienteRepository.deleteById(id);
    }

}
