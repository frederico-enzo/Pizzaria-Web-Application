package br.com.pizzariaapi.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
 class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetItemById() {
        Long itemId = 1L;
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(itemId);

        when(itemService.findById(itemId)).thenReturn(itemDTO);

        ResponseEntity<ItemDTO> response = itemController.getItemById(itemId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(itemDTO, response.getBody());

        verify(itemService, times(1)).findById(itemId);
    }

    @Test
    void testCreateItem() {
        ItemDTO itemDTO = new ItemDTO();
        String responseMessage = "Item criado com sucesso.";

        when(itemService.create(itemDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = itemController.createItem(itemDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(itemService, times(1)).create(itemDTO);
    }

    @Test
    void testUpdateItem() {
        Long itemId = 1L;
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(itemId);
        String responseMessage = "Item atualizado com sucesso.";

        when(itemService.update(itemId, itemDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = itemController.updateItem(itemId, itemDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(itemService, times(1)).update(itemId, itemDTO);
    }

    @Test
     void testDeleteItem() {
        Long itemId = 1L;

        ResponseEntity<Void> response = itemController.deleteItem(itemId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(itemService, times(1)).delete(itemId);
    }
}
