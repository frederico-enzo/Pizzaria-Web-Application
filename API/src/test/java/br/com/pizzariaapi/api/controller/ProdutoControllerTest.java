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

 class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetProdutoById() {
        Long produtoId = 1L;
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoId);

        when(produtoService.findById(produtoId)).thenReturn(produtoDTO);

        ResponseEntity<ProdutoDTO> response = produtoController.getProdutoById(produtoId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produtoDTO, response.getBody());

        verify(produtoService, times(1)).findById(produtoId);
    }

    @Test
    void testCreateProduto() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        String responseMessage = "Produto criado com sucesso.";

        when(produtoService.create(produtoDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = produtoController.createProduto(produtoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(produtoService, times(1)).create(produtoDTO);
    }

    @Test
    void testUpdateProduto() {
        Long produtoId = 1L;
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoId);
        String responseMessage = "Produto atualizado com sucesso.";

        when(produtoService.update(produtoId, produtoDTO)).thenReturn(responseMessage);

        ResponseEntity<String> response = produtoController.updateProduto(produtoId, produtoDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());

        verify(produtoService, times(1)).update(produtoId, produtoDTO);
    }

    @Test
    void testDeleteProduto() {
        Long produtoId = 1L;

        ResponseEntity<Void> response = produtoController.deleteProduto(produtoId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(produtoService, times(1)).delete(produtoId);
    }
}
