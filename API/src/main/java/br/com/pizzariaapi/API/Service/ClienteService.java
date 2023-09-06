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
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private  ModelMapper modelMapper;

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    @Transactional(rollbackFor = Exception.class)
    public Cliente create(ClienteDTO clienteDTO) {

        validationClienteDTO(clienteDTO);
        Cliente cliente = toCliente(clienteDTO);
        if (clienteDTO.getEnderecos() != null) {
            List<Endereco> enderecos = new ArrayList<>();
            for (EnderecoDTO enderecoDTO : clienteDTO.getEnderecos()) {
                Long enderecoId = enderecoDTO.getId();
                Endereco endereco = enderecoRepository.findById(enderecoId)
                        .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com o ID: " + enderecoId));
                enderecos.add(endereco);
            }
            cliente.setEnderecos(enderecos);
        }
        return clienteRepository.save(cliente);
    }

    @Transactional(rollbackFor = Exception.class)
    public Cliente update(Long id, ClienteDTO clienteDTO) {

        final Cliente validation = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));

        validationClienteDTO(clienteDTO);
        Cliente cliente = toCliente(clienteDTO);
        if (clienteDTO.getEnderecos() != null) {
            List<Endereco> enderecos = new ArrayList<>();
            for (EnderecoDTO enderecoDTO : clienteDTO.getEnderecos()) {
                Long enderecoId = enderecoDTO.getId();
                Endereco endereco = enderecoRepository.findById(enderecoId)
                        .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com o ID: " + enderecoId));
                enderecos.add(endereco);
            }
            cliente.setEnderecos(enderecos);
        }
        return clienteRepository.save(cliente);
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
        clienteRepository.delete(cliente);
    }



    private Cliente  toCliente(ClienteDTO clienteDTO){
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        return cliente;
    }
    private ClienteDTO toClienteDTO(Cliente cliente){
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return clienteDTO;
    }
    private void validationClienteDTO(ClienteDTO clienteDTO){
        assert StringUtils.isBlank(clienteDTO.getNome()) : "Nome inválido";
        assert StringUtils.isBlank(clienteDTO.getSenha()) : "Senha inválida";
        assert StringUtils.isBlank(clienteDTO.getEmail()) : "E-Mail inválido";
        assert StringUtils.isBlank(clienteDTO.getTelefone()) : "Telefone inválido";
    }
}
