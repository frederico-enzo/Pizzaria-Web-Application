package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.entity.Pedido;
import br.com.pizzariaapi.api.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PedidoServiceTest {
    @InjectMocks
    PedidoService service;
    @Mock
    PedidoRepository repository;
    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void findById() {
        Long id = 1L;
        Pedido pedido = new Pedido();
        pedido.setId(id);
        PedidoDTO expectedDto = new PedidoDTO();
        expectedDto.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(pedido));
        when(modelMapper.map(pedido, PedidoDTO.class)).thenReturn(expectedDto);
        PedidoDTO result = service.findById(id);
        assertEquals(expectedDto, result);
    }
    @Test
    void delete() {
        Long id = 1L;
        Pedido pedido = new Pedido();
        pedido.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(pedido));
        service.delete(id);
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void delete_WhenPedidoNotFound_ShouldThrowException() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> {
            service.delete(id);
        });
        verify(repository, never()).deleteById(id);
    }
}
