package com.universidad.cruduniversidad.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer Id;
    private String NombreCompleto;
    private String Identificacion;
    private String NumeroTelefono;
    private String Email;
    private String DireccionResidencia;
    private String Genero;

}
