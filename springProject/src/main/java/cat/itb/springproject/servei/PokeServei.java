package cat.itb.springproject.servei;

import cat.itb.springproject.model.Pokemon;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PokeServei {

    private List<Pokemon> llista = new ArrayList<>();

    public void nou(Pokemon p) {
        llista.add(p);
    }

    public List<Pokemon> llista() {
        return llista;
    }

    @PostConstruct
    public void init() {
        llista.addAll(
                Arrays.asList(
                        new Pokemon("Pikachu", 25, "Electric", "Pikachu es un Pokemon de tipus Electric introduit a la primera generacio"),
                        new Pokemon("Gyarados", 130, "Aigua / Volador", "Gyarados es un Pokemon tipus Aigua / Volador introduit a la primera generacio"),
                        new Pokemon("Jigglypuff", 39, "Normal / Fada", "Jigglypuff es un Pokemon de tipus Normal / Fada introduit a la primera generacio")
                ));
    }

    public void sortByNum() {
        llista.sort(Comparator.comparingLong(Pokemon::getNumPokemon));
    }

    public Pokemon consultaNom(String s) {
        Pokemon p = null;
        boolean trobat = false;
        for (int i = 0; i < llista.size() && !trobat; i++) {
            if (s.equals(llista.get(i).getNomPokemon())) {
                p = llista.get(i);
                trobat = true;
            }
        }
        return p;
    }

    public void eliminarPokemonNom(String s) {
        Pokemon p = null;
        boolean trobat = false;
        for (int i = 0; i < llista.size() && !trobat; i++) {
            if (s.equals(llista.get(i).getNomPokemon())) {
                p = llista.get(i);
                trobat = true;
            }
        }
        llista.remove(p);
    }

    public void updatePokemon(Pokemon p, String nom) {
        for (int i = 0; i < llista.size(); i++) {
            if (nom.equals(llista.get(i).getNomPokemon())) {
                llista.get(i).setNomPokemon(p.getNomPokemon());
                llista.get(i).setNumPokemon(p.getNumPokemon());
                llista.get(i).setTipusPokemon(p.getTipusPokemon());
                llista.get(i).setDescripcioPokemon(p.getDescripcioPokemon());
            }
        }
    }
}
