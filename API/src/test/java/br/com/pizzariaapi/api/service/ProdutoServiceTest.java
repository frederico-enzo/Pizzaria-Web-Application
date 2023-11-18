package br.com.pizzariaapi.api.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {
    @InjectMocks
    ProdutoService service;
    @Mock
    ProdutoRepository repository;
    @Mock
    ModelMapper modelMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void create_ValidProdutoDTO_ReturnsSuccessMessage() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Pizza Margherita");
        produtoDTO.setCategoria("Pizza");
        produtoDTO.setDisponivel(true);
        produtoDTO.setTempoPreparo(30);
        when(repository.save(any(Produto.class))).thenReturn(new Produto());
        when(modelMapper.map(any(ProdutoDTO.class), eq(Produto.class))).thenReturn(new Produto());
        String result = service.create(produtoDTO);
        assertEquals("Sucesso ao cadastrar novo Registro", result);
    }
    @Test
    void update_ValidProdutoDTO_ReturnsSuccessMessage() {
        Long id = 1L;
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Pizza Margherita");
        produtoDTO.setCategoria("Pizza");
        produtoDTO.setDisponivel(true);
        produtoDTO.setTempoPreparo(30);
        Produto existingProduto = new Produto();
        existingProduto.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(existingProduto));
        when(repository.save(any(Produto.class))).thenReturn(existingProduto);
        when(modelMapper.map(any(ProdutoDTO.class), eq(Produto.class))).thenReturn(existingProduto);

        String result = service.update(id, produtoDTO);


        assertEquals("Sucesso ao cadastrar novo Registro", result);
    }
    @Test
    void delete_ValidId_SuccessfullyDeletes() {
        Long id = 1L;
        Produto existingProduto = new Produto();
        existingProduto.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(existingProduto));
        service.delete(id);
        verify(repository, times(1)).deleteById(id);
    }
    @Test
    void findById_ValidId_ReturnsProdutoDTO() {
        Long id = 1L;
        Produto existingProduto = new Produto();
        existingProduto.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(existingProduto));
        when(modelMapper.map(existingProduto, ProdutoDTO.class)).thenReturn(new ProdutoDTO());
        ProdutoDTO result = service.findById(id);
        assertNotNull(result);
    }

    @Test
    void delete_WhenSaborNotFound_ShouldThrowException() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> {
            service.delete(id);
        });
    }

}
