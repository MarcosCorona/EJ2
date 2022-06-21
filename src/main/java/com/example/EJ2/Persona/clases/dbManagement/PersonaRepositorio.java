package com.example.EJ2.Persona.clases.dbManagement;

import com.example.EJ2.Persona.clases.dto.PersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona,Integer>{
    List<PersonaOutputDTO> findByName(String persona);

}
