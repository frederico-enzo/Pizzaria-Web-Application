package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.SaborDTO;
import br.com.pizzariaapi.api.entity.Sabor;
import br.com.pizzariaapi.api.repository.SaborRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SaborServiceTest {
    @InjectMocks
    SaborService service;
    @Mock
    SaborRepository repository;
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
        Sabor sabor = new Sabor();
        sabor.setId(id);
        sabor.setNome("Sabor Teste");
        SaborDTO expectedDto = new SaborDTO();
        expectedDto.setId(id);
        expectedDto.setNome("Sabor Teste");

        when(repository.findById(id)).thenReturn(Optional.of(sabor));
        when(modelMapper.map(sabor, SaborDTO.class)).thenReturn(expectedDto);

        // Act
        SaborDTO result = service.findById(id);

        // Assert
        assertEquals(expectedDto, result);
    }

    @Test
    void findAll() {
        // Arrange
        List<Sabor> sabores = new ArrayList<>();
        sabores.add(new Sabor());
        sabores.add(new Sabor());

        List<SaborDTO> expectedDtos = new ArrayList<>();
        expectedDtos.add(new SaborDTO());
        expectedDtos.add(new SaborDTO());

        when(repository.findAll()).thenReturn(sabores);
        when(modelMapper.map(any(Sabor.class), eq(SaborDTO.class))).thenReturn(new SaborDTO());

        // Act
        List<SaborDTO> result = service.findAll();

        // Assert
        assertEquals(expectedDtos.size(), result.size());
    }

    @Test
    void create() {
        SaborDTO saborDTO = new SaborDTO();
        saborDTO.setNome("Sabor Teste");
        saborDTO.setComponentes(List.of("Ingrediente 1", "Ingrediente 2"));
        Sabor sabor = new Sabor();
        sabor.setNome("Sabor Teste");
        sabor.setComponentes(List.of("Ingrediente 1", "Ingrediente 2"));

        when(repository.save(any(Sabor.class))).thenReturn(sabor);
        String result = service.create(saborDTO);
        assertEquals("Sucesso ao cadastrar novo Registro", result);
    }

    @Test
    void update() {
        Long id = 1L;
        SaborDTO saborDTO = new SaborDTO();
        saborDTO.setNome("Sabor Teste");
        saborDTO.setComponentes(List.of("Ingrediente 1", "Ingrediente 2"));
        Sabor sabor = new Sabor();
        sabor.setId(id);
        sabor.setNome("Sabor Teste");
        sabor.setComponentes(List.of("Ingrediente 1", "Ingrediente 2"));
        when(repository.findById(id)).thenReturn(Optional.of(sabor));
        when(repository.save(any(Sabor.class))).thenReturn(sabor);
        String result = service.update(id, saborDTO);
        assertEquals("Sucesso ao atualizar Registro do ID:" + id + " Cliente", result);
    }

    @Test
    void delete() {
        // Arrange
        Long id = 1L;
        Sabor sabor = new Sabor();
        sabor.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(sabor));
        service.delete(id);
        verify(repository, times(1)).deleteById(id);
    }
}
