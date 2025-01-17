package forohub.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record AuthUsuarioDTO(


        @NotBlank
        String username,

        @NotBlank
        String password) {
}