package br.com.techcommerce.techcommerce.repositories;

import br.com.techcommerce.techcommerce.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
