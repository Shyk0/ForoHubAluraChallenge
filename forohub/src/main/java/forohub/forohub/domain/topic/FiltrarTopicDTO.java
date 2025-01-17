package forohub.forohub.domain.topic;

import java.time.LocalDateTime;

public record FiltrarTopicDTO(
        Long id,
        String titulo,
        String autor,
        String curso,
        String mensaje,
        String status,
        LocalDateTime fechaCreacion) {

    public FiltrarTopicDTO(Topic topic) {
        this(topic.getId(),
                topic.getTitulo(),
                topic.getAutor(),
                topic.getCurso(),
                topic.getMensaje(),
                topic.getStatus().toString(),
                topic.getFechaCreacion());
    }
}




