package com.fcfm.backend.repository;

import com.fcfm.backend.repository.entity.Alumno;

public interface AlumnoRepository {
    void insertar(Alumno alumno);

    Alumno getAlumnoById(Long id);
}
