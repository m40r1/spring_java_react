package backend.json.teste.destino;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Destino {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "destino_id")
  private long destinoId;

  @NotBlank
  @Column(name = "nome", unique = true, nullable = false, updatable = false)
  private String nome;
  @Column(name = "qt_tickets")
  // Patern match{regex_numero}
  private int qtTickets;
  @NotBlank
  // TODO validar baseado no enum
  private String continente;
  @NotBlank private String pais;
  @NotBlank @Column(name = "descricao_viagem") private String descricaoViagem;

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "Destino [" +
        (continente != null ? "continente=" + continente + ", " : "") +
        (descricaoViagem != null ? "descricaoViagem=" + descricaoViagem + ", "
                                 : "") +
        "id=" + destinoId + ", " + (nome != null ? "nome=" + nome + ", " : "") +
        (pais != null ? "pais=" + pais + ", " : "") + "qtTickets=" + qtTickets +
        "]";
  }

  /**
   * @param id
   * @param descricaoViagem
   */
  public Destino(final long id, final String descricaoViagem) {
    this.destinoId = id;
    this.descricaoViagem = descricaoViagem;
  }

  /**
   * @param destinoId
   * @param nome
   * @param qtTickets
   * @param continente
   * @param pais
   * @param descricaoViagem
   */
  public Destino(final long destinoId, final String nome, final int qtTickets,
                 final String continente, final String pais,
                 final String descricaoViagem) {
    this.destinoId = destinoId;
    this.nome = nome;
    this.qtTickets = qtTickets;
    this.continente = continente;
    this.pais = pais;
    this.descricaoViagem = descricaoViagem;
  }

  /**
   * @param nome
   * @param qtTickets
   * @param continente
   * @param pais
   * @param descricaoViagem
   */
  public Destino(final String nome, final int qtTickets,
                 final String continente, final String pais,
                 final String descricaoViagem) {
    this.nome = nome;
    this.qtTickets = qtTickets;
    this.continente = continente;
    this.pais = pais;
    this.descricaoViagem = descricaoViagem;
  }

  /**
   * @return the destinoId
   */
  public long getDestinoId() { return destinoId; }

  /**
   * @param id the id to set
   */
  public void setId(final long id) { this.destinoId = id; }

  /**
   * @return the nome
   */
  public String getNome() { return nome; }

  /**
   * @param nome the nome to set
   */
  public void setNome(final String nome) { this.nome = nome; }

  /**
   * @return the qtTickets
   */
  public int getqtTickets() { return qtTickets; }

  /**
   * @param qtTickets the qtTickets to set
   */
  public void setqtTickets(final int qtTickets) { this.qtTickets = qtTickets; }

  /**
   * @return the continente
   */
  public String getContinente() { return continente; }

  /**
   * @param continente the continente to set
   */
  public void setContinente(final String continente) {
    this.continente = continente;
  }

  /**
   * @return the pais
   */
  public String getPais() { return pais; }

  /**
   * @param pais the pais to set
   */
  public void setPais(final String pais) { this.pais = pais; }

  /**
   * @return the descricaoViagem
   */
  public String getdescricaoViagem() { return descricaoViagem; }

  /**
   * @param descricaoViagem the descricaoViagem to set
   */
  public void setdescricaoViagem(final String descricaoViagem) {
    this.descricaoViagem = descricaoViagem;
  }

  /**
   *
   */
  public Destino() {}
}
