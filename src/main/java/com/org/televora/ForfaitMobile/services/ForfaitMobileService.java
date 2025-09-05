package com.org.televora.ForfaitMobile.services;

import com.org.televora.ForfaitMobile.Entity.ForfaitMobile;
import com.org.televora.ForfaitMobile.dto.ForfaitMobileDto;
import com.org.televora.ForfaitMobile.mapper.ForfaitMobileMapper;
import com.org.televora.ForfaitMobile.repository.ForfaitMobileRepository;
import com.org.televora.config.filestorage.FileStorageInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ForfaitMobileService {

    private final ForfaitMobileRepository repository;
    private final ForfaitMobileMapper mapper;
    private final FileStorageInterface fileStorage;

    public ForfaitMobileService(ForfaitMobileRepository repository,
                                ForfaitMobileMapper mapper,
                                FileStorageInterface fileStorage) {
        this.repository = repository;
        this.mapper = mapper;
        this.fileStorage = fileStorage;
    }

    // Création avec fichier
    public ForfaitMobileDto create(ForfaitMobileDto dto, MultipartFile file) {
        ForfaitMobile entity = mapper.toEntity(dto);

        if (file != null && !file.isEmpty()) {
            String storedFilePath = fileStorage.saveFile(file);
            entity.setImageUrl(storedFilePath); // utiliser imageUrl
        }

        return mapper.toDto(repository.save(entity));
    }

    public ForfaitMobileDto update(Long id, ForfaitMobileDto dto, MultipartFile file) {
        ForfaitMobile existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ForfaitMobile not found"));

        ForfaitMobile updated = mapper.toEntity(dto);
        updated.setId(existing.getId());

        if (file != null && !file.isEmpty()) {
            String storedFilePath = fileStorage.saveFile(file);
            updated.setImageUrl(storedFilePath); // mettre à jour imageUrl
        } else {
            updated.setImageUrl(existing.getImageUrl()); // conserver l’ancienne image
        }

        return mapper.toDto(repository.save(updated));
    }

    public ForfaitMobileDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("ForfaitMobile not found"));
    }

    public Page<ForfaitMobileDto> getAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
