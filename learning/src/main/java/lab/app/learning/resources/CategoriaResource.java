package lab.app.learning.resources;

import lab.app.learning.models.Categoria;
import lab.app.learning.repositories.CategoriaQuery;
import lab.app.learning.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaRepository categoriaRepository;

//    @Autowired
//    private CategoriaQuery cat;

    @RequestMapping("/test")
    public List<String> createUser() {
        return Arrays.asList("Carlos", "nOBREGA");
    }

    @GetMapping("/")
    public ResponseEntity<?> listAll() {
        List<Categoria> listCategorias = categoriaRepository.findAll();
        System.out.println(listCategorias);
        return ResponseEntity.ok(listCategorias);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria, HttpServletResponse response) {
        System.out.println(categoria);
        Categoria novaCategoria = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                    .buildAndExpand(novaCategoria.getId()).toUri();

        response.setHeader("Location", uri.toASCIIString());
        categoriaRepository.save(categoria);

        return ResponseEntity.created(uri).body(novaCategoria);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> showCategoria(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return ResponseEntity.ok(categoria);
    }
}
