package com.org.televora.ForfaitMobile.controller;

import com.org.televora.ForfaitMobile.dto.ForfaitMobileDto;
import com.org.televora.ForfaitMobile.services.ForfaitMobileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/forfait-mobile")
public class ForfaitMobileController {

    private final ForfaitMobileService service;

    public ForfaitMobileController(ForfaitMobileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ForfaitMobileDto> create(
            @RequestPart("data") ForfaitMobileDto dto,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        return ResponseEntity.ok(service.create(dto, file));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForfaitMobileDto> update(
            @PathVariable Long id,
            @RequestPart("data") ForfaitMobileDto dto,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        return ResponseEntity.ok(service.update(id, dto, file));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ForfaitMobileDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // Pagination
    @GetMapping
    public ResponseEntity<Page<ForfaitMobileDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ForfaitMobileDto> result = service.getAll(pageable);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
