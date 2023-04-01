package br.com.santander.coders.livraria.service;

import br.com.santander.coders.livraria.dto.CategoriaDTO;
import br.com.santander.coders.livraria.entity.Categoria;
import br.com.santander.coders.livraria.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO buscarPorId(Long id) {
        if (categoriaRepository.existsById(id)) {
            return new CategoriaDTO(categoriaRepository.findById(id).get());
        }

        throw new EntityNotFoundException("Categoria não encontrada!");
    }

    public List<CategoriaDTO> listar() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaDTO::new)
                .collect(Collectors.toList());
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO) {
        categoriaDTO.setId(null);
        Categoria categoria = new Categoria(categoriaDTO);
        return new CategoriaDTO(categoriaRepository.save(categoria));
    }

    public CategoriaDTO atualizar(Long id, CategoriaDTO categoriaDTO) {

        if (categoriaRepository.existsById(id)) {

            Categoria categoria = new Categoria(categoriaDTO);
            categoria.setId(id);
            return new CategoriaDTO(categoriaRepository.save(categoria));
        }

        throw new EntityNotFoundException("Categoria não encontrada!");
    }

    public void deletar(Long id) {

        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        }

        throw new EntityNotFoundException("Categoria não encontrada!");
    }

}
