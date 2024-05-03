package com.fcfm.backend.service;
import com.fcfm.backend.repository.entity.Alumno;


public interface AlumnoService {
    void createAlumno(Alumno newAlumno);
//    List<Alumno> getAlumnoList();
    com.fcfm.backend.model.Alumno getAlumnoById(int id);
//    void updateAlumnoById(int id, Alumno alumno);
//    void deleteAlumnoById(int id);
//    Boolean existsById(int id);

}
