package guru.springframework.services;


import guru.springframework.domain.Music;

public interface MusicService {
    Iterable<Music> listAllMusics();

    Music getMusicById(Integer id);

    Music saveMusic(Music music);
}
