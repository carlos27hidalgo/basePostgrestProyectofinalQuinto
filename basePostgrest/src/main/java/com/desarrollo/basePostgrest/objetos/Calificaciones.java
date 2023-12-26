
package com.desarrollo.basePostgrest.objetos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "calificaciones")
public class Calificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCalificaciones;

    //@ManyToOne
    //@JoinColumn(name = "estudiante_id", nullable = false)
    private Integer idEstudiante;

    //@ManyToOne
    //@JoinColumn(name = "estudiante_nombre", nullable = false)
    private String anombreEstudiante;

    //@ManyToOne
    //@JoinColumn(name = "estudiante_codigo", nullable = false)
    private String bcodMateria;

    private Double calificacion;


}
