package com.org.televora.ForfaitMobile.mapper;


import com.org.televora.ForfaitMobile.Entity.ForfaitMobile;
import com.org.televora.ForfaitMobile.dto.ForfaitMobileDto;
import org.springframework.stereotype.Component;

@Component
public class ForfaitMobileMapper {

    public ForfaitMobileDto toDto(ForfaitMobile entity) {
        if (entity == null) return null;

        ForfaitMobileDto dto = new ForfaitMobileDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setPriceSim(entity.getPriceSim());
        dto.setDebit(entity.getDebit());
        dto.setPeriod(entity.getPeriod());
        dto.setNbOfHours(entity.getNbOfHours());
        dto.setIsVisible(entity.getIsVisible());
        dto.setIsWithoutEngagement(entity.getIsWithoutEngagement());
        dto.setLinkOfSite(entity.getLinkOfSite());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        dto.setImageUrl(entity.getImageUrl());
        dto.setIsPub(entity.getIsPub());
        dto.setIsPubSideBar(entity.getIsPubSideBar());
        dto.setIsBlockedForfait(entity.getIsBlockedForfait());
        dto.setIsCompatible5G(entity.getIsCompatible5G());
        dto.setNbOfHoursForfait(entity.getNbOfHoursForfait());
        dto.setDebitForfait(entity.getDebitForfait());
        dto.setImageSpot(entity.getImageSpot());
        dto.setOperator(entity.getOperator());
        dto.setTypes(entity.getTypes());
        dto.setTechnologies(entity.getTechnologies());

        return dto;
    }

    public ForfaitMobile toEntity(ForfaitMobileDto dto) {
        if (dto == null) return null;

        ForfaitMobile entity = new ForfaitMobile();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setPriceSim(dto.getPriceSim());
        entity.setDebit(dto.getDebit());
        entity.setPeriod(dto.getPeriod());
        entity.setNbOfHours(dto.getNbOfHours());
        entity.setIsVisible(dto.getIsVisible());
        entity.setIsWithoutEngagement(dto.getIsWithoutEngagement());
        entity.setLinkOfSite(dto.getLinkOfSite());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setImageUrl(dto.getImageUrl());
        entity.setIsPub(dto.getIsPub());
        entity.setIsPubSideBar(dto.getIsPubSideBar());
        entity.setIsBlockedForfait(dto.getIsBlockedForfait());
        entity.setIsCompatible5G(dto.getIsCompatible5G());
        entity.setNbOfHoursForfait(dto.getNbOfHoursForfait());
        entity.setDebitForfait(dto.getDebitForfait());
        entity.setImageSpot(dto.getImageSpot());
        entity.setOperator(dto.getOperator());
        entity.setTypes(dto.getTypes());
        entity.setTechnologies(dto.getTechnologies());

        return entity;
    }
}
