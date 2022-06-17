package com.example.EJ2.Persona.clases.services;

import com.example.EJ2.Persona.clases.dbManagement.Persona;
import com.example.EJ2.Persona.clases.dto.PersonaInputDTO;
import com.example.EJ2.Persona.clases.dto.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonaInterface {

    PersonaOutputDTO addPersona(PersonaInputDTO personaDTO) throws Exception;
    Optional<Persona> findPersonById(int id);
    List<PersonaOutputDTO> findPersonsByUsuario(String usuario);

    List<Persona> getAllPersons();
}
