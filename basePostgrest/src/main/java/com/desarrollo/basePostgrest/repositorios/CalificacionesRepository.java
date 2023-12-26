
package com.desarrollo.basePostgrest.repositorios;

import com.desarrollo.basePostgrest.objetos.Calificaciones;
import com.desarrollo.basePostgrest.objetos.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionesRepository extends JpaRepository<Calificaciones, Integer> {
}
