package com.produtos.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	//Gets
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos.")
	public List<Produto> listaTodosOsProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um produto apenas.")
	public Optional<Produto> listaApenasUmProduto(@PathVariable(value="id") Long id) {
		return produtoRepository.findById(id);
	}
	
	//Posts
	@PostMapping("/produto")
	@ApiOperation(value="Salva um produto.")
	public void salvaUmProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Salva uma lista de produtos.")
	public void salvaTodosOsProdutos(@RequestBody List<Produto> produtos){
		produtoRepository.saveAll(produtos);
	}
	
	//Deletes
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um produto.")
	public void deletaUmProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	//Puts
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto.")
	public void atualizaUmProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
	}
}
