package br.com.techcommerce.techcommerce.model;

import br.com.techcommerce.techcommerce.model.enums.TipoVenda;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    private List<TipoVenda> tipoVenda;

    private List<Produto> produtos;

    private List<Servico> servicos;

}
