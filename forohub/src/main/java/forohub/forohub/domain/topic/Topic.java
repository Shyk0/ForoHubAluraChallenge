package forohub.forohub.domain.topic;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name= "topic")
@Entity(name= "Topic")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Data


public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private String curso;


    public Topic(NuevoTopicDTO nuevoTopic) {
        this.titulo = nuevoTopic.titulo();
        this.mensaje = nuevoTopic.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = Status.ABIERTO;
        this.autor = nuevoTopic.autor();
        this.curso = nuevoTopic.curso();
    }


    public void actualizarTopicos(ActualizarTopicDTO actualizarTopic) {
        if (actualizarTopic.titulo() != null) {
            this.titulo = actualizarTopic.titulo();
        }
        if (actualizarTopic.mensaje() != null) {
            this.mensaje = actualizarTopic.mensaje();
        }
        if (actualizarTopic.autor() != null) {
            this.autor = actualizarTopic.autor();
        }
        if (actualizarTopic.curso() != null) {
            this.curso = actualizarTopic.curso();
        }
    }

}

