package br.com.santander.coders.livraria.controller;

import br.com.santander.coders.livraria.dto.LivroDTO;
import br.com.santander.coders.livraria.service.LivroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(livroService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(livroService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<Object> buscarPorCategoria(@RequestParam("nome") String categoria) {
        try {
            return ResponseEntity.ok(livroService.buscarPorCategoria(categoria));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/editora")
    public ResponseEntity<Object> buscarPorEditora(@RequestParam("nome") String editora) {
        try {
            return ResponseEntity.ok(livroService.buscarPorEditora(editora));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/filtro")
    public ResponseEntity<Object> buscarPorNomeIsbn(@RequestParam(value = "nome", required = false) String nome,
                                                    @RequestParam(value = "isbn", required = false) String isbn) {
        try {
            return ResponseEntity.ok(livroService.buscarPorNomeIsbn(nome, isbn));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody LivroDTO livroDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criar(livroDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@PathVariable("id") Long id,
                                         @RequestBody LivroDTO livroDTO) {
        try {
            return ResponseEntity.ok(livroService.atualizar(id, livroDTO));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> editar(@PathVariable("id") Long id) {
        try {
            livroService.deletar(id);
            return ResponseEntity.ok("Livro com id " + id + " removido com sucesso!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

}
