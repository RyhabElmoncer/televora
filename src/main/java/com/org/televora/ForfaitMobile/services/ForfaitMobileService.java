package com.org.televora.ForfaitMobile.services;

import com.org.televora.ForfaitMobile.Entity.ForfaitMobile;
import com.org.televora.ForfaitMobile.dto.ForfaitMobileDto;
import com.org.televora.ForfaitMobile.mapper.ForfaitMobileMapper;
import com.org.televora.ForfaitMobile.repository.ForfaitMobileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForfaitMobileService {

    private final ForfaitMobileRepository repository;
    private final ForfaitMobileMapper mapper;

    public ForfaitMobileService(ForfaitMobileRepository repository, ForfaitMobileMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ForfaitMobileDto create(ForfaitMobileDto dto) {
        ForfaitMobile entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public ForfaitMobileDto update(Long id, ForfaitMobileDto dto) {
        ForfaitMobile existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ForfaitMobile not found"));
        ForfaitMobile updated = mapper.toEntity(dto);
        updated.setId(existing.getId());
        return mapper.toDto(repository.save(updated));
    }

    public ForfaitMobileDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("ForfaitMobile not found"));
    }

    public List<ForfaitMobileDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
