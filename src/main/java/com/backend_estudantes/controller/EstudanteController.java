package com.backend_estudantes.controller;

import java.util.List;
import com.backend_estudantes.entities.Estudante;
import com.backend_estudantes.repository.EstudanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepository repo;

    // EndPoint
    // Devolve todos os Estudantes
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

}
