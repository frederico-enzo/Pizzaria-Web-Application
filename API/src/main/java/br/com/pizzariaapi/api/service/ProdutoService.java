package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.AtributoDTO;
import br.com.pizzariaapi.api.dto.ProdutoDTO;
import br.com.pizzariaapi.api.entity.Produto;
import br.com.pizzariaapi.api.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ModelMapper modelMapper;
    private Produto toProtudo(ProdutoDTO produtoDTO){
        return modelMapper.map(produtoDTO, Produto.class);
    }
    private ProdutoDTO toProdutorDTO(Produto produto){
        return modelMapper.map(produto, ProdutoDTO.class);
    }
     void idNotNull(Long id){
        Assert.notNull(produtoRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
     void validationProdutoDTO(ProdutoDTO produtoDTO){
        Assert.notNull(produtoDTO.getNome(), "Nome inválido");
        Assert.hasText(produtoDTO.getNome(), "Nome inválido");
        Assert.notNull(produtoDTO.getCategoria(), "Categoria inválida");
        Assert.hasText(produtoDTO.getCategoria(), "Categoria inválida");
        Assert.notNull(produtoDTO.isDisponivel(), "Disponibilidade inválida");
        Assert.notNull(produtoDTO.getTempoPreparo(), "Tempo de preparo inválido");
    }
    public ProdutoDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        return toProdutorDTO(produto);
    }
    public List<ProdutoDTO> findAll(){
        return produtoRepository.findAll().stream().map(this::toProdutorDTO).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public ProdutoDTO post(ProdutoDTO produtoDTO) {
        validationProdutoDTO(produtoDTO);
        return toProdutorDTO(produtoRepository.save(toProtudo(produtoDTO)));

    }
    @Transactional(rollbackFor = Exception.class)
    public ProdutoDTO put(Long id, ProdutoDTO produtoDTO ){
        idNotNull(id);
        validationProdutoDTO(produtoDTO);
        return toProdutorDTO(produtoRepository.save(toProtudo(produtoDTO)));
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        idNotNull(id);
        produtoRepository.deleteById(id);
    }


}
