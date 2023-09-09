package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.DTO.EnderecoDTO;
import br.com.pizzariaapi.API.Entity.Cliente;
import br.com.pizzariaapi.API.Entity.Endereco;
import br.com.pizzariaapi.API.Repository.ClienteRepository;
import br.com.pizzariaapi.API.Repository.EnderecoRepository;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

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
    private void validationClienteDTO(ClienteDTO clienteDTO){
        Assert.notNull(clienteDTO.getNome(), "Digite seu Nome!");
        Assert.hasText(clienteDTO.getNome(), "Digite seu Nome!");
        Assert.hasText(clienteDTO.getSenha(), "Digite sua Senha!");
        Assert.notNull(clienteDTO.getSenha(), "Digite sua Senha!");
        Assert.hasText(clienteDTO.getEmail(), "Digite seu E-mail!");
        Assert.notNull(clienteDTO.getEmail(), "Digite seu E-mail!");
        Assert.hasText(clienteDTO.getTelefone(), "Digite seu Telefone!");
        Assert.notNull(clienteDTO.getTelefone(), "Digite seu Telefone!");
    }
    public ClienteDTO findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return toClienteDTO(cliente);
    }
    public List<ClienteDTO> findAll(){
        return clienteRepository.findAll().stream().map(this::toClienteDTO).toList();
    }
    public ClienteDTO create(ClienteDTO clienteDTO){
        validationClienteDTO(clienteDTO);
        return toClienteDTO(clienteRepository.save(toCliente(clienteDTO)));
    }
    public ClienteDTO update(Long id, ClienteDTO clienteDTO){
        validationClienteDTO(clienteDTO);
        return toClienteDTO(clienteRepository.save(toCliente(clienteDTO)));
    }
    public void delete(Long id){
        Assert.notNull(clienteRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
        clienteRepository.deleteById(id);
    }
}
