package com.universidad.cruduniversidad.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Alumno")
@Getter
@Setter
public class AlumnoModel extends PersonaModel implements Serializable {
    private String NumeroMatricula;
    private String Programa;
    private Float NotaPromedio;
    public AlumnoModel() { }
}
