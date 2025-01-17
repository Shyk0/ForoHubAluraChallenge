package forohub.forohub.controller;


import forohub.forohub.domain.usuario.AuthUsuarioDTO;
import forohub.forohub.domain.usuario.Usuario;
import forohub.forohub.infra.security.DtoJWTtoken;
import forohub.forohub.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/username")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    @Transactional
    public ResponseEntity autenticarUsuario(@RequestBody @Valid AuthUsuarioDTO authUsuarioDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken(authUsuarioDTO.username(),
                authUsuarioDTO.password());
        authenticationManager.authenticate(authToken);
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DtoJWTtoken(JWTtoken));
    }
}
