package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.ClienteDTO;
import br.com.pizzariaapi.API.Entity.ClienteEntity;
import br.com.pizzariaapi.API.Repository.ClienteRepository;
import org.modelmapper.ModelMapper;
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
    public ClienteEntity findById(Long Id){
        return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity create(ClienteDTO clienteDTO){
        return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public ClienteEntity update(ClienteDTO clienteDTO){
        return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long Id){
    }



}
//        public Produto criarProduto(ProdutoDTO produtoDTO) {
//            Produto produto = modelMapper.map(produtoDTO, Produto.class);
//            // Realize qualquer lógica adicional se necessário
//            return produto;
//        }