package br.com.santander.coders.livraria.dto;

import br.com.santander.coders.livraria.entity.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LivroDTO {

    private Long id;
    @NotNull(message = "Livro deve ter uma editora")
    private EditoraDTO editora;
    @NotNull(message = "Livro deve ter uma categoria")
    private CategoriaDTO categoria;

    @NotBlank(message="Nome deve conter algum valor")
    private String nome;
    @Size(max=13,message="Tamanho do isbn acima do permitido")
    @NotBlank(message="ISBN deve conter algum valor")
    private String isbn;

    public LivroDTO() {}

    public LivroDTO(Livro livro) {
        this.setId(livro.getId());
        this.setNome(livro.getNome());
        this.setIsbn(livro.getIsbn());
        this.setCategoria(new CategoriaDTO(livro.getCategoria()));
        this.setEditora(new EditoraDTO(livro.getEditora()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EditoraDTO getEditora() {
        return editora;
    }

    public void setEditora(EditoraDTO editora) {
        this.editora = editora;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
