package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.dto.ProdutoDTO;
import br.com.pizzariaapi.api.entity.*;
import br.com.pizzariaapi.api.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {
    @InjectMocks
    private ItemService service;
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ModelMapper modelMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_Success() {
        Long id = 1L;
        Item item = new Item();
        item.setId(id);
        ItemDTO expectedDto = new ItemDTO();
        expectedDto.setId(id);
        when(itemRepository.findById(id)).thenReturn(java.util.Optional.of(item));
        when(modelMapper.map(item, ItemDTO.class)).thenReturn(expectedDto);
        ItemDTO result = service.findById(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void quantidadeDeSabores_ValidSize_Pequeno() {
        List<Sabor> expectedDtos = new ArrayList<>();
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        ItemDTO itemDTO = new ItemDTO();
        Atributo atributoDTO = new Atributo();
        atributoDTO.setTamanho(Tamanho.PEQUENO);
        itemDTO.setAtributoEspecifico(atributoDTO);
        itemDTO.setSabors(expectedDtos);
        assertThrows(IllegalArgumentException.class, () -> service.quantidadeDeSabores(itemDTO));
    }
    @Test
    void quantidadeDeSabores_ValidSize_MEDIA() {
        List<Sabor> expectedDtos = new ArrayList<>();
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        ItemDTO itemDTO = new ItemDTO();
        Atributo atributoDTO = new Atributo();
        atributoDTO.setTamanho(Tamanho.MEDIA);
        itemDTO.setAtributoEspecifico(atributoDTO);
        itemDTO.setSabors(expectedDtos);
        assertThrows(IllegalArgumentException.class, () -> service.quantidadeDeSabores(itemDTO));
    }
    @Test
    void quantidadeDeSabores_ValidSize_Grande() {
        List<Sabor> expectedDtos = new ArrayList<>();
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        ItemDTO itemDTO = new ItemDTO();
        Atributo atributoDTO = new Atributo();
        atributoDTO.setTamanho(Tamanho.GRANDE);
        itemDTO.setAtributoEspecifico(atributoDTO);
        itemDTO.setSabors(expectedDtos);
        assertThrows(IllegalArgumentException.class, () -> service.quantidadeDeSabores(itemDTO));
    }
    @Test
    void quantidadeDeSabores_ValidSize_Gigante() {
        List<Sabor> expectedDtos = new ArrayList<>();
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        ItemDTO itemDTO = new ItemDTO();
        Atributo atributoDTO = new Atributo();
        atributoDTO.setTamanho(Tamanho.GIGANTE);
        itemDTO.setAtributoEspecifico(atributoDTO);
        itemDTO.setSabors(expectedDtos);
        assertThrows(IllegalArgumentException.class, () -> service.quantidadeDeSabores(itemDTO));
    }


    @Test
    void create_Success() {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setNome("Pizza");

        List<Sabor> expectedDtos = new ArrayList<>();
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProduto(produto);
        itemDTO.setQuantidade(2);
        itemDTO.setSabors(expectedDtos);

        Atributo atributoDTO = new Atributo();
        atributoDTO.setTamanho(Tamanho.PEQUENO);
        itemDTO.setAtributoEspecifico(atributoDTO);

        Produto produt = new Produto();
        Item item = new Item();
        item.setProduto(produt);
        item.setQuantidade(2);
        when(itemRepository.save(any(Item.class))).thenReturn(item);
        String result = service.create(itemDTO);
        assertEquals("Sucesso ao cadastrar novo Registro", result);
    }

    @Test
    void create_ValidationFailed() {
        ItemDTO itemDTO = new ItemDTO();
        assertThrows(IllegalArgumentException.class, () -> service.create(itemDTO));
    }

    @Test
    void update_Success() {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setNome("Pizza");
        List<Sabor> expectedDtos = new ArrayList<>();
        expectedDtos.add(new Sabor());
        expectedDtos.add(new Sabor());
        Long id = 1L;
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProduto(produto);
        itemDTO.setQuantidade(2);
        itemDTO.setSabors(expectedDtos);
        Atributo atributoDTO = new Atributo();
        atributoDTO.setTamanho(Tamanho.PEQUENO);
        itemDTO.setAtributoEspecifico(atributoDTO);
        Produto produt = new Produto();

        Item existingItem = new Item();
        existingItem.setId(id);
        existingItem.setProduto(produt);
        existingItem.setQuantidade(2);

        when(itemRepository.findById(id)).thenReturn(java.util.Optional.of(existingItem));
        when(itemRepository.save(any(Item.class))).thenReturn(existingItem);
        String result = service.update(id, itemDTO);
        assertEquals("Sucesso ao atualizar Registro do ID:" + id + " Cliente", result);
    }

    @Test
    void update_NotFound() {
        ProdutoDTO produto = new ProdutoDTO();
        Long id = 1L;
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProduto(produto);
        itemDTO.setQuantidade(2);
        when(itemRepository.findById(id)).thenReturn(java.util.Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> service.update(id, itemDTO));
    }

    @Test
    void update_ValidationFailed() {
        Long id = 1L;
        ItemDTO itemDTO = new ItemDTO();
        assertThrows(IllegalArgumentException.class, () -> service.update(id, itemDTO));
    }

    @Test
    void delete_Success() {
        Long id = 1L;
        Item existingItem = new Item();
        existingItem.setId(id);

        when(itemRepository.findById(id)).thenReturn(java.util.Optional.of(existingItem));
        assertDoesNotThrow(() -> service.delete(id));
        verify(itemRepository, times(1)).deleteById(id);
    }

    @Test
    void delete_NotFound() {
        Long id = 1L;
        when(itemRepository.findById(id)).thenReturn(java.util.Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> service.delete(id));
    }
}
