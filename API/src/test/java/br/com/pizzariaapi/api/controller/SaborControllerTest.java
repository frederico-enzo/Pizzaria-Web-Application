package br.com.pizzariaapi.api.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class SaborControllerTest {

    @InjectMocks
    private SaborController saborController;

    @Mock
    private SaborService saborService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testGetSaborById() {
        Long saborId = 1L;
        SaborDTO saborDTO = new SaborDTO();
        saborDTO.setId(saborId);

        when(saborService.findById(saborId)).thenReturn(saborDTO);

        ResponseEntity<SaborDTO> response = saborController.getSaborById(saborId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(saborDTO, response.getBody());

        verify(saborService, times(1)).findById(saborId);
    }

    @Test
     void testGetAllSabores() {
        List<SaborDTO> saborDTOs = new ArrayList<>();
        saborDTOs.add(new SaborDTO());
        saborDTOs.add(new SaborDTO());

        when(saborService.findAll()).thenReturn(saborDTOs);

        ResponseEntity<List<SaborDTO>> response = saborController.getAllSabores();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(saborDTOs, response.getBody());

        verify(saborService, times(1)).findAll();
    }

    @Test
     void testCreateSabor() {
        SaborDTO saborDTO = new SaborDTO();
        String responseMessage = "Sabor criado com sucesso.";

        when(saborService.create(saborDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = saborController.createSabor(saborDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(saborService, times(1)).create(saborDTO);
    }

    @Test
     void testUpdateSabor() {
        Long saborId = 1L;
        SaborDTO saborDTO = new SaborDTO();
        saborDTO.setId(saborId);
        String responseMessage = "Sabor atualizado com sucesso.";

        when(saborService.update(saborId, saborDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = saborController.updateSabor(saborId, saborDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(saborService, times(1)).update(saborId, saborDTO);
    }

    @Test
     void testDeleteSabor() {
        Long saborId = 1L;

        ResponseEntity<Void> response = saborController.deleteSabor(saborId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(saborService, times(1)).delete(saborId);
    }
}
