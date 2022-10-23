package backend.json.teste.ticket;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import backend.json.teste.destino.Destino;
import backend.json.teste.perfil.Perfil;

@Entity
@Table
public class Ticket {
	@Id
	@Column(name = "ticket_id")
	private UUID ticketId;
	@NotNull
	private long preco;
	private long desconto;
	@NotNull
	@ManyToOne(targetEntity = Destino.class)
	@JoinColumn(name = "destino_id")
	private long id_destino;
	// TODO
	@ManyToOne(targetEntity = Perfil.class)
	@JoinColumn(name = "perfil_id")
	private long id_perfil;
	@NotNull
	private int duracao;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return ticketId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final UUID id) {
		this.ticketId = id;
	}

	/**
	 * @return the preco n
	 */
	public long getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(final long preco) {
		this.preco = preco;
	}

	/**
	 * @return the desconto
	 */
	public long getDesconto() {
		return desconto;
	}

	/**
	 * @param desconto the desconto to set
	 */
	public void setDesconto(final long desconto) {
		this.desconto = desconto;
	}

	/**
	 * @return the id_destino
	 */
	public long getId_destino() {
		return id_destino;
	}

	/**
	 * @param id_destino the id_destino to set
	 */
	public void setId_destino(final long id_destino) {
		this.id_destino = id_destino;
	}

	/**
	 * @return the id_perfil
	 */
	public long getId_perfil() {
		return id_perfil;
	}

	/**
	 * @param id_perfil the id_perfil to set
	 */
	public void setId_perfil(final long id_perfil) {
		this.id_perfil = id_perfil;
	}

	/**
	 * @return the duracao
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * @param duracao the duracao to set
	 */
	public void setDuracao(final int duracao) {
		this.duracao = duracao;
	}

	/**
     */
	public Ticket(final UUID id, @NotNull final long preco, final long desconto, @NotNull final long id_destino,
			final long id_perfil, @NotNull final int duracao) {
		this.ticketId = id;
		this.preco = preco;
		this.desconto = desconto;
		this.id_destino = id_destino;
		this.id_perfil = id_perfil;
		this.duracao = duracao;
	}

	/**
     */
	public Ticket(@NotNull final long preco, final long desconto, @NotNull final long id_destino, final long id_perfil,
			@NotNull final int duracao) {
		this.preco = preco;
		this.desconto = desconto;
		this.id_destino = id_destino;
		this.id_perfil = id_perfil;
		this.duracao = duracao;
	}

	/**
	 *
	 */
	public Ticket() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Ticket [desconto=" + desconto + ", duracao=" + duracao + ", "
				+ (ticketId != null ? "id=" + ticketId + ", " : "") + "id_destino=" + id_destino + ", id_perfil="
				+ id_perfil + ", preco=" + preco + "]";
	}
}
