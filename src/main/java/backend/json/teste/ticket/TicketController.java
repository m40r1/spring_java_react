package backend.json.teste.ticket;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import backend.json.teste.destino.Destino;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    private TicketRepository ticketRepository;

    @PostMapping("/ticket")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_AGENTE')")
    public List<Ticket> gerarTickets(@RequestBody @Valid final Iterable<Ticket> ticket) {
        ticket.iterator().next().setId(UUID.randomUUID());
        return ticketRepository.saveAll(ticket);
    }

    // Destino associado ao ticket e retornado
    // para que seja passado para o diminuiTicket no destinoController
    // sera ativida ao perfil comprar um ticket
    // @PutMapping("/ticket/{id}")
    // long diminuiTicket(@PathVariable final UUID ticketId) {
    // Ticket ticket = ticketRepository.findById(ticketId).get();
    // return ticket.getId_destino();
    // }
}
