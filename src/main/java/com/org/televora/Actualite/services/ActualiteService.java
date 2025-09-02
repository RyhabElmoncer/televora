package com.org.televora.Actualite.services;

import com.org.televora.Actualite.Entity.Actualite;
import com.org.televora.Actualite.dto.ActualiteDto;
import com.org.televora.Actualite.mapper.ActualiteMapper;
import com.org.televora.Actualite.repository.ActualiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualiteService {

    private final ActualiteRepository actualiteRepository;
    private final ActualiteMapper mapper;

    public ActualiteDto createActualite(ActualiteDto dto) {
        Actualite actualite = mapper.toEntity(dto);
        return mapper.toDto(actualiteRepository.save(actualite));
    }

    public Page<ActualiteDto> getAllActualites(Pageable pageable) {
        return actualiteRepository.findAll(pageable).map(mapper::toDto);
    }

    public ActualiteDto getActualiteById(Long id) {
        Actualite actualite = actualiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actualité non trouvée avec id " + id));
        return mapper.toDto(actualite);
    }

    public ActualiteDto updateActualite(Long id, ActualiteDto dto) {
        Actualite existing = actualiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actualité non trouvée avec id " + id));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setContent(dto.getContent());
        existing.setDate(dto.getDate());
        existing.setImageUrl(dto.getImageUrl());
        existing.setIsVisible(dto.getIsVisible());

        return mapper.toDto(actualiteRepository.save(existing));
    }

    public void deleteActualite(Long id) {
        if (!actualiteRepository.existsById(id)) {
            throw new EntityNotFoundException("Actualité non trouvée avec id " + id);
        }
        actualiteRepository.deleteById(id);
    }
}
