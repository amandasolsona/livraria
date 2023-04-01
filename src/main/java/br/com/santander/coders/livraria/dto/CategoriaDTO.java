package br.com.santander.coders.livraria.dto;

import br.com.santander.coders.livraria.entity.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaDTO {

    private Long id;
    @Size(max=100,message="Tamanho do nome acima do permitido")
    @NotBlank(message="Nome deve conter algum valor")
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
