
package com.desarrollo.basePostgrest.repositorios;

import com.desarrollo.basePostgrest.objetos.Cursos;
import com.desarrollo.basePostgrest.objetos.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Integer> {
}
