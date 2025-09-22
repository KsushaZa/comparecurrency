package com.nadershinaka.comparecurrency.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum GifType {

    RICH("h0MTqLyvgG0Ss", "Курс вырос"),
    NEUTRAL("SxpX5m1rJXjMY", "Курс не изменился"),
    POOR("m6j8sKMVwVcTJCg00X", "Курс упал");

    private final String gifId;
    private final String description;

    GifType(String gifId, String description) {
        this.gifId = gifId;
        this.description = description;
    }
}
