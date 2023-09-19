package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.SaborDTO;
import br.com.pizzariaapi.api.entity.Sabor;
import br.com.pizzariaapi.api.repository.SaborRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaborService {
    @Autowired
    private SaborRepository saborRepository;
    @Autowired
    private ModelMapper modelMapper;
    private Sabor toIngrediente(SaborDTO saborDTO){
        return modelMapper.map(saborDTO, Sabor.class);
    }
    private SaborDTO toIngredienteDTO(Sabor sabor){
        return modelMapper.map(sabor, SaborDTO.class);
    }
    private void idNotNull(Long id){
        Assert.notNull(saborRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
    private void validationIngredienteDTO(SaborDTO saborDTO){
        Assert.notNull(saborDTO.getSabor(),"Ingforme os Sabor!");
        Assert.notNull(saborDTO.getIngrediente(),"Ingforme os ingredientes!");
        Assert.isTrue(!saborDTO.getSabor().isBlank(), "Ingforme o nome do Sabor!");
        Assert.isTrue(!saborDTO.getIngrediente().isEmpty(),"Ingforme os ingredientes!");

    }
    public SaborDTO findById(Long id) {
        Sabor sabor = saborRepository.findById(id).orElse(null);
        return toIngredienteDTO(sabor);
    }
    public List<SaborDTO>findAll(){
        return saborRepository.findAll().stream().map(this::toIngredienteDTO).toList();
    }
    @Transactional(rollbackFor = Exception.class)
    public String create(SaborDTO saborDTO){
        validationIngredienteDTO(saborDTO);
        toIngredienteDTO(saborRepository.save(toIngrediente(saborDTO)));
        return "Sucesso ao cadastrar novo Registro";
    }
    @Transactional(rollbackFor = Exception.class)
    public String update(Long id, SaborDTO saborDTO){
        idNotNull(id);
        validationIngredienteDTO(saborDTO);
        toIngredienteDTO(saborRepository.save(toIngrediente(saborDTO)));
        return "Sucesso ao atualizar Registro do ID:" + id + " Cliente";
    }
    public void delete(Long id){
        idNotNull(id);
        saborRepository.deleteById(id);
    }

}
