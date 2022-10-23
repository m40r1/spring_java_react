package backend.json.teste.destino;

import java.util.List;
import javax.validation.Valid;

import backend.json.teste.ticket.TicketController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DestinoController {
  private final DestinoRepository destinoRepository;
  /**
   */
  public DestinoController(final DestinoRepository destinoRepository) {
    this.destinoRepository = destinoRepository;
  }

  @PostMapping("/destino")
  Destino cadastroDestino(@RequestBody @Valid final Destino destino) {
    // TODO
    // ao cadastrar destino
    // cadastrar tbm a qt de tickets especificados

    return destinoRepository.save(destino);
  }

  @GetMapping("/destino")
  List<Destino> todoDestinos() {
    return destinoRepository.findAll();
  }

  @GetMapping("/destino/{nome}")
  Destino acharDestinoNome(@PathVariable String nome) {
    return destinoRepository.findByNome(nome);
  }

  @GetMapping("/destino/{id}")
  Destino acharDestinoiD(@PathVariable("id") final long id) {
    return destinoRepository.findById(id).get();
  }

  @DeleteMapping("/destino/{id}")
  void deleteDestino(@PathVariable final long id) {
    destinoRepository.deleteById(id);
    // @GetMapping("/destino/{nome}")
    // public Destino acharDestinoNome(@PathVariable("nome") String nome) {
    // return destinoRepository.findByNome(nome);
  }

  // Passar valor da metodo diminuiTicket
  // do TicketController
  public int diminuiQtTicket(final long id) {
    final Destino destino = destinoRepository.findById(id).get();
    final int qt_destino = destino.getqtTickets();
    if (qt_destino > 0) {
      destino.setqtTickets(qt_destino - 1);
    }
    return destino.getqtTickets();
  }
}
