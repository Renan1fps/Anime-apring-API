package anime.api.useCases.anime;

import anime.api.MockAnimes;
import anime.api.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAnimeUseCase {

    public List<Anime> execute() {
        return MockAnimes.animes;
    }
}
