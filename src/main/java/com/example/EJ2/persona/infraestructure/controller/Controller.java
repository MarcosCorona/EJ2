package com.example.EJ2.persona.infraestructure.controller;
import com.example.EJ2.persona.domain.Persona;
import com.example.EJ2.persona.infraestructure.dto.PersonaInputDTO;
import com.example.EJ2.persona.infraestructure.dto.PersonaOutputDTO;
import com.example.EJ2.persona.application.servicesImp.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController()
public class Controller {
   @Autowired
   PersonaService personaService;
   /*@Autowired
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");*/

    @PostMapping("/add")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO personaDTO) throws Exception {
        return personaService.addPersona(personaDTO);
    }

    @GetMapping("/find/persons")
    public List<Persona> getAllPersons(@RequestParam Map<String,Object> params, @RequestParam int page){
        page = params.get("page") != null ? (Integer.parseInt(params.get("page").toString()) -1) : 0;
        PageRequest pageRequest = PageRequest.of(page,5);
        Page<Persona> pagePersona = personaService.getAllPersons(pageRequest);
        int totalPage = pagePersona.getTotalPages();
        if(totalPage > 0){
            List<Integer> pages = IntStream.rangeClosed(1, totalPage)
                    .boxed().toList();
        }

        return pagePersona.stream().toList();

    }

    @GetMapping("{id}")
    public PersonaOutputDTO findPersonById(@PathVariable Integer id) throws Exception{
        return personaService.findPersonById(id);
    }
    @GetMapping("/find/{name}")
    public List<PersonaOutputDTO> findPersonByName(@PathVariable String name) throws Exception{
        return  personaService.findPersonsByName(name)
                .stream()
                .map(PersonaOutputDTO::new)
                .toList();
    }
    @PersistenceContext
    private EntityManager em;
    @GetMapping("/gtDate")
    public List<Persona> findPersonByDate(@RequestParam Date greaterDate ) throws Exception{
        return personaService.findByGreaterDate(greaterDate);
    }
    @GetMapping("/ltDate")
    public List<Persona> findPersonByLtDate(@RequestParam Date lowerDate ) throws Exception{
        return personaService.findByLowerDate(lowerDate);
    }
    @GetMapping("/eqDate")
    public List<Persona> findPersonByEqDate(@RequestParam Date lowerDate ) throws Exception{
        return personaService.findByEqualsDate(lowerDate);
    }

}
