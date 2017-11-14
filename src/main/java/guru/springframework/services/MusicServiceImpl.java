package guru.springframework.services;

import guru.springframework.domain.Music;
import guru.springframework.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService {
    private MusicRepository musicRepository;

    @Autowired
    public void setProductRepository(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Iterable<Music> listAllMusics() {
        return musicRepository.findAll();
    }

    @Override
    public Music getMusicById(Integer id) { return musicRepository.findOne(id); }

    @Override
    public Music saveMusic(Music music) {
        return musicRepository.save(music);
    }
}
