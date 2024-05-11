package com.fcfm.backend.repository;

import com.fcfm.backend.repository.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository {
    void insertar(Alumno alumno);
    List<Alumno> getAlumnoList();
    Alumno getAlumnoById(Long id);
    com.fcfm.backend.model.Alumno updateAlumnoById( Alumno alumno);
    String deleteAlumnoById(Long id);
    Alumno getAlumnoByEmail(String email);
    Alumno getAlumnoByEmailAndPassword(String email, String password);
}
