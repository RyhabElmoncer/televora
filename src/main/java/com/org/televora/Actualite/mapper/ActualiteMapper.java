package com.org.televora.Actualite.mapper;

import com.org.televora.Actualite.Entity.Actualite;
import com.org.televora.Actualite.dto.ActualiteDto;
import org.springframework.stereotype.Component;

@Component
public class ActualiteMapper {

    public ActualiteDto toDto(Actualite actualite) {
        if (actualite == null) {
            return null;
        }
        return new ActualiteDto(
                actualite.getId(),
                actualite.getTitle(),
                actualite.getDescription(),
                actualite.getContent(),
                actualite.getDate(),
                actualite.getImageUrl(),
                actualite.getIsVisible()
        );
    }

    public Actualite toEntity(ActualiteDto dto) {
        if (dto == null) {
            return null;
        }
        Actualite actualite = new Actualite();
        actualite.setId(dto.getId());
        actualite.setTitle(dto.getTitle());
        actualite.setDescription(dto.getDescription());
        actualite.setContent(dto.getContent());
        actualite.setDate(dto.getDate());
        actualite.setImageUrl(dto.getImageUrl());
        actualite.setIsVisible(dto.getIsVisible());
        return actualite;
    }
}
