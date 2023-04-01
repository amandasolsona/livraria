package br.com.santander.coders.livraria.entity;

import br.com.santander.coders.livraria.dto.EditoraDTO;
import br.com.santander.coders.livraria.dto.LivroDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "editora_id", referencedColumnName = "id")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "isbn", nullable = false, length = 13, unique = true)
    private String isbn;

    public Livro() {}

    public Livro(LivroDTO livroDTO) {
        this.setId(livroDTO.getId());
        this.setCategoria(new Categoria(livroDTO.getCategoria()));
        this.setEditora(new Editora(livroDTO.getEditora()));
        this.setNome(livroDTO.getNome());
        this.setIsbn(livroDTO.getIsbn());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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
