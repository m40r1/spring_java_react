package backend.json.teste.destino;

import org.springframework.data.repository.CrudRepository;

public interface DestinoRepository extends CrudRepository<Destino, Long> {

	Destino findByNome(String nome);
}
