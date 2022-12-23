package anime.api.useCases.anime;

import anime.api.domain.Anime;
import anime.api.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAnimeUseCase {

    private AnimeRepository animeRepository;

    public List<Anime> execute() {
        return animeRepository.findAll();
    }
}
