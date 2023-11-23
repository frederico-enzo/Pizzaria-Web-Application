package br.com.pizzariaapi.api.service;
import br.com.pizzariaapi.api.dto.PedidoDTO;
import br.com.pizzariaapi.api.entity.Item;
import br.com.pizzariaapi.api.entity.Pedido;
import br.com.pizzariaapi.api.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    private Pedido toEntity(PedidoDTO pedidoDTO){
        return modelMapper.map(pedidoDTO, Pedido.class);
    }
    private PedidoDTO toDTO(Pedido pedido){
        return modelMapper.map(pedido, PedidoDTO.class);
    }

    public double calcularValorTotal(PedidoDTO pedidoDTO) {
        double valorTotal = 0.0;
        for (Item item : pedidoDTO.getItems()) {
            int quantidade = item.getQuantidade();
            double precoUnitario = item.getPropriedade().getPreco();
            double valorParcialItem = quantidade * precoUnitario;
            valorTotal += valorParcialItem;
        }
        return valorTotal;
    }
    public List<PedidoDTO> findAll(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public PedidoDTO findById(Long id) {
        return toDTO(repository.findById(id).orElse(null));
    }
    public PedidoDTO post(PedidoDTO pedidoDTO) {
        Assert.isTrue(pedidoDTO.getCliente() != null, "Cliente inválido");
        pedidoDTO.setValorTotal(calcularValorTotal(pedidoDTO));
        return toDTO(repository.save(toEntity(pedidoDTO)));

    }
    public PedidoDTO put(Long id, PedidoDTO pedidoDTO){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        Assert.isTrue(pedidoDTO.getCliente() != null,"Cliente inválido");
        pedidoDTO.setValorTotal(calcularValorTotal(pedidoDTO));
        return toDTO(repository.save(toEntity(pedidoDTO)));
    }
    public void delete(Long id){
        Assert.notNull(repository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        repository.deleteById(id);
    }
}