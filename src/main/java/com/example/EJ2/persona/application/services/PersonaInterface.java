package com.example.EJ2.persona.application.services;

import com.example.EJ2.persona.domain.Persona;
import com.example.EJ2.persona.infraestructure.dto.PersonaInputDTO;
import com.example.EJ2.persona.infraestructure.dto.PersonaOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Expression;
import java.awt.print.Pageable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public interface PersonaInterface {

    PersonaOutputDTO addPersona(PersonaInputDTO personaDTO) throws Exception;
    PersonaOutputDTO findPersonById(int id);
    List<PersonaOutputDTO> findPersonsByName(String usuario);

    Page<Persona> getAllPersons(PageRequest pageable);

    List<Persona> findByGreaterDate(Date date);

    List<Persona> findByLowerDate(Date date) throws ParseException;

    List<Persona> findByEqualsDate(Date date);
}
