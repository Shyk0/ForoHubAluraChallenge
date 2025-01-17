package forohub.forohub.domain.topic;

import java.time.LocalDateTime;

public record DetallesTopicDTO(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        LocalDateTime fechaCreacion,
        String status) {
}
