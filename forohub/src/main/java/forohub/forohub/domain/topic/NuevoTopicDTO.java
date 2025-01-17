package forohub.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record NuevoTopicDTO(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso) {
}
