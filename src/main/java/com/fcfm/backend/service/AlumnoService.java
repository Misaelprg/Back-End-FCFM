package com.fcfm.backend.service;
import com.fcfm.backend.model.UserLogin;
import com.fcfm.backend.repository.entity.Alumno;
import com.fcfm.backend.response.LoginMessage;

import java.util.List;


public interface AlumnoService {
    void createAlumno(Alumno newAlumno);
    List<Alumno> getAlumnoList();
    com.fcfm.backend.model.Alumno getAlumnoById(int id);
    String deleteAlumnoById(int id);
    com.fcfm.backend.model.Alumno updateAlumno(Alumno alumno);
    LoginMessage loginAlumno(UserLogin userLogin);
}
