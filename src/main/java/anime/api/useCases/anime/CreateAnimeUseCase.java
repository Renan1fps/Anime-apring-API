package anime.api.useCases.anime;

import anime.api.MockAnimes;
import anime.api.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateAnimeUseCase {

    public Anime execute(Anime anime){
        anime.setId(UUID.randomUUID().toString());
        MockAnimes.animes.add(anime);
        return  anime;
    }
}
