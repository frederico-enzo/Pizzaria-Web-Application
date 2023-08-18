package br.com.pizzariaapi.API.Service;
import br.com.pizzariaapi.API.DTO.PedidoDTO;
import br.com.pizzariaapi.API.Entity.Pedido;
import br.com.pizzariaapi.API.Repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional(rollbackFor = Exception.class)
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    @Transactional(rollbackFor = Exception.class)
    public Pedido create(PedidoDTO pedidoDTO) {
        Assert.notNull(pedidoDTO.getCliente(), "Pedido inválido");
        Assert.notNull(pedidoDTO.getValorTotal(), "Quantidade inválido");

        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        return pedidoRepository.save(pedido);
    }
    @Transactional(rollbackFor = Exception.class)
    public Pedido update(Long id, PedidoDTO pedidoDTO){
        Pedido validation = pedidoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Atributo não encontrado com o ID: " + id));
        Assert.notNull(pedidoDTO.getCliente(), "Pedido inválido");
        Assert.notNull(pedidoDTO.getValorTotal(), "Quantidade inválido");
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        return pedidoRepository.save(pedido);
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Pedido validation = pedidoRepository.findById(id).orElse(null);
        pedidoRepository.delete(validation);
    }
}
