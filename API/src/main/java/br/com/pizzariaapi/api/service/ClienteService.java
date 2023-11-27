package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.ClienteDTO;
import br.com.pizzariaapi.api.entity.Cliente;
import br.com.pizzariaapi.api.repository.ClienteRepository;
import br.com.pizzariaapi.api.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private  ModelMapper modelMapper;

    private Cliente toCliente(ClienteDTO clienteDTO){
        return modelMapper.map(clienteDTO, Cliente.class);
    }
    private ClienteDTO toClienteDTO(Cliente cliente){
        return modelMapper.map(cliente, ClienteDTO.class);
    }
    private void idNotNull(Long id){
        Assert.notNull(clienteRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
    private void validationClienteDTO(ClienteDTO clienteDTO){
        Assert.notNull(clienteDTO.getUsername(), "Digite seu Nome!");
        Assert.hasText(clienteDTO.getUsername(), "Digite seu Nome!");


    }
    public ClienteDTO findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return toClienteDTO(cliente);
    }

    public List<ClienteDTO> findAll(){
        return clienteRepository.findAll().stream().map(this::toClienteDTO).toList();
    }
    @Transactional(rollbackFor = Exception.class)
    public ClienteDTO post(ClienteDTO clienteDTO){
        validationClienteDTO(clienteDTO);
        return toClienteDTO(clienteRepository.save(toCliente(clienteDTO)));

    }
    @Transactional(rollbackFor = Exception.class)
    public ClienteDTO put(Long id, ClienteDTO clienteDTO){
        idNotNull(id);
        validationClienteDTO(clienteDTO);
        return toClienteDTO(clienteRepository.save(toCliente(clienteDTO)));

    }
    public void delete(Long id){
        idNotNull(id);
        clienteRepository.deleteById(id);
    }
}
