package br.com.pizzariaapi.api.service;
import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.EnderecoDTO;
import br.com.pizzariaapi.api.dto.ItemDTO;
import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.entity.Atributo;
import br.com.pizzariaapi.api.entity.Item;
import br.com.pizzariaapi.api.entity.Pedido;
import br.com.pizzariaapi.api.entity.Produto;
import br.com.pizzariaapi.api.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    private Pedido toPedido(PedidoDTO pedidoDTO){
        return modelMapper.map(pedidoDTO, Pedido.class);
    }
    private PedidoDTO toPedidoDTO(Pedido pedido){
        return modelMapper.map(pedido, PedidoDTO.class);
    }
    private void idNotNull(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
    public double calcularValorTotal(PedidoDTO pedidoDTO) {
        double valorTotal = 0.0;
        for (Item item : pedidoDTO.getItems()) {
            int quantidade = item.getQuantidade();
            double precoUnitario = item.getAtributoEspecifico().getPreco();
            double valorParcialItem = quantidade * precoUnitario;
            valorTotal += valorParcialItem;
        }
        return valorTotal;
    }
    public List<PedidoDTO> findAll(){
        return repository.findAll().stream().map(this::toPedidoDTO).toList();
    }

    public PedidoDTO findById(Long id) {
        Pedido pedido = repository.findById(id).orElse(null);
        return toPedidoDTO(pedido);
    }
    @Transactional(rollbackFor = Exception.class)
    public PedidoDTO post(PedidoDTO pedidoDTO) {
        Assert.isTrue(pedidoDTO.getCliente() != null, "Cliente inválido");
        pedidoDTO.setValorTotal(calcularValorTotal(pedidoDTO));
        return toPedidoDTO(repository.save(toPedido(pedidoDTO)));

    }
    @Transactional(rollbackFor = Exception.class)
    public PedidoDTO put(Long id, PedidoDTO pedidoDTO){
        idNotNull(id);
        Assert.isTrue(pedidoDTO.getCliente() != null,"Cliente inválido");
        pedidoDTO.setValorTotal(calcularValorTotal(pedidoDTO));
        return toPedidoDTO(repository.save(toPedido(pedidoDTO)));

    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        idNotNull(id);
        repository.deleteById(id);
    }
}
