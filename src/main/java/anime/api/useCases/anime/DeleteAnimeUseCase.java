package anime.api.useCases.anime;

import anime.api.MockAnimes;
import anime.api.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteAnimeUseCase {

    public void execute(String id){
        Anime anime = MockAnimes.animes.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst().orElse(null);

        if(anime == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found");
        }

        MockAnimes.animes.remove(anime);
    }
}
