package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.Entity.ClienteEntity;
import br.com.pizzariaapi.API.Entity.EnderecoEntity;
import br.com.pizzariaapi.API.Repository.ClienteRepository;
import br.com.pizzariaapi.API.Repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private  ModelMapper modelMapper;
    public ClienteEntity findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity create(ClienteDTO clienteDTO) {
        Assert.notNull(clienteDTO.getNome(), "Nome inválido");
        Assert.notNull(clienteDTO.getEmail(), "E-Mail inválido");
        Assert.notNull(clienteDTO.getEndereco(), "Enderecos inválidos");
        Assert.notNull(clienteDTO.getSenha(), "Senha inválida");
        Assert.notNull(clienteDTO.getTelefone(), "Telefone inválido");

        ClienteEntity cliente = modelMapper.map(clienteDTO, ClienteEntity.class);

        // Associe os endereços ao cliente
        Set<EnderecoEntity> enderecos = new HashSet<>();
        for (Long enderecoId : clienteDTO.getEndereco()) {
            EnderecoEntity endereco = enderecoRepository.findById(enderecoId).orElseThrow(() -> new RuntimeException("Endereco não encontrado"));
            enderecos.add(endereco);
        }
        cliente.setEnderecos(enderecos);

        return clienteRepository.save(cliente);
    }


    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity update(ClienteDTO clienteDTO) {
        final ClienteEntity clienteData = clienteRepository.findById(clienteDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteDTO.getId()));

        // Verificações de validação do DTO
        Assert.notNull(clienteDTO.getNome(), "Nome inválido");
        Assert.notNull(clienteDTO.getEmail(), "E-Mail inválido");
        Assert.notNull(clienteDTO.getSenha(), "Senha inválido");
        Assert.notNull(clienteDTO.getTelefone(), "Telefone inválido");

        // Mapear o DTO para a entidade
        ClienteEntity cliente = modelMapper.map(clienteDTO, ClienteEntity.class);

        // Define os valores na entidade
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(clienteDTO.getSenha());
        cliente.setTelefone(clienteDTO.getTelefone());

        // Salva a entidade no repositório
        return clienteRepository.save(cliente);
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final ClienteEntity cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
        clienteRepository.delete(cliente);
    }
}
