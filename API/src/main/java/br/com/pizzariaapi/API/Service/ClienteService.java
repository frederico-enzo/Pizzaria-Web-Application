package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.Entity.ClienteEntity;
import br.com.pizzariaapi.API.Repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private  ModelMapper modelMapper;
    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity findById(Long id) {
        final ClienteEntity cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
        return cliente;
    }
    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity create(ClienteDTO clienteDTO) {
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
