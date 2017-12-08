package guru.springframework.bootstrap;

import guru.springframework.domain.Media;
import guru.springframework.services.MediaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MusicLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MediaService mediaService;

    private Logger log = Logger.getLogger(MusicLoader.class);

    public MusicLoader(MediaService mediaService) {
        super();
        this.mediaService = mediaService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        /*List<Media> movies = mediaService.findAll("movie");
        movies.stream().filter(movie ->
                movie.isAvailable() == false)
                .collect(Collectors.toList());*/
    }
}
