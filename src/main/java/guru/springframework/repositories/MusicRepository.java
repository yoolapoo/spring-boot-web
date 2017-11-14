package guru.springframework.repositories;

import guru.springframework.domain.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Integer>{
}
