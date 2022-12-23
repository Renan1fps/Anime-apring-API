package anime.api.useCases.anime;

import anime.api.domain.Anime;
import anime.api.exception.BadRequestException;
import anime.api.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAnimeByIdUseCase {

    private AnimeRepository animeRepository;

    public Anime execute(String id) {
        Anime existsAnime = this.animeRepository.findById(id).orElse(null);

        if (existsAnime == null) {
            throw new BadRequestException("Anime not found");
        }
        return existsAnime;
    }
}
