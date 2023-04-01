package br.com.santander.coders.livraria.repository;

import br.com.santander.coders.livraria.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByCategoriaNome(String categoria);
    List<Livro> findByEditoraNome(String editora);

    @Query( " SELECT l FROM Livro l " +
            " WHERE (UPPER(l.nome) LIKE CONCAT('%', UPPER(:nome), '%')) " +
            "   OR (UPPER(l.isbn) LIKE CONCAT('%', UPPER(:isbn), '%')) ")
    List<Livro> findByNomeOrIsbn(@Param("nome") String nome, @Param("isbn") String isbn);

}
