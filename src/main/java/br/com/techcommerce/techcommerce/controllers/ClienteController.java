package br.com.techcommerce.techcommerce.controllers;

import br.com.techcommerce.techcommerce.model.Cliente;
import br.com.techcommerce.techcommerce.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){
        List<Cliente> clientesEncontrados = clienteRepository.findAll();
        return ResponseEntity.ok(clientesEncontrados);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable UUID uuid){
        Optional<Cliente> cliente = clienteRepository.findById(uuid);
        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    @PutMapping("/atualizar/{uuid}")
    public ResponseEntity<Cliente> atualizar(@PathVariable UUID uuid, @RequestBody Cliente cliente){
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(uuid);
        BeanUtils.copyProperties(cliente, clienteEncontrado.get(), "id");
        return ResponseEntity.ok(clienteRepository.save(clienteEncontrado.get()));
    }

    @DeleteMapping("/deletar/{uuid}")
    public ResponseEntity<Cliente> deletar (@PathVariable UUID uuid){
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(uuid);

        if (clienteEncontrado.isPresent()) {
            clienteRepository.delete(clienteEncontrado.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
