package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.entity.Item;
import br.com.pizzariaapi.api.entity.Tamanho;
import br.com.pizzariaapi.api.repository.ItemRepository;
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
    private Item toItem(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, Item.class);
    }
    private ItemDTO toItemDTO(Item item){
        return modelMapper.map(item, ItemDTO.class);
    }
    private void idNotNull(Long id){
    Assert.notNull(itemRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
     void quantidadeDeSabores(ItemDTO itemDTO) {
        int maxSabores = 0;
        Tamanho tamanho = itemDTO.getAtributoEspecifico().getTamanho();
        if (tamanho == Tamanho.GIGANTE) {
            maxSabores = 5;
        } else if (tamanho == Tamanho.GRANDE) {
            maxSabores = 4;
        } else if (tamanho == Tamanho.MEDIA) {
            maxSabores = 4;
        } else if (tamanho == Tamanho.PEQUENO) {
            maxSabores = 3;
        }
        if (itemDTO.getSabors().size() < maxSabores) {
            throw new IllegalArgumentException("O tamanho " + tamanho + " é permitido somente " + maxSabores + " sabores");
        }
    }
    private void validationItemDTO(ItemDTO itemDTO){
        Assert.notNull(itemDTO.getProduto(), "Produto inválida");
        Assert.notNull(itemDTO.getQuantidade(), "Quantidade inválido");
        Assert.notNull(itemDTO.getSabors(), "Sabor inválido");
        Assert.notNull(itemDTO.getAtributoEspecifico(), "Atributo inválido");

    }
    public ItemDTO findById(Long id) {
        return toItemDTO(itemRepository.findById(id).orElse(null));
    }
    @Transactional(rollbackFor = Exception.class)
    public String create(ItemDTO itemDTO) {
        validationItemDTO(itemDTO);
        toItemDTO(itemRepository.save(toItem(itemDTO)));
        return "Sucesso ao cadastrar novo Registro";
    }
    @Transactional(rollbackFor = Exception.class)
    public String update(Long id, ItemDTO itemDTO){
        idNotNull(id);
        validationItemDTO(itemDTO);
        toItemDTO(itemRepository.save(toItem(itemDTO)));
        return "Sucesso ao atualizar Registro do ID:" + id + " Cliente";
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        idNotNull(id);
        itemRepository.deleteById(id);
    }
}