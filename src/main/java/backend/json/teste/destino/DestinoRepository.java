package backend.json.teste.destino;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
	Destino findByNome(String nome);
}
