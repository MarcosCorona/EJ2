package com.example.EJ2.persona.infraestructure;

import com.example.EJ2.persona.infraestructure.dto.PersonaOutputDTO;
import com.example.EJ2.persona.domain.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona,Integer>{
    List<PersonaOutputDTO> findByName(String persona);

}
