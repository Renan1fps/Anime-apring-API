package anime.api.controllers;

import anime.api.domain.Anime;
import anime.api.useCases.anime.FindAnimeByIdUseCase;
import anime.api.useCases.anime.ListAnimeUseCase;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("animes")
@AllArgsConstructor
public class AnimeController {

    private final ListAnimeUseCase listAnimeUseCase;
    private final FindAnimeByIdUseCase findAnimeByIdUseCase;

    @GetMapping
    public ResponseEntity<List<Anime>> listAnime(){
        return new ResponseEntity<>(this.listAnimeUseCase.execute(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> getById(@PathVariable String id){
        return new ResponseEntity<>(this.findAnimeByIdUseCase.execute(id), HttpStatus.OK);
    }
}
