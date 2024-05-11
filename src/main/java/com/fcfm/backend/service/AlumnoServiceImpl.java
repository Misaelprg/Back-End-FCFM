package com.fcfm.backend.service;

import com.fcfm.backend.model.UserLogin;
import com.fcfm.backend.response.LoginMessage;
import com.fcfm.backend.repository.entity.Alumno;
import com.fcfm.backend.repository.AlumnoRepository;
import com.fcfm.backend.utils.AlumnoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlumnoServiceImpl implements AlumnoService {

    private AlumnoRepository alumnoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AlumnoServiceImpl(AlumnoRepository alumnoRepository) { this.alumnoRepository = alumnoRepository; }

    public void createAlumno(Alumno newAlumno) {
        newAlumno.setPassword(passwordEncoder.encode(newAlumno.getPassword()));
        alumnoRepository.insertar(newAlumno);
    }

    public com.fcfm.backend.model.Alumno getAlumnoById(int id) {
        com.fcfm.backend.repository.entity.Alumno alumnoEntity = alumnoRepository.getAlumnoById(Long.valueOf(id));
        return AlumnoMapper.alumnoEntityToAlumnoModel(alumnoEntity);
    }

    public List<Alumno> getAlumnoList() {
        return alumnoRepository.getAlumnoList();
    }

    public com.fcfm.backend.model.Alumno updateAlumno(Alumno alumno) {
        return  alumnoRepository.updateAlumnoById(alumno);
    }

    public String deleteAlumnoById(int id) {
        return alumnoRepository.deleteAlumnoById(Long.valueOf(id));
    }

    public LoginMessage loginAlumno(UserLogin userLogin) {
        Alumno alumno = alumnoRepository.getAlumnoByEmail(userLogin.getEmail());
        if(alumno != null) {
            String password = userLogin.getPassword();
            String encodedPassword = alumno.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwdRight) {
                Optional<Alumno> alumnoOptional = Optional.ofNullable(alumnoRepository.getAlumnoByEmailAndPassword(userLogin.getEmail(), alumno.getPassword()));
                if(alumnoOptional.isPresent()) {
                    return new LoginMessage("Login Exitoso", true);
                } else {
                    return new LoginMessage("Login Erroneo", false);

                }
            } else {
                return new LoginMessage("La contraseña no coincide", false);
            }
        } else {
            return new LoginMessage("El correo no coincide", false);
        }
    }
}
