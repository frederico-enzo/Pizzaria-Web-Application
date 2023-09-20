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
        // Arrange
        Long id = 1L;
        Pedido pedido = new Pedido();
        pedido.setId(id);
        PedidoDTO expectedDto = new PedidoDTO();
        expectedDto.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(pedido));
        when(modelMapper.map(pedido, PedidoDTO.class)).thenReturn(expectedDto);

        // Act
        PedidoDTO result = service.findById(id);

        // Assert
        assertEquals(expectedDto, result);
    }






    @Test
    void delete() {
        // Arrange
        Long id = 1L;
        Pedido pedido = new Pedido();
        pedido.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(pedido));

        // Act
        service.delete(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }
}
