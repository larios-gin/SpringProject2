package cat.itb.springproject.model.repositori;

import cat.itb.springproject.model.Pokemon;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepositori extends CrudRepository<Pokemon, String> {
    Object findAll(Sort nomPokemon);
}
