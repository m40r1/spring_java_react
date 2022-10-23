package backend.json.teste.perfil;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import backend.json.teste.destino.DestinoController;
import backend.json.teste.ticket.Ticket;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private DestinoController destinoController;

    @PostMapping("/perfil")
    Perfil cadastroPerfil(@RequestBody @Valid final Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @GetMapping("/perfil")
    @PreAuthorize()
    List<Perfil> todosPerfil() {
        return perfilRepository.findAll();
    }

    @GetMapping("/perfil/{id}")
    Perfil umPerfil(@PathVariable final long id) {
        return perfilRepository.findById(id).get();
    }

    //TODO atualizar senha e email
    @PutMapping("/perfil/{id}{senha}")
    void atualizaPerfil() {
    }


    @PutMapping("/perfil/{ticket}")
    UUID compraTicket(@PathVariable final UUID id, final Perfil perfil) {

        if (ticketRepository.findById(id).isPresent()) {
            Ticket ticket = ticketRepository.findById(id).get();
            ticket.setId_perfil(perfil.getId());
            destinoController.diminuiQtTicket(ticket.getId_destino());
        }
        return id;
    }
}
