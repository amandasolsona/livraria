package br.com.santander.coders.livraria.service;

import br.com.santander.coders.livraria.dto.LivroDTO;
import br.com.santander.coders.livraria.entity.Livro;
import br.com.santander.coders.livraria.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroDTO buscarPorId(Long id) {
        if (livroRepository.existsById(id)) {
            return new LivroDTO(livroRepository.findById(id).get());
        }

        throw new EntityNotFoundException("Livro não encontrado!");
    }

    public List<LivroDTO> listar() {
        return livroRepository.findAll().stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public List<LivroDTO> buscarPorCategoria(String categoria) {
        return livroRepository.findByCategoriaNome(categoria).stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
    }

    public List<LivroDTO>  buscarPorEditora(String editora) {
        return livroRepository.findByEditoraNome(editora).stream()
                .map(LivroDTO::new).collect(Collectors.toList());
    }

    public List<LivroDTO> buscarPorNomeIsbn(String nome, String isbn) {
        return livroRepository.findByNomeOrIsbn(nome, isbn).stream()
                .map(LivroDTO::new).collect(Collectors.toList());
    }

    public LivroDTO criar(LivroDTO livroDTO) {
        livroDTO.setId(null);
        Livro livro = new Livro(livroDTO);
        return new LivroDTO(livroRepository.save(livro));
    }

    public LivroDTO atualizar(Long id, LivroDTO livroDTO) {

        if (livroRepository.existsById(id)) {

            Livro livro = new Livro(livroDTO);
            livro.setId(id);
            return new LivroDTO(livroRepository.save(livro));
        }

        throw new EntityNotFoundException("Livro não encontrado!");
    }

    public void deletar(Long id) {

        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
        }

        throw new EntityNotFoundException("Livro não encontrado!");
    }

}
