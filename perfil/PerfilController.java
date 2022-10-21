package backend.json.teste.perfil;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.json.teste.ticket.TicketRepository;

@RestController
public class PerfilController {
	private PerfilRepository perfilRepository;
	private TicketRepository ticketRepository;

	@PostMapping("/perfil")
	Perfil cadastroPerfil(@RequestBody @Valid final Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	@GetMapping("/perfil")
	List<Perfil> todosPerfil() {
		return perfilRepository.findAll();
	}

	@GetMapping("/perfil/{id}")
	Perfil umPerfil(@PathVariable final long id) {
		return perfilRepository.findById(id).get();
	}

	@PutMapping("/perfil/{ticket}")
	UUID compraTicket(@PathVariable final UUID id, final Perfil perfil) {
		ticketRepository.findById(id).get().setId_perfil(perfil.getId());
		// Api pra diminuir qt_ticket
		return id;
	}
}
