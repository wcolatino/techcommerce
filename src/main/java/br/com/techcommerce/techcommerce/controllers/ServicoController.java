package br.com.techcommerce.techcommerce.controllers;

import br.com.techcommerce.techcommerce.model.Produto;
import br.com.techcommerce.techcommerce.model.Servico;
import br.com.techcommerce.techcommerce.repositories.ProdutoRepository;
import br.com.techcommerce.techcommerce.repositories.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/servicos")
public class ServicoController {


    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public ResponseEntity<List<Servico>> buscarTodos(){
        List<Servico> servicosEncontrados = servicoRepository.findAll();
        return ResponseEntity.ok(servicosEncontrados);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable UUID uuid){
        Optional<Servico> servico = servicoRepository.findById(uuid);
        return servico.isPresent() ? ResponseEntity.ok(servico.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Servico> salvar(@RequestBody Servico servico){
        return ResponseEntity.ok(servicoRepository.save(servico));
    }

    @PutMapping("/atualizar/{uuid}")
    public ResponseEntity<Servico> atualizar(@PathVariable UUID uuid, @RequestBody Servico servico){
        Optional<Servico> servicoEncontrado = servicoRepository.findById(uuid);
        BeanUtils.copyProperties(servico, servicoEncontrado.get(), "id");
        return ResponseEntity.ok(servicoRepository.save(servicoEncontrado.get()));
    }

    @DeleteMapping("/deletar/{uuid}")
    public ResponseEntity<Servico> deletar (@PathVariable UUID uuid){
        Optional<Servico> servicoEncontrado = servicoRepository.findById(uuid);

        if (servicoEncontrado.isPresent()) {
            servicoRepository.delete(servicoEncontrado.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
