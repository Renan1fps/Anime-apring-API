package anime.api.useCases.anime;

import anime.api.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListAnimeUseCase {

    public List<Anime> execute() {
        return List.of(
                new Anime(UUID.randomUUID().toString(), "Naruto"),
                new Anime(UUID.randomUUID().toString(), "Jujutsu")
        );
    }
}
