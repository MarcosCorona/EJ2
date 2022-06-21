package com.example.EJ2.Persona.clases.controller;
import com.example.EJ2.Persona.clases.dbManagement.Persona;
import com.example.EJ2.Persona.clases.dto.PersonaInputDTO;
import com.example.EJ2.Persona.clases.dto.PersonaOutputDTO;
import com.example.EJ2.Persona.clases.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find/persons")
    public List<Persona> getAllPersons(){
        List<Persona> output =  personaService.getAllPersons();
        return output;
    }

    @GetMapping("{id}")
    public PersonaOutputDTO findPersonById(@PathVariable Integer id) throws Exception{
        PersonaOutputDTO output =  personaService.findPersonById(id);
        return output;
    }
    @GetMapping("/find/{name}")
    public List<PersonaOutputDTO> findPersonByName(@PathVariable String name) throws Exception{
        List<PersonaOutputDTO> output =  personaService.findPersonsByName(name);
        return output;
    }


}
