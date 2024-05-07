package com.fcfm.backend.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@NamedQuery(name="getAllAlumnos", query="select e from Alumno e")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumnoId", nullable = false)
    @NotNull(message = "Porfavor, coloque el id del elemento a actualizar.")
    private Long alumnoId;

    @NotNull(message = "Porfavor, coloque su primer nombre.")
    private String primerNombre;

    @NotNull(message = "Porfavor, coloque su segundo nombre.")
    private String segundoNombre;

    @NotNull(message = "Porfavor, coloque su apellido paterno.")
    private String apellidoPat;

    @NotNull(message = "Porfavor, coloque su apellido materno.")
    private String apellidoMat;

    @NotNull(message = "Porfavor, coloque su fecha de nacimiento.")
    private Date fechaNac;

    @NotNull(message = "Porfavor, coloque su curp.")
    private String curp;

    @NotNull(message = "Porfavor, coloque su correo.")
    private String email;

    public Alumno(String primerNombre, String segundoNombre, String apellidoPat, String apellidoMat, Date fechaNac, String curp, String email) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.fechaNac = fechaNac;
        this.curp = curp;
        this.email = email;
    }

    public Alumno() {

    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
