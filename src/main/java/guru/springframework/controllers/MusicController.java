package guru.springframework.controllers;

import guru.springframework.domain.Music;
import guru.springframework.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MusicController {

    private MusicService musicService;

    @Autowired
    public void setProductService(MusicService musicService) {
        this.musicService = musicService;
    }

    @RequestMapping(value = "/musics", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("musics", musicService.listAllMusics());
        System.out.println("Returning musics:");
        return "musics";
    }

    @RequestMapping("music/{id}")
    public String showMusic(@PathVariable Integer id, Model model){
        model.addAttribute("music", musicService.getMusicById(id));
        return "musicshow";
    }

    @RequestMapping("music/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("music", musicService.getMusicById(id));
        return "musicform";
    }

    @RequestMapping("music/new")
    public String newProduct(Model model){
        model.addAttribute("music", new Music());
        return "musicform";
    }

    @RequestMapping(value = "music", method = RequestMethod.POST)
    public String saveMusic(Music music){

        musicService.saveMusic(music);

        return "redirect:/music/" + music.getId();
    }

}
