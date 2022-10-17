package backend.json.teste.destino;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DestinoController {
	private DestinoRepository destinoRepository;

	@PostMapping("/cadastro_destino")
	public Destino cadastroDestino(@RequestBody @Valid final Destino destino) {
		return destinoRepository.save(destino);
	}

	@GetMapping("/destino/{id}")
	public Destino acharDestinoiD(@PathVariable("id") final long id) {
		return destinoRepository.findById(id).get();
	}

	@GetMapping("/destino/{nome}")
	public Destino acharDestinoNome(@PathVariable("nome") String nome) {
		return destinoRepository.findByNome(nome);
	}
}
