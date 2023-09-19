package br.com.pizzariaapi.api.service;

import br.com.pizzariaapi.api.dto.ProdutoDTO;
import br.com.pizzariaapi.api.entity.Produto;
import br.com.pizzariaapi.api.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private void idNotNull(Long id){
        Assert.notNull(produtoRepository.findById(id).orElse(null), String.format("ID [%s] não encontrado" , id));
    }
    private void validationProdutoDTO(ProdutoDTO produtoDTO){
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
    @Transactional(rollbackFor = Exception.class)
    public String create(ProdutoDTO produtoDTO) {
        validationProdutoDTO(produtoDTO);
        toProdutorDTO(produtoRepository.save(toProtudo(produtoDTO)));
        return "Sucesso ao cadastrar novo Registro";
    }
    @Transactional(rollbackFor = Exception.class)
    public String update(Long id, ProdutoDTO produtoDTO ){
        idNotNull(id);
        validationProdutoDTO(produtoDTO);
        toProdutorDTO(produtoRepository.save(toProtudo(produtoDTO)));
        return "Sucesso ao cadastrar novo Registro";
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        idNotNull(id);
        produtoRepository.deleteById(id);
    }


}
