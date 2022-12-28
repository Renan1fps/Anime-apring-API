package anime.api.controllers;

import anime.api.domain.Anime;
import anime.api.useCases.anime.CreateAnimeUseCase;
import anime.api.useCases.anime.DeleteAnimeUseCase;
import anime.api.useCases.anime.FindAnimeByIdUseCase;
import anime.api.useCases.anime.ListAnimeUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("animes")
@AllArgsConstructor
@Log4j2()
public class AnimeController {

    private final ListAnimeUseCase listAnimeUseCase;
    private final FindAnimeByIdUseCase findAnimeByIdUseCase;
    private final CreateAnimeUseCase createAnimeUseCase;
    private final DeleteAnimeUseCase deleteAnimeUseCase;

    @GetMapping
    public ResponseEntity<List<Anime>> listAnime() {
        return new ResponseEntity<>(this.listAnimeUseCase.execute(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> getById(@PathVariable String id) {
        return new ResponseEntity<>(this.findAnimeByIdUseCase.execute(id), HttpStatus.OK);
    }

    @Transactional(rollbackFor = Exception.class) // rollback para todos os tipos de erros
    @PostMapping()
    public ResponseEntity<Anime> createAnime(@RequestBody  @Valid Anime anime) {
        return new ResponseEntity<>(this.createAnimeUseCase.execute(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable String id) {
        this.deleteAnimeUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
