package anime.api.mocks;

import anime.api.domain.Anime;

import java.util.UUID;

public class AnimeMocks {

    public static String id = UUID.randomUUID().toString();

    public static Anime animeToBeSave() {
        return Anime.builder()
                .name("Naruto")
                .build();
    }

    public static Anime animeSaved() {
        return Anime.builder()
                .name("Naruto")
                .id(id)
                .build();
    }
}
