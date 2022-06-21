package com.example.EJ2.Persona.clases.services;

import com.example.EJ2.Persona.clases.dbManagement.Persona;
import com.example.EJ2.Persona.clases.dto.PersonaInputDTO;
import com.example.EJ2.Persona.clases.dto.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaInterface {

    PersonaOutputDTO addPersona(PersonaInputDTO personaDTO) throws Exception;
    PersonaOutputDTO findPersonById(int id);
    List<PersonaOutputDTO> findPersonsByName(String usuario);

    List<Persona> getAllPersons();
}
