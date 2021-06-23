package com.backend_estudantes.controller;

import java.util.List;
import java.util.Optional;

import com.backend_estudantes.entities.Estudante;
import com.backend_estudantes.repository.EstudanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/estudantes")
@CrossOrigin
public class EstudanteController {

    @Autowired
    private EstudanteRepository repo;

    // EndPoint 1
    // Devolve todos os Estudantes
    // http://localhost:8080/estudantes
    @GetMapping
    public List<Estudante> GetEstudantes() {

        List<Estudante> lista = repo.findAll();

        /*
         * ArrayList<Estudante> lista = new ArrayList<>();
         * 
         * Estudante e1 = new Estudante(); e1.setId(1); e1.setName("Pedro");
         * e1.setAge(20); e1.setCourse("ADS"); e1.setTelephone(123456789);
         * 
         * Estudante e2 = new Estudante(); e2.setId(2); e2.setName("Enrique");
         * e2.setAge(20); e2.setCourse("ADS"); e2.setTelephone(123456789);
         * 
         * lista.add(e1); lista.add(e2);
         */

        return lista;
    }

    // EndPoint 2
    // Desvolve um estudante pelo seu id
    // http://localhost:8080/estudantes/{id}
    // http://localhost:8080/estudantes/1 (devolve o estudante com id 1)

    @GetMapping("{id}")
    public Estudante getEstudante(@PathVariable Long id) {

        Optional<Estudante> op = repo.findById(id);
        Estudante estudante = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return estudante;
    }

    // EndPoint 3
    // Salva um estudante, é necessário passar os dados do estudante no formato JSON
    @PostMapping
    public Estudante salvar(@RequestBody Estudante estudante) {
        estudante = repo.save(estudante);
        return estudante;
    }

    // EndPoint 4
    // Altera um estudante, é necessário passar os dados do estudante no formato JSON e tambem o id
    @PutMapping("{id}")
    public Estudante alterar(@RequestBody Estudante updateEstudante, @PathVariable Long id) {
        Optional<Estudante> op = repo.findById(id);
        Estudante estudante = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        estudante.setName(updateEstudante.getName());
        estudante.setAge(updateEstudante.getAge());
        estudante.setCourse(updateEstudante.getCourse());
        estudante.setTelephone(updateEstudante.getTelephone());
        repo.save(estudante);
        return estudante;
    }

    // EndPoint 5
    // Remove um estudante, é necessário passar o id
    @DeleteMapping("{id}")
    public void remover(@PathVariable Long id) {
        Optional<Estudante> op = repo.findById(id);
        Estudante estudante = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(estudante);
    }

}
