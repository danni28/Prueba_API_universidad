package com.universidad.cruduniversidad.repository;

import com.universidad.cruduniversidad.models.ProfesorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends CrudRepository<ProfesorModel, Integer> {
}
