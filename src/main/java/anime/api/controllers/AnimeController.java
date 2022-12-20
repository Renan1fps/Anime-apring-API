package anime.api.controllers;

import anime.api.domain.Anime;
import anime.api.useCases.anime.ListAnimeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("animes")
@AllArgsConstructor
public class AnimeController {

    private final ListAnimeUseCase listAnimeUseCase;

    @GetMapping
    public List<Anime> listAnime(){
        return this.listAnimeUseCase.execute();
    }
}
