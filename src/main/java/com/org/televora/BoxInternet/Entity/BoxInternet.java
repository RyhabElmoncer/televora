package com.org.televora.BoxInternet.Entity;

import com.org.televora.BoxInternet.enums.BoxType;
import com.org.televora.BoxInternet.enums.Operator;
import com.org.televora.BoxInternet.enums.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "box_internet")
public class BoxInternet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
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

    @Enumerated(EnumType.STRING)
    private Operator operator;

    @ElementCollection(targetClass = Technology.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "box_internet_technology", joinColumns = @JoinColumn(name = "box_internet_id"))
    @Column(name = "technology")
    private Set<Technology> technologies;

    @ElementCollection(targetClass = BoxType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "box_internet_type", joinColumns = @JoinColumn(name = "box_internet_id"))
    @Column(name = "box_type")
    private Set<BoxType> boxTypes;
}
