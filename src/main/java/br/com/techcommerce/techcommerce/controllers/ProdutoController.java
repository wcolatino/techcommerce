package br.com.techcommerce.techcommerce.controllers;

import br.com.techcommerce.techcommerce.model.Produto;
import br.com.techcommerce.techcommerce.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> produtosEncontrados = produtoRepository.findAll();
        return ResponseEntity.ok(produtosEncontrados);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable UUID uuid){
        Optional<Produto> produto = produtoRepository.findById(uuid);
        return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        Optional<Produto> produtoSalvo = Optional.of(produtoRepository.save(produto));
        return !produtoSalvo.isEmpty() ? ResponseEntity.ok(produtoSalvo.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar/{uuid}")
    public ResponseEntity<Produto> atualizar(@PathVariable UUID uuid, @RequestBody Produto produto){
        Optional<Produto> produtoEncontrado = produtoRepository.findById(uuid);
        BeanUtils.copyProperties(produto, produtoEncontrado.get(), "id");
        return ResponseEntity.ok(produtoRepository.save(produtoEncontrado.get()));
    }

    @DeleteMapping("/deletar/{uuid}")
    public ResponseEntity<Produto> deletar (@PathVariable UUID uuid){
        Optional<Produto> produtoEncontrado = produtoRepository.findById(uuid);

        if (produtoEncontrado.isPresent()) {
            produtoRepository.delete(produtoEncontrado.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
