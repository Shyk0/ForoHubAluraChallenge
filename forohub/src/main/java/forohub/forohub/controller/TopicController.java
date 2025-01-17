package forohub.forohub.controller;

import forohub.forohub.domain.topic.ActualizarTopicDTO;
import forohub.forohub.domain.topic.FiltrarTopicDTO;
import forohub.forohub.domain.topic.NuevoTopicDTO;
import forohub.forohub.domain.topic.Topic;
import forohub.forohub.domain.topic.TopicRepository;
import forohub.forohub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<?> nuevoTopic(@RequestBody @Valid NuevoTopicDTO nuevoTopicDTO){
        try {
            if (topicRepository.existsByTituloAndMensaje(nuevoTopicDTO.titulo(), nuevoTopicDTO.mensaje())) {
                return ResponseEntity.status(400).body("El topic ya existe.");
            }
            Topic nuevoTopic = new Topic(nuevoTopicDTO);
            topicRepository.save(nuevoTopic);
            return ResponseEntity.ok(new FiltrarTopicDTO(nuevoTopic));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al registrar el topic: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page<FiltrarTopicDTO>> filtrarTopicDTO(@PageableDefault(size = 3) Pageable pageable) {
        Page<Topic> topic = topicRepository.findAll(pageable);
        Page<FiltrarTopicDTO> filtrarTopicDTOS = topic.map(FiltrarTopicDTO::new);
        return ResponseEntity.ok(filtrarTopicDTOS);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTopicId(@PathVariable Long id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();
            FiltrarTopicDTO dto = new FiltrarTopicDTO(topic);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(404).body("Topic no encontrado");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> actualizarTopic(@PathVariable Long id, @RequestBody ActualizarTopicDTO actualizarTopicDTO) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();
            topic.actualizarTopicos(actualizarTopicDTO);
            return ResponseEntity.ok(new FiltrarTopicDTO(topic));
        } else {
            return ResponseEntity.status(404).body("Topic no encontrado");
        }
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarTopic(@PathVariable Long id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok("Topic eliminado exitosamente");
        } else {
            return ResponseEntity.status(404).body("Topic no encontrado");
        }
    }
}




