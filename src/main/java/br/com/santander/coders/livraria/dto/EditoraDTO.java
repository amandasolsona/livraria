package br.com.santander.coders.livraria.dto;

import br.com.santander.coders.livraria.entity.Editora;

public class EditoraDTO {

    private Long id;
    private String nome;
    private String descricao;

    public EditoraDTO() {}

    public EditoraDTO(Editora editora) {
        this.setId(editora.getId());
        this.setNome(editora.getNome());
        this.setDescricao(editora.getDescricao());
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
