package br.com.pizzariaapi.api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;

import java.util.ArrayList;
import java.util.List;
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
    @Test
     void testCreatePedido() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        Cliente cliente = new Cliente();
        pedidoDTO.setCliente(cliente);
        List<Item> items = new ArrayList<>();
        pedidoDTO.setItems(items);

        when(repository.save(any())).thenReturn(new Pedido());
        String resultado = service.create(pedidoDTO);

        verify(repository, times(1)).save(any());
        Assert.isTrue(resultado.equals("Sucesso ao cadastrar novo Registro"), "Resultado incorreto");
    }
    @Test
     void testUpdatePedido() {
        Long id = 1L;
        PedidoDTO pedidoDTO = new PedidoDTO();
        Cliente cliente = new Cliente();
        pedidoDTO.setCliente(cliente);

        when(repository.findById(1L)).thenReturn(Optional.of(new Pedido()));
        when(repository.save(any())).thenReturn(new Pedido());
        String resultado = service.update(id, pedidoDTO);

        verify(repository, times(1)).save(any());

        Assert.isTrue(resultado.equals("Sucesso ao atualizar Registro do ID:" + id + " Cliente"), "Resultado incorreto");
    }

    @Test
    void testCalcularValorTotal() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setItems(new ArrayList<>());
        Item item1 = new Item();
        Item item2 = new Item();
        Atributo atributo1 = new Atributo();
        atributo1.setPreco(10.0);
        Atributo atributo2 = new Atributo();
        atributo2.setPreco(20.0);
        item1.setAtributoEspecifico(atributo1);
        item1.setQuantidade(3);
        item2.setAtributoEspecifico(atributo2);
        item2.setQuantidade(2);
        pedidoDTO.getItems().add(item1);
        pedidoDTO.getItems().add(item2);
        PedidoService pedidoService = new PedidoService();
        double valorTotalCalculado = pedidoService.calcularValorTotal(pedidoDTO);
        double valorTotalEsperado = 70.0;
        assertEquals(valorTotalEsperado, valorTotalCalculado, 0.01);
    }
}
