package backend.json.teste.ticket;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
  private TicketRepository ticketRepository;

  @PostMapping("/ticket")
  List<Ticket> gerarTickets(@RequestBody @Valid final Iterable<Ticket> ticket) {
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
