package com.org.televora.Publicite.mapper;

import com.org.televora.Publicite.dto.PubliciteDto;
import com.org.televora.Publicite.entity.Publicite;
import org.springframework.stereotype.Component;

@Component
public class PubliciteMapper {

    public PubliciteDto toDto(Publicite entity) {
        if (entity == null) return null;
        return new PubliciteDto(
                entity.getId(),
                entity.getTitle(),
                entity.getImageUrl(),
                entity.getDescription(),
                entity.getOrdere()
        );
    }

    public Publicite toEntity(PubliciteDto dto) {
        if (dto == null) return null;
        Publicite publicite = new Publicite();
        publicite.setId(dto.getId());
        publicite.setTitle(dto.getTitle());
        publicite.setImageUrl(dto.getImageUrl());
        publicite.setDescription(dto.getDescription());
        publicite.setOrdere(dto.getOrdere());
        return publicite;
    }
}
