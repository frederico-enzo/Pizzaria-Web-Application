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

 class EnderecoControllerTest {

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoService enderecoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testGetEnderecoById() {
        Long enderecoId = 1L;
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(enderecoId);

        when(enderecoService.findById(enderecoId)).thenReturn(enderecoDTO);

        ResponseEntity<EnderecoDTO> response = enderecoController.getEnderecoById(enderecoId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(enderecoDTO, response.getBody());

        verify(enderecoService, times(1)).findById(enderecoId);
    }

    @Test
     void testGetAllEnderecos() {
        List<EnderecoDTO> enderecoDTOs = new ArrayList<>();
        enderecoDTOs.add(new EnderecoDTO());
        enderecoDTOs.add(new EnderecoDTO());

        when(enderecoService.findAll()).thenReturn(enderecoDTOs);

        ResponseEntity<List<EnderecoDTO>> response = enderecoController.getAllEnderecos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(enderecoDTOs, response.getBody());

        verify(enderecoService, times(1)).findAll();
    }

    @Test
     void testCreateEndereco() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        String responseMessage = "Endereço criado com sucesso.";

        when(enderecoService.create(enderecoDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = enderecoController.createEndereco(enderecoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(enderecoService, times(1)).create(enderecoDTO);
    }

    @Test
     void testUpdateEndereco() {
        Long enderecoId = 1L;
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(enderecoId);
        String responseMessage = "Endereço atualizado com sucesso.";

        when(enderecoService.update(enderecoId, enderecoDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = enderecoController.updateEndereco(enderecoId, enderecoDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(enderecoService, times(1)).update(enderecoId, enderecoDTO);
    }

    @Test
     void testDeleteEndereco() {
        Long enderecoId = 1L;

        ResponseEntity<Void> response = enderecoController.deleteEndereco(enderecoId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(enderecoService, times(1)).delete(enderecoId);
    }
}
