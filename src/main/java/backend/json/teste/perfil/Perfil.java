package backend.json.teste.perfil;

import backend.json.teste.sec.AppRoles;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class Perfil implements UserDetails {
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled = false;
    @Enumerated(EnumType.STRING)
    private AppRoles appRoles;
    private boolean isAccountNonExpired;
    private List<List<? extends GrantedAuthority>> grantedAuthorities;
    @Positive(message = "id n pode ser negativo")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "perfil_id", nullable = false)
    private long perfilId;
    @Column(unique = true)
    @NotBlank(message = "perfil precisa de um nome")
    private String username;
    @Min(message = "cpf tem 11 digitos", value = 11)
    @Max(message = "cpf tem 11 digitos", value = 11)
    @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")
    @Column(unique = true, name = "cpf", nullable = false, updatable = false)
    private long cpf;
    @Column(name = "cep", length = 11)
    @Pattern(regexp = "/^\\d{5}(-\\d{3})?$/")
    private long cep;
    @Pattern(message = "senha deve ter no minimo 8 caracteres ,maiuscula,minuscula,numero e simbolos", regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String password;
    @Email
    @Column(unique = true, updatable = true, nullable = false)
    private String email;

    public Perfil() {
    }

    public Perfil(List<? extends GrantedAuthority> grantedAuthorities, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, AppRoles appRoles, long perfilId, String username, long cpf, long cep, String password, String email) {
        this.grantedAuthorities = Collections.singletonList(grantedAuthorities);
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.appRoles = appRoles;
        this.perfilId = perfilId;
        this.username = username;
        this.cpf = cpf;
        this.cep = cep;
        this.password = password;
        this.email = email;
    }

    public Perfil(List<? extends GrantedAuthority> grantedAuthorities, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, AppRoles appRoles, String username, long cpf, long cep, String password, String email) {
        this.grantedAuthorities = Collections.singletonList(grantedAuthorities);
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.appRoles = appRoles;
        this.username = username;
        this.cpf = cpf;
        this.cep = cep;
        this.password = password;
        this.email = email;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appRoles.name());
        return Collections.singletonList(authority);
    }

    public List<List<? extends GrantedAuthority>> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public AppRoles getAppRoles() {
        return appRoles;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(long perfilId) {
        this.perfilId = perfilId;
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
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * @param username the nome to set
     */
    public void setUsername(final String username) {
        this.username = username;
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
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @param password the senha to set
     */
    public void setPassword(final String password) {
        this.password = password;
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
                + perfilId + ", " + (username != null ? "nome=" + username + ", " : "") + (password != null ? "senha=" + password : "") + "]";
    }

}
