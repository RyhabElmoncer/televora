package com.org.televora.BoxInternet.Services;

import com.org.televora.BoxInternet.DTO.BoxInternetDTO;
import com.org.televora.BoxInternet.Entity.BoxInternet;
import com.org.televora.BoxInternet.Mapper.BoxInternetMapper;
import com.org.televora.BoxInternet.Repository.BoxInternetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoxInternetService {

    private final BoxInternetRepository repository;

    public List<BoxInternetDTO> getAll() {
        return repository.findAll().stream()
                .map(BoxInternetMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BoxInternetDTO getById(Long id) {
        return repository.findById(id)
                .map(BoxInternetMapper::toDTO)
                .orElse(null);
    }

    public BoxInternetDTO create(BoxInternetDTO dto) {
        BoxInternet entity = BoxInternetMapper.toEntity(dto);
        return BoxInternetMapper.toDTO(repository.save(entity));
    }

    public BoxInternetDTO update(Long id, BoxInternetDTO dto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTitle(dto.getTitle());
                    existing.setPrice(dto.getPrice());
                    existing.setDebit(dto.getDebit());
                    existing.setPeriod(dto.getPeriod());
                    existing.setIsVisible(dto.getIsVisible());
                    existing.setIsWithoutEngagement(dto.getIsWithoutEngagement());
                    existing.setLinkOfSite(dto.getLinkOfSite());
                    existing.setDescription(dto.getDescription());
                    existing.setContent(dto.getContent());
                    existing.setImageUrl(dto.getImageUrl());
                    existing.setOperator(dto.getOperator());
                    existing.setTechnologies(dto.getTechnologies());
                    existing.setBoxTypes(dto.getBoxTypes());
                    return BoxInternetMapper.toDTO(repository.save(existing));
                }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
