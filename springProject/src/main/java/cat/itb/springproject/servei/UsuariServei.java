package cat.itb.springproject.servei;

import cat.itb.springproject.model.Usuari;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuariServei {

    private List<Usuari> repo = new ArrayList<>();

    public void nou(Usuari u) {
        u.setContrasenya(passwordEncoder(u.getContrasenya()));
        repo.add(u);
    }

    @PostConstruct
    public void init() {
        repo.addAll(
            Arrays.asList(
                    new Usuari("Roger", passwordEncoder("roger123"), "roger123", "USER"),
                    new Usuari("Montse", passwordEncoder("montseprogramacio"), "montseprogramacio", "USER"),
                    new Usuari("Lario", passwordEncoder("lario321"), "lario321", "USER"),
                    new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN", "ADMIN")
        ));
    }

    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }

    public Usuari consultaPerId(String s) {
        Usuari u = null;
        boolean trobat = false;
        for (int i = 0; i < repo.size() && !trobat; i++) {
            if (s.equals(repo.get(i).getNomUsuari())) {
                u = repo.get(i);
                trobat = true;
            }
        }
        return u;
    }

}
