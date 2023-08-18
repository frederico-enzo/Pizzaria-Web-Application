package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.ItemDTO;
import br.com.pizzariaapi.API.Entity.Item;
import br.com.pizzariaapi.API.Repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
    @Transactional(rollbackFor = Exception.class)
    public Item create(ItemDTO itemDTO) {
        Assert.notNull(itemDTO.getProduto(), "Produto inválida");
        Assert.notNull(itemDTO.getQuantidade(), "Quantidade inválido");

        Item item = modelMapper.map(itemDTO, Item.class);
        return itemRepository.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public Item update(Long id, ItemDTO itemDTO){
        Item validation = itemRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Atributo não encontrado com o ID: " + id));
        Assert.notNull(itemDTO.getProduto(), "Produto inválida");
        Assert.notNull(itemDTO.getQuantidade(), "Quantidade inválido");
        Item item = modelMapper.map(itemDTO, Item.class);
        return itemRepository.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Item validation = itemRepository.findById(id).orElse(null);
        itemRepository.delete(validation);
    }
}
