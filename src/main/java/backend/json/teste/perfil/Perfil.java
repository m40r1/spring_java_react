package backend.json.teste.perfil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "perfil_id")
    private long perfilId;
    @NotBlank
    private String nome;

    @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")
    @Column(unique = true, name = "cpf", nullable = false, updatable = false)
    private long cpf;
    @Column(name = "cep", length = 11)
    private long cep;
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String senha;
    @Email
    @Column(unique = true, updatable = true, nullable = false)
    private String email;

    /**
     *
     */
    public Perfil(@NotBlank final String nome,
                  @Pattern(regexp = "([0-9]{2}\\.[0-9]{3}\\..-9]{3}\\/?[/]{4}-?[0-9]{2})|([0-9]{3}\\.?[0-9].\\.?[0-9]{3.[0-9]{2})") final long cpf,
                  @Pattern(regexp = "") final long cep,
                  @Pattern(regexp = "^.*(?=.{8,})(?=.+[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$") final String senha,
                  @Email final String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.senha = senha;
        this.email = email;
    }

    /**
     *
     */
    public Perfil(final long id, @NotBlank final String nome,
                  @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})") final long cpf,
                  @Pattern(regexp = "") final long cep,
                  @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$") final String senha,
                  @Email final String email) {
        this.perfilId = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.senha = senha;
        this.email = email;
    }

    /**
     *
     */
    public Perfil() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return perfilId;
    }

    /**
     * @param id the id to set
     */
    public void setId(final long id) {
        this.perfilId = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(final String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(final long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the cep
     */
    public long getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(final long cep) {
        this.cep = cep;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(final String senha) {
        this.senha = senha;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Perfil [cep=" + cep + ", cpf=" + cpf + ", " + (email != null ? "email=" + email + ", " : "") + "id="
                + perfilId + ", " + (nome != null ? "nome=" + nome + ", " : "") + (senha != null ? "senha=" + senha : "") + "]";
    }

}
