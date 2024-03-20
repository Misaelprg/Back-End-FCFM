package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoApiControllerImpl implements AlumnoApiController{
    @Override
    public ResponseEntity<String> getName() {
        return ResponseEntity.ok().body("Misael Lomas");
    }

    @Override
    public ResponseEntity<String> getName(@PathVariable String nombreAlumno) {
        return ResponseEntity.ok().body(nombreAlumno);
    }
}
