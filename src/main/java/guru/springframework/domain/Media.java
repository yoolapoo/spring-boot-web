package guru.springframework.domain;

import lombok.Data;


@Data
public class Media {
    private String id_media;
    private String type_media;
    private String author;
    private String title;
    private String creation;
    private String genre;
    private boolean isAvailable;
}
