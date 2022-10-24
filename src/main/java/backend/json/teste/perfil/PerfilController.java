package backend.json.teste.perfil;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import backend.json.teste.destino.DestinoController;
import backend.json.teste.ticket.Ticket;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.json.teste.ticket.TicketRepository;

@RestController
public class PerfilController {
    private final PasswordEncoder passwordEncoder;
    private final PerfilRepository perfilRepository;
    private final TicketRepository ticketRepository;
    private final DestinoController destinoController;

    public PerfilController(PasswordEncoder passwordEncoder, PerfilRepository perfilRepository, TicketRepository ticketRepository, DestinoController destinoController) {
        this.passwordEncoder = passwordEncoder;
        this.perfilRepository = perfilRepository;
        this.ticketRepository = ticketRepository;
        this.destinoController = destinoController;
    }

    //@PostMapping("/perfil")
    //Perfil cadastroPerfil(@RequestBody @Valid final Perfil perfil) {
    //TODO use service signup
//    }

    @GetMapping("/perfil")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Perfil> todosPerfil() {
        return perfilRepository.findAll();
    }

    @GetMapping("/perfil/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PERFIL')")
    Perfil umPerfil(@PathVariable final long id) {
        return perfilRepository.findById(id).get();
    }

    //TODO atualizar senha e email
    @PutMapping("/perfil/{id}{senha}")
    @PreAuthorize("hasRole('ROLE_PERFIL')")
    void atualizaPerfil() {
    }


    @PutMapping("/perfil/{ticket}")
    @PreAuthorize("hasRole('ROLE_PERFIL')")
    UUID compraTicket(@PathVariable final UUID id, final Perfil perfil) {
        //vincula o ticket a um perfil
        //diminui a qt_disponivel
        if (ticketRepository.findById(id).isPresent()) {
            Ticket ticket = ticketRepository.findById(id).get();
            ticket.setId_perfil(perfil.getId());
            destinoController.diminuiQtTicket(ticket.getId_destino());
        }
        return id;
    }
}
