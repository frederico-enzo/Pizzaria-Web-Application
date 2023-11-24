package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.service.AtributoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class AtributoControllerTest {

    @InjectMocks
    private AtributoController atributoController;
    @Mock
    private AtributoService atributoService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
     void testGetAtributoById() {
        Long atributoId = 1L;
        AtributoDTO atributoDTO = new AtributoDTO();
        atributoDTO.setId(atributoId);
        when(atributoService.findById(atributoId)).thenReturn(atributoDTO);
        ResponseEntity<AtributoDTO> response = atributoController.getAtributoById(atributoId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(atributoDTO, response.getBody());
        verify(atributoService, times(1)).findById(atributoId);
    }

    @Test
     void testGetAtributoByIdNotFound() {
        Long atributoId = 1L;

        when(atributoService.findById(atributoId)).thenReturn(null);

        ResponseEntity<AtributoDTO> response = atributoController.getAtributoById(atributoId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(atributoService, times(1)).findById(atributoId);
    }

    @Test
     void testCreateAtributo() {
        AtributoDTO atributoDTO = new AtributoDTO();
        AtributoDTO createdAtributoDTO = new AtributoDTO();
        createdAtributoDTO.setId(1L);

        when(atributoService.post(atributoDTO)).thenReturn(createdAtributoDTO);

        ResponseEntity<AtributoDTO> response = atributoController.createAtributo(atributoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdAtributoDTO, response.getBody());

        verify(atributoService, times(1)).post(atributoDTO);
    }

    @Test
     void testUpdateAtributo() {
        Long atributoId = 1L;
        AtributoDTO atributoDTO = new AtributoDTO();
        atributoDTO.setId(atributoId);

        when(atributoService.put(atributoDTO)).thenReturn(atributoDTO);

        ResponseEntity<AtributoDTO> response = atributoController.updateAtributo(atributoId, atributoDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(atributoDTO, response.getBody());

        verify(atributoService, times(1)).put(atributoDTO);
    }

    @Test
     void testDeleteAtributo() {
        Long atributoId = 1L;

        ResponseEntity<Void> response = atributoController.deleteAtributo(atributoId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(atributoService, times(1)).delete(atributoId);
    }
}
