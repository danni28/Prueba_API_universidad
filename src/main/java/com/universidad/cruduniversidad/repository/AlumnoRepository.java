package com.universidad.cruduniversidad.repository;

import com.universidad.cruduniversidad.models.AlumnoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoModel, Integer> {
}
