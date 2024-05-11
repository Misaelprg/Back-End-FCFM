package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.model.UserLogin;
import com.fcfm.backend.response.LoginMessage;
import com.fcfm.backend.repository.entity.Alumno;
import com.fcfm.backend.service.AlumnoService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
public class AlumnoApiControllerImpl implements AlumnoApiController {

    private AlumnoService alumnoService;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Autowired
    AlumnoApiControllerImpl(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @Override
    public ResponseEntity<String> createAlumno(@RequestBody Alumno alumnoNuevo, BindingResult result) {
        Set<ConstraintViolation<Alumno>> violations = validator.validate(alumnoNuevo);

        if(!violations.isEmpty()) {
            String errores = new String();

            for (ConstraintViolation<Alumno> violation : violations) {
                errores += violation.getMessage().toString() + "\n";
            }
            return ResponseEntity.ok().body(errores);
            }
        else {
                alumnoService.createAlumno(alumnoNuevo);
                return ResponseEntity.ok().body("Alumno creado éxitosamente.");
            }
    }

    @Override
    public ResponseEntity<List<Alumno>> getAlumnoList() {
        return ResponseEntity.ok().body(alumnoService.getAlumnoList());
    }

    @Override
    public ResponseEntity<com.fcfm.backend.model.Alumno> getAlumnoById(@PathVariable int idAlumno) {
        return ResponseEntity.ok().body(alumnoService.getAlumnoById(idAlumno));
    }

    @Override
    public ResponseEntity<?> updateAlumnoById(@RequestBody Alumno alumno) {
            return ResponseEntity.ok().body(alumnoService.updateAlumno(alumno));
    }

    @Override
    public ResponseEntity<String> deleteAlumnoById(@PathVariable int idAlumno) {
        return ResponseEntity.ok().body(alumnoService.deleteAlumnoById(idAlumno));
    }

    @Override
    public ResponseEntity<?> loginAlumno(@RequestBody UserLogin userLogin) {
        LoginMessage message = alumnoService.loginAlumno(userLogin);
        return ResponseEntity.ok().body(message);
    }




}
