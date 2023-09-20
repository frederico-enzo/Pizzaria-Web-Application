package br.com.pizzariaapi.api.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.entity.Atributo;
import br.com.pizzariaapi.api.entity.Tamanho;
import br.com.pizzariaapi.api.repository.AtributoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;


 class AtributoServiceTest {

    @InjectMocks
    private AtributoService service;
    @Mock
    private AtributoRepository repository;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testFindByIdWithInvalidId() {
        Long invalidId = 999L;
        when(repository.findById(invalidId)).thenReturn(java.util.Optional.empty());
        AtributoDTO result = service.findById(invalidId);
        assertNull(result);
    }
    @Test
     void testSetDescricaoAndPrecoPEQUENO() {
        AtributoDTO atributo = new AtributoDTO();
        atributo.setTamanho(Tamanho.PEQUENO);
        service.setDescricao(atributo);
        assertEquals("Pequena: 25 cm, 4 fatias – até 2 sabores.", atributo.getDescricao());
        assertEquals(10.0, atributo.getPreco());
    }
    @Test
     void testSetDescricaoAndPrecoMEDIA() {
        AtributoDTO atributo = new AtributoDTO();
        atributo.setTamanho(Tamanho.MEDIA);
        service.setDescricao(atributo);
        assertEquals("30 cm, 6 fatias – até 3 sabores.", atributo.getDescricao());
        assertEquals(20, atributo.getPreco());
    }
    @Test
     void testSetDescricaoAndPrecoGRANDE() {
        AtributoDTO atributo = new AtributoDTO();
        atributo.setTamanho(Tamanho.GRANDE);
        service.setDescricao(atributo);
        assertEquals("35 cm, 8 fatias – até 3 sabores.", atributo.getDescricao());
        assertEquals(35.0, atributo.getPreco());
    }
    @Test
     void testSetDescricaoAndPrecoGIGANTE() {
        AtributoDTO atributo = new AtributoDTO();
        atributo.setTamanho(Tamanho.GIGANTE);
        service.setDescricao(atributo);
        assertEquals("50 cm, 12 fatias – até 4 sabores.", atributo.getDescricao());
        assertEquals(55.0, atributo.getPreco());
    }
    @Test
    void post_Failure() {
        AtributoDTO atributoDTO = new AtributoDTO();
        assertThrows(IllegalArgumentException.class, () -> {
            service.post(atributoDTO);
        });
    }
    @Test
    void put_Failure() {
        AtributoDTO atributo = new AtributoDTO();
        atributo.setTamanho(Tamanho.GIGANTE);
        assertThrows(IllegalArgumentException.class, () -> {
            service.put(atributo);
        });
    }


}
