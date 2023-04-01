package br.com.santander.coders.livraria.dto;

import br.com.santander.coders.livraria.entity.Categoria;

public class CategoriaDTO {

    private Long id;
    private String nome;

    public CategoriaDTO(){}

    public CategoriaDTO(Categoria categoria) {
        this.setId(categoria.getId());
        this.setNome(categoria.getNome());
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
