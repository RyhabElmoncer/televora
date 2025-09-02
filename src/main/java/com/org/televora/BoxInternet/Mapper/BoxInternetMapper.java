package com.org.televora.BoxInternet.Mapper;

import com.org.televora.BoxInternet.DTO.BoxInternetDTO;
import com.org.televora.BoxInternet.Entity.BoxInternet;

public class BoxInternetMapper {

    public static BoxInternetDTO toDTO(BoxInternet entity) {
        if (entity == null) return null;

        BoxInternetDTO dto = new BoxInternetDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setDebit(entity.getDebit());
        dto.setPeriod(entity.getPeriod());
        dto.setIsVisible(entity.getIsVisible());
        dto.setIsWithoutEngagement(entity.getIsWithoutEngagement());
        dto.setLinkOfSite(entity.getLinkOfSite());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        dto.setImageUrl(entity.getImageUrl());
        dto.setOperator(entity.getOperator());
        dto.setTechnologies(entity.getTechnologies());
        dto.setBoxTypes(entity.getBoxTypes());

        return dto;
    }

    public static BoxInternet toEntity(BoxInternetDTO dto) {
        if (dto == null) return null;

        BoxInternet entity = new BoxInternet();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setDebit(dto.getDebit());
        entity.setPeriod(dto.getPeriod());
        entity.setIsVisible(dto.getIsVisible());
        entity.setIsWithoutEngagement(dto.getIsWithoutEngagement());
        entity.setLinkOfSite(dto.getLinkOfSite());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setImageUrl(dto.getImageUrl());
        entity.setOperator(dto.getOperator());
        entity.setTechnologies(dto.getTechnologies());
        entity.setBoxTypes(dto.getBoxTypes());

        return entity;
    }
}
