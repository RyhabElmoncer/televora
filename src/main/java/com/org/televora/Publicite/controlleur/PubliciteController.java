package com.org.televora.Publicite.controlleur;

import com.org.televora.Publicite.dto.PubliciteDto;
import com.org.televora.Publicite.services.PubliciteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/publicites")
@RequiredArgsConstructor
public class PubliciteController {

    private final PubliciteService service;

    @PostMapping
    public ResponseEntity<PubliciteDto> create(
            @RequestPart("dto") PubliciteDto dto,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        return ResponseEntity.ok(service.create(dto, file));
    }

    @GetMapping
    public ResponseEntity<Page<PubliciteDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PubliciteDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PubliciteDto> update(
            @PathVariable UUID id,
            @RequestPart("dto") PubliciteDto dto,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        return ResponseEntity.ok(service.update(id, dto, file));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
