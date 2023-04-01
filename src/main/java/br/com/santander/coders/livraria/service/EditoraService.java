package br.com.santander.coders.livraria.service;

import br.com.santander.coders.livraria.dto.EditoraDTO;
import br.com.santander.coders.livraria.entity.Editora;
import br.com.santander.coders.livraria.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public EditoraDTO buscarPorId(Long id) {
        if (editoraRepository.existsById(id)) {
            return new EditoraDTO(editoraRepository.findById(id).get());
        }

        throw new EntityNotFoundException("Editora não encontrada!");
    }

    public List<EditoraDTO> listar() {
        return editoraRepository.findAll().stream()
                .map(EditoraDTO::new)
                .collect(Collectors.toList());
    }

    public EditoraDTO criar(EditoraDTO editoraDTO) {
        editoraDTO.setId(null);
        Editora editora = new Editora(editoraDTO);
        return new EditoraDTO(editoraRepository.save(editora));
    }

    public EditoraDTO atualizar(Long id, EditoraDTO editoraDTO) {

        if (editoraRepository.existsById(id)) {

            Editora editora = new Editora(editoraDTO);
            editora.setId(id);
            return new EditoraDTO(editoraRepository.save(editora));
        }

        throw new EntityNotFoundException("Editora não encontrada!");
    }

    public void deletar(Long id) {

        if (!editoraRepository.existsById(id)) {
            throw new EntityNotFoundException("Editora não encontrada!");
        }

        editoraRepository.deleteById(id);
    }

}
