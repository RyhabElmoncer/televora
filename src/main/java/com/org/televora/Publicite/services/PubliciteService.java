package com.org.televora.Publicite.services;

import com.org.televora.Publicite.dto.PubliciteDto;
import com.org.televora.Publicite.entity.Publicite;
import com.org.televora.Publicite.mapper.PubliciteMapper;
import com.org.televora.Publicite.repository.PubliciteRepository;
import com.org.televora.config.filestorage.FileStorageInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PubliciteService {

    private final PubliciteRepository repository;
    private final PubliciteMapper mapper;
    private final FileStorageInterface fileStorage;

    public PubliciteDto create(PubliciteDto dto, MultipartFile file) {
        String imagePath = null;
        if (file != null && !file.isEmpty()) {
            imagePath = fileStorage.saveFile(file);
            dto.setImageUrl(imagePath);
        }
        Publicite entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public Page<PubliciteDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    public PubliciteDto getById(UUID id) {
        Publicite entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publicité non trouvée avec id " + id));
        return mapper.toDto(entity);
    }

    public PubliciteDto update(UUID id, PubliciteDto dto, MultipartFile file) {
        Publicite entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publicité non trouvée avec id " + id));

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setOrdere(dto.getOrdere());

        if (file != null && !file.isEmpty()) {
            String imagePath = fileStorage.saveFile(file);
            entity.setImageUrl(imagePath);
        } else if (dto.getImageUrl() != null) {
            entity.setImageUrl(dto.getImageUrl());
        }

        return mapper.toDto(repository.save(entity));
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Publicité non trouvée avec id " + id);
        }
        repository.deleteById(id);
    }
}
