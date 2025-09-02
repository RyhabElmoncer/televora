package com.org.televora.BoxInternet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operator {
    ORANGE("Orange", "/images/operators/orange.png"),
    FREE("Free", "/images/operators/free.png"),
    SFR("SFR", "/images/operators/sfr.png"),
    BOUYGUES("Bouygues", "/images/operators/bouygues.png");

    private final String label;
    private final String image;
}
