package br.com.techcommerce.techcommerce.controllers;

import br.com.techcommerce.techcommerce.model.Produto;
import br.com.techcommerce.techcommerce.model.Servico;
import br.com.techcommerce.techcommerce.repositories.ProdutoRepository;
import br.com.techcommerce.techcommerce.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/salvar")
    public ResponseEntity<Servico> salvar(@RequestBody Servico servico){
        try {
            Servico servicoSalvo = servicoRepository.save(servico);
            return ResponseEntity.ok(servicoSalvo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
