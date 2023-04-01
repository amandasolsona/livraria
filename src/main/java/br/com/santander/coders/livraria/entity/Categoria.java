package br.com.santander.coders.livraria.entity;

import br.com.santander.coders.livraria.dto.CategoriaDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    public Categoria() {}

    public Categoria(CategoriaDTO categoriaDTO) {
        this.setId(categoriaDTO.getId());
        this.setNome(categoriaDTO.getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
