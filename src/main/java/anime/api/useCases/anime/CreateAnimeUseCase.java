package anime.api.useCases.anime;

import anime.api.domain.Anime;
import anime.api.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateAnimeUseCase {

    private AnimeRepository animeRepository;

    public Anime execute(Anime anime) {
        return this.animeRepository.save(anime);
    }
}
