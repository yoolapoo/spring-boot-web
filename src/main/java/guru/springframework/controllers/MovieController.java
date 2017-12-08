package guru.springframework.controllers;


import guru.springframework.domain.Media;
import guru.springframework.services.LoanService;
import guru.springframework.services.MediaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    private MediaService movieService;
    private LoanService loanService;

    public MovieController(MediaService mediaService, LoanService loanService) {
        super();
        this.movieService = mediaService;
        this.loanService = loanService;
    }

    /**
     * Get all movies of the library
     *
     * @return the movies
     */
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("movies", movieService.findAll("movie"));
        System.out.println("Returning movies:");
        return "movies";
    }

    /**
     * Get a movie from its id
     *
     * @param id the id of the wanter movie
     * @return a movie with the given id if there is one
     */
    @GetMapping(value = "movies/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Optional<Media> getMovie(@PathVariable("id") long id) {
        Optional<Media> response = this.movieService.findById(id);
        if (response.isPresent()) {
            return Optional.of(response.get());
        }
        return Optional.empty();
    }

    /**
     * Add a movie with the given ISBN
     *
     * @param isbn the ISBN
     * @return the id of the added movie if the isbn exists
     */
    @PostMapping(value = "movies/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String addMovie(@PathVariable long isbn, @RequestBody Media movie) {
        Optional<Media> movieExisted = this.movieService.findById(isbn);
        if (movieExisted.isPresent()) {
            return String.valueOf(movieExisted.get().getId_media());
        } else {
            return this.movieService.addMedia(isbn, movie);
        }
    }

    /**
     * Return all movies with an author, a title or an ISBN matching the search term
     *
     * @param searchTerm the searched term
     * @return the movies matching the search term
     */
    @GetMapping(value = "allmovies/{searchterm}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private List<Media> searchMovies(@PathVariable String searchTerm) {
        List<Media> responses = new ArrayList<>();
        movieService.search(searchTerm).stream().forEach(item -> {
            responses.add(item);
        });
        return responses;
    }


}
