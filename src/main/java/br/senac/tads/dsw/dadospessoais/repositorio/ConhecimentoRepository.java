package br.senac.tads.dsw.dadospessoais.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.dadospessoais.entidade.ConhecimentoEntity;

@Repository
public interface ConhecimentoRepository extends JpaRepository<ConhecimentoEntity, Long> {
 // Gera: SELECT * FROM tb_conhecimentos WHERE LOWER(nome) = LOWER(:nome)
 // Usado para reutilizar um conhecimento já existente (sem distinção de maiúsculas)
 Optional<ConhecimentoEntity> findByNomeIgnoreCase(String nome);
}
