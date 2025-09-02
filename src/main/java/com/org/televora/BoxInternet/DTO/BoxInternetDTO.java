package com.org.televora.BoxInternet.DTO;

import com.org.televora.BoxInternet.enums.BoxType;
import com.org.televora.BoxInternet.enums.Operator;
import com.org.televora.BoxInternet.enums.Technology;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class BoxInternetDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private String debit;
    private String period;
    private Boolean isVisible;
    private Boolean isWithoutEngagement;
    private String linkOfSite;
    private String description;
    private String content;
    private String imageUrl;
    private Operator operator;
    private Set<Technology> technologies;
    private Set<BoxType> boxTypes;
}
