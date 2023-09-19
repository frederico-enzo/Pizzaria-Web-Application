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
        cliente.setNome("John Doe");
        ClienteDTO expectedDto = new ClienteDTO();
        expectedDto.setId(id);
        expectedDto.setNome("John Doe");
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
        clienteDTO.setNome("John Doe");
        clienteDTO.setSenha("password");
        clienteDTO.setEmail("john@example.com");
        clienteDTO.setTelefone("123456789");

        Cliente cliente = new Cliente();
        cliente.setNome("John Doe");
        cliente.setSenha("password");
        cliente.setEmail("john@example.com");
        cliente.setTelefone("123456789");

        when(repository.save(any(Cliente.class))).thenReturn(cliente);

        String result = service.create(clienteDTO);

        assertEquals("Sucesso ao cadastrar novo Registro", result);
    }

    @Test
    void update() {

        Long id = 1L;
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("John Doe");
        clienteDTO.setSenha("newpassword");
        clienteDTO.setEmail("newemail@example.com");
        clienteDTO.setTelefone("987654321");

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome("John Doe");
        cliente.setSenha("newpassword");
        cliente.setEmail("newemail@example.com");
        cliente.setTelefone("987654321");

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
}