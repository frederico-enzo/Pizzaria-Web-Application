package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.ClienteDTO;
import br.com.pizzariaapi.api.entity.Cliente;
import br.com.pizzariaapi.api.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteServiceTest {
    @InjectMocks
    ClienteService service;
    @Mock
    ClienteRepository repository;
    @Mock
    ModelMapper modelMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setLogin("John Doe");
        ClienteDTO expectedDto = new ClienteDTO();
        expectedDto.setId(id);
        expectedDto.setPassword("John Doe");
        when(repository.findById(id)).thenReturn(Optional.of(cliente));
        when(modelMapper.map(cliente, ClienteDTO.class)).thenReturn(expectedDto);
        ClienteDTO result = service.findById(id);
        assertEquals(expectedDto, result);
    }

    @Test
    void findAll() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente());
        clientes.add(new Cliente());
        List<ClienteDTO> expectedDtos = new ArrayList<>();
        expectedDtos.add(new ClienteDTO());
        expectedDtos.add(new ClienteDTO());
        when(repository.findAll()).thenReturn(clientes);
        when(modelMapper.map(any(Cliente.class), eq(ClienteDTO.class))).thenReturn(new ClienteDTO());
        List<ClienteDTO> result = service.findAll();
        assertEquals(expectedDtos.size(), result.size());
    }

    @Test
    void create() {
        // Arrange
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setLogin("John Doe");
        clienteDTO.setPassword("password");


        Cliente cliente = new Cliente();
        cliente.setLogin("John Doe");
        cliente.setPassword("password");


        when(repository.save(any(Cliente.class))).thenReturn(cliente);

        String result = service.create(clienteDTO);

        assertEquals("Sucesso ao cadastrar novo Registro", result);
    }

    @Test
    void update() {

        Long id = 1L;
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setLogin("John Doe");
        clienteDTO.setPassword("password");


        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setLogin("John Doe");
        cliente.setPassword("password");



        when(repository.findById(id)).thenReturn(Optional.of(cliente));
        when(repository.save(any(Cliente.class))).thenReturn(cliente);


        String result = service.update(id, clienteDTO);

        assertEquals("Sucesso ao atualizar Registro do ID:" + id + " Cliente", result);
    }

    @Test
    void delete() {

        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(cliente));
        service.delete(id);

        verify(repository, times(1)).deleteById(id);
    }
    @Test
    void post_Failure() {
        ClienteDTO clienteDTO = new ClienteDTO();
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(clienteDTO);
        });
    }

}