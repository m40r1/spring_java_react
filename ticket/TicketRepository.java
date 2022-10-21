package backend.json.teste.ticket;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
	// TODO FindByidDestino
}
