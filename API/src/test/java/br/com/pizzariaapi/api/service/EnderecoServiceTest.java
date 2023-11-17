package br.com.pizzariaapi.api.service;
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

class EnderecoServiceTest {
    @InjectMocks
    EnderecoService service;
    @Mock
    EnderecoRepository repository;
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
        Endereco endereco = new Endereco();
        endereco.setId(id);
        endereco.setBairro("Bairro Teste");
        EnderecoDTO expectedDto = new EnderecoDTO();
        expectedDto.setId(id);
        expectedDto.setBairro("Bairro Teste");

        when(repository.findById(id)).thenReturn(Optional.of(endereco));
        when(modelMapper.map(endereco, EnderecoDTO.class)).thenReturn(expectedDto);

        // Act
        EnderecoDTO result = service.findById(id);

        // Assert
        assertEquals(expectedDto, result);
    }

    @Test
    void findAll() {
        // Arrange
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco());
        enderecos.add(new Endereco());

        List<EnderecoDTO> expectedDtos = new ArrayList<>();
        expectedDtos.add(new EnderecoDTO());
        expectedDtos.add(new EnderecoDTO());

        when(repository.findAll()).thenReturn(enderecos);
        when(modelMapper.map(any(Endereco.class), eq(EnderecoDTO.class))).thenReturn(new EnderecoDTO());

        // Act
        List<EnderecoDTO> result = service.findAll();

        // Assert
        assertEquals(expectedDtos.size(), result.size());
    }

    @Test
    void create() {
        // Arrange
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setBairro("Bairro Teste");
        enderecoDTO.setNumero(123);
        enderecoDTO.setCep("12345-678");
        enderecoDTO.setRua("Rua Teste");

        Endereco endereco = new Endereco();
        endereco.setBairro("Bairro Teste");
        endereco.setNumero(123);
        endereco.setCep("12345-678");
        endereco.setRua("Rua Teste");

        when(repository.save(any(Endereco.class))).thenReturn(endereco);

        // Act
        String result = service.create(enderecoDTO);

        // Assert
        assertEquals("Sucesso ao cadastrar novo Registro", result);
    }

    @Test
    void update() {
        // Arrange
        Long id = 1L;
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setBairro("Bairro Teste");
        enderecoDTO.setNumero(123);
        enderecoDTO.setCep("12345-678");
        enderecoDTO.setRua("Rua Teste");

        Endereco endereco = new Endereco();
        endereco.setId(id);
        endereco.setBairro("Bairro Teste");
        endereco.setNumero(123);
        endereco.setCep("12345-678");
        endereco.setRua("Rua Teste");

        when(repository.findById(id)).thenReturn(Optional.of(endereco));
        when(repository.save(any(Endereco.class))).thenReturn(endereco);

        // Act
        String result = service.update(id, enderecoDTO);

        // Assert
        assertEquals("Sucesso ao atualizar Registro do ID:" + id + " Cliente", result);
    }

    @Test
    void delete() {
        // Arrange
        Long id = 1L;
        Endereco endereco = new Endereco();
        endereco.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(endereco));

        // Act
        service.delete(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }
}
