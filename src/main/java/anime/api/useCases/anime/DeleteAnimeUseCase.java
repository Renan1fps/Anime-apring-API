package anime.api.useCases.anime;

import anime.api.MockAnimes;
import anime.api.domain.Anime;
import anime.api.exception.BadRequestException;
import anime.api.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class DeleteAnimeUseCase {

    private AnimeRepository animeRepository;

    public void execute(String id){
        Anime existsAnime = this.animeRepository.findById(id).orElse(null);

        if(existsAnime == null){
            throw new BadRequestException("Anime not found");
        }

        this.animeRepository.deleteById(id);
    }
}
