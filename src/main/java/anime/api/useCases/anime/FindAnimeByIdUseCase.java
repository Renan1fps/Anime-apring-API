package anime.api.useCases.anime;

import anime.api.MockAnimes;
import anime.api.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FindAnimeByIdUseCase {

    public Anime execute(String id){
        return MockAnimes.animes
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

}
