package com.org.televora.Publicite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PubliciteDto {
    private UUID id;
    private String title;
    private String imageUrl;
    private String description;
    private int ordere;
}
