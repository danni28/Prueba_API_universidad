package com.universidad.cruduniversidad.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Profesor")
@Getter
@Setter
public class ProfesorModel extends PersonaModel implements Serializable {
    private Float Salario;
    private String Dependencia;
    private String Materia;
    public ProfesorModel() { }
}
