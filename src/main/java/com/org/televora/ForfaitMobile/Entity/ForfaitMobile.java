package com.org.televora.ForfaitMobile.Entity;

import com.org.televora.BoxInternet.enums.Operator;
import com.org.televora.BoxInternet.enums.Technology;
import com.org.televora.ForfaitMobile.Enum.ForfaitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "forfait_mobile")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ForfaitMobile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
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

    @Enumerated(EnumType.STRING)
    private Operator operator;

    @ElementCollection(targetClass = ForfaitType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "forfait_mobile_type", joinColumns = @JoinColumn(name = "forfait_mobile_id"))
    @Column(name = "forfait_type")
    private Set<ForfaitType> types;

    @ElementCollection(targetClass = Technology.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "forfait_mobile_technology", joinColumns = @JoinColumn(name = "forfait_mobile_id"))
    @Column(name = "technology")
    private Set<Technology> technologies;
}
