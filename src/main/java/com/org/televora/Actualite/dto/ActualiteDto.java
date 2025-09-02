package com.org.televora.Actualite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualiteDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Instant date;
    private String imageUrl;
    private Boolean isVisible;
}
