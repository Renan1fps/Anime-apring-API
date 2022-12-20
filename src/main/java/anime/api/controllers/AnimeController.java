package anime.api.controllers;

import anime.api.domain.Anime;
import anime.api.useCases.anime.CreateAnimeUseCase;
import anime.api.useCases.anime.FindAnimeByIdUseCase;
import anime.api.useCases.anime.ListAnimeUseCase;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("animes")
@AllArgsConstructor
public class AnimeController {

    private final ListAnimeUseCase listAnimeUseCase;
    private final FindAnimeByIdUseCase findAnimeByIdUseCase;
    private final CreateAnimeUseCase createAnimeUseCase;

    @GetMapping
    public ResponseEntity<List<Anime>> listAnime(){
        return new ResponseEntity<>(this.listAnimeUseCase.execute(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> getById(@PathVariable String id){
        return new ResponseEntity<>(this.findAnimeByIdUseCase.execute(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Anime> createAnime(@RequestBody Anime anime){
        return new ResponseEntity<>(this.createAnimeUseCase.execute(anime), HttpStatus.CREATED);
    }
}
