package com.org.televora.ForfaitMobile.dto;

import com.org.televora.BoxInternet.enums.Operator;
import com.org.televora.BoxInternet.enums.Technology;
import com.org.televora.ForfaitMobile.Enum.ForfaitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForfaitMobileDto {

    private Long id;
    private String title;
    private BigDecimal price;
    private Long priceSim;
    private String debit;
    private String period;
    private Long nbOfHours;
    private Boolean isVisible;
    private Boolean isWithoutEngagement;
    private String linkOfSite;
    private String description;
    private String content;
    private String imageUrl;
    private Boolean isPub;
    private Boolean isPubSideBar;
    private Boolean isBlockedForfait;
    private Boolean isCompatible5G;
    private String nbOfHoursForfait;
    private String debitForfait;
    private String imageSpot;
    private Operator operator;
    private Set<ForfaitType> types;
    private Set<Technology> technologies;
}
