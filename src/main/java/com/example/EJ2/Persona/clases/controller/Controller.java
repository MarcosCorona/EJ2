package com.example.EJ2.Persona.clases.controller;
import com.example.EJ2.Persona.clases.dbManagement.Persona;
import com.example.EJ2.Persona.clases.dto.PersonaInputDTO;
import com.example.EJ2.Persona.clases.dto.PersonaOutputDTO;
import com.example.EJ2.Persona.clases.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class Controller {
   @Autowired
   PersonaService personaService;

    @PostMapping("/add")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO personaDTO) throws Exception {
        //cogemos el outputDTO
        PersonaOutputDTO personaOutputDTO = personaService.addPersona(personaDTO);

        //al hacer esto facilitamos el id al front. Usualmente autoincrementales.
        return personaOutputDTO;
    }

    @GetMapping("/getAll")
    public List<Persona> getAllPersons(){
        return personaService.getAllPersons();
    }

    @GetMapping("{id}")
    public Optional<Persona> findPersonById(@PathVariable Integer id) throws Exception{
        Optional<Persona> output =  personaService.findPersonById(id);
        return output;
    }



}
