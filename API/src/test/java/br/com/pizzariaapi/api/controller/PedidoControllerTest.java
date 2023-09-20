package br.com.pizzariaapi.api.controller;

import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class PedidoControllerTest {

    @InjectMocks
    private PedidoController pedidoController;

    @Mock
    private PedidoService pedidoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPedidoById() {
        Long pedidoId = 1L;
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedidoId);

        when(pedidoService.findById(pedidoId)).thenReturn(pedidoDTO);

        ResponseEntity<PedidoDTO> response = pedidoController.getPedidoById(pedidoId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pedidoDTO, response.getBody());

        verify(pedidoService, times(1)).findById(pedidoId);
    }

    @Test
    void testCreatePedido() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        String responseMessage = "Pedido criado com sucesso.";

        when(pedidoService.create(pedidoDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = pedidoController.createPedido(pedidoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(pedidoService, times(1)).create(pedidoDTO);
    }

    @Test
    void testUpdatePedido() {
        Long pedidoId = 1L;
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedidoId);
        String responseMessage = "Pedido atualizado com sucesso.";

        when(pedidoService.update(pedidoId, pedidoDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = pedidoController.updatePedido(pedidoId, pedidoDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(pedidoService, times(1)).update(pedidoId, pedidoDTO);
    }

    @Test
    void testDeletePedido() {
        Long pedidoId = 1L;

        ResponseEntity<Void> response = pedidoController.deletePedido(pedidoId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(pedidoService, times(1)).delete(pedidoId);
    }
}
