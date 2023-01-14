package anime.api.controllers;

import anime.api.domain.Anime;
import anime.api.mocks.AnimeMocks;
import anime.api.useCases.anime.FindAnimeByIdUseCase;
import anime.api.useCases.anime.ListAnimeUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
class AnimeControllerTest {

    @InjectMocks // Classe que estou testando, vai injetar os mocks nela
    AnimeController animeController;
    @Mock // Classes que quero mockar
    ListAnimeUseCase listAnimeUseCaseMock;

    @Mock
    FindAnimeByIdUseCase findAnimeByIdUseCaseMock;

    @BeforeEach
    void setup(){
        List<Anime> animeList = new ArrayList<>(List.of(AnimeMocks.animeSaved()));
        Anime anime = AnimeMocks.animeSaved();

        BDDMockito.when(listAnimeUseCaseMock.execute()).thenReturn(animeList);
        BDDMockito.when(findAnimeByIdUseCaseMock.execute(ArgumentMatchers.anyString())).thenReturn(anime);
    }

    @Test
    @DisplayName("Should return a list animes when calls listAnimeUseCase")
    void Should_ReturnListAnime_WhenSuccessful() {
        String expectedName = AnimeMocks.animeSaved().getName();

        List<Anime> animeList = animeController.listAnime().getBody();

        Assertions.assertThat(animeList).isNotNull().hasSize(1);
        Assertions.assertThat(animeList.get(0).getName()).isEqualTo(expectedName);
        Assertions.assertThat(animeList.get(0).getName()).isNotNull();
    }

    @Test
    @DisplayName("Should return a anime anime when calls findAnimeByIdUseCase")
    void Should_ReturnAnime_WhenCallsFindById() {
        String expectedId = AnimeMocks.animeSaved().getId();
        Anime expectAnime = AnimeMocks.animeSaved();

        Anime anime = animeController.getById(expectedId).getBody();

        Assertions.assertThat(anime).isNotNull();
        Assertions.assertThat(anime).isEqualTo(expectAnime);
        Assertions.assertThat(anime).isInstanceOf(Anime.class);
    }
}