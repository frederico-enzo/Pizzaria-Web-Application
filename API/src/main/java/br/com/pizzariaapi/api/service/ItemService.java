package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.dto.SaborDTO;
import br.com.pizzariaapi.api.entity.Item;
import br.com.pizzariaapi.api.entity.Sabor;
import br.com.pizzariaapi.api.repository.ItemRepository;
import br.com.pizzariaapi.api.repository.SaborRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    private Item toEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, Item.class);
    }
    private ItemDTO toDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }
    public List<ItemDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }
    public ItemDTO findById(Long id) {
        return toDTO(repository.findById(id).orElse(null));
    }

    public ItemDTO post(ItemDTO itemDTO) {
        return toDTO(repository.save(toEntity(itemDTO)));
    }
    public ItemDTO put(ItemDTO itemDTO,Long id) {
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        return toDTO(repository.save(toEntity(itemDTO)));
    }
    public void delete(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }
}
