package backend.json.teste.perfil;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
public class PerfilService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "usuario com email %s nao existe";
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;

    public PerfilService(PerfilRepository perfilRepository, PasswordEncoder passwordEncoder) {
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return perfilRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public String cadastroPerfil(@Valid Perfil perfil) {
        if (perfilRepository.findByEmail(perfil.getEmail()).isPresent()) {
            throw new IllegalStateException("email already taken");
        }
        perfil.setPassword(passwordEncoder.encode(perfil.getPassword()));
        perfilRepository.save(perfil);
        String token = UUID.randomUUID().toString();

        return "";
    }

    public int enableAppUser(String email) {
        return perfilRepository.enablePerfil(email);
    }
}
