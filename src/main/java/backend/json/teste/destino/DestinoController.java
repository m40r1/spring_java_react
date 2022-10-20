package backend.json.teste.destino;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DestinoController {
	private final DestinoRepository destinoRepository;

	/**
	 * @param destinoRepository
	 */
	public DestinoController(final DestinoRepository destinoRepository) {
		this.destinoRepository = destinoRepository;
	}

	@PostMapping("/destino")
	Destino cadastroDestino(@RequestBody @Valid final Destino destino) {
		return destinoRepository.save(destino);
	}

	@GetMapping("/destino")
	List<Destino> todoDestinos() {
		return destinoRepository.findAll();
	}

	@GetMapping("/destino/{id}")
	Destino acharDestinoiD(@PathVariable("id") final long id) {
		return destinoRepository.findById(id).get();
	}

	@DeleteMapping("/destino/{id}")
	void deleDestino(@PathVariable final long id) {
		destinoRepository.deleteById(id);
		// @GetMapping("/destino/{nome}")
		// public Destino acharDestinoNome(@PathVariable("nome") String nome) {
		// return destinoRepository.findByNome(nome);
		// }

		// @PutMapping("/destino")
	}
}
