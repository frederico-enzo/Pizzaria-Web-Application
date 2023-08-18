package br.com.pizzariaapi.API.Service;

import br.com.pizzariaapi.API.DTO.ProdutoDTO;
import br.com.pizzariaapi.API.Entity.Produto;
import br.com.pizzariaapi.API.Repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional(rollbackFor = Exception.class)
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    @Transactional(rollbackFor = Exception.class)
    public Produto create(ProdutoDTO produtoDTO) {

        Assert.notNull(produtoDTO.getNome(), "Nome inválido");
        Assert.notNull(produtoDTO.getCategoria(), "Categoria inválida");
        Assert.notNull(produtoDTO.isDisponivel(), "Disponibilidade inválida");
        Assert.notNull(produtoDTO.getTempoPreparo(), "Tempo de preparo inválido");

        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        return produtoRepository.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public Produto update(Long id, ProdutoDTO produtoDTO ){
        Produto validation = produtoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Produto não encontrado com o ID: " + id));

        Assert.notNull(produtoDTO.getNome(), "Nome inválido");
        Assert.notNull(produtoDTO.getCategoria(), "Categoria inválida");
        Assert.notNull(produtoDTO.isDisponivel(), "Disponibilidade inválida");
        Assert.notNull(produtoDTO.getTempoPreparo(), "Tempo de preparo inválido");


        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        return produtoRepository.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Produto validation = produtoRepository.findById(id).orElse(null);
        produtoRepository.delete(validation);
    }


}
