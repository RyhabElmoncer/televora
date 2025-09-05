package com.org.televora.ForfaitMobile.controller;

import com.org.televora.ForfaitMobile.dto.ForfaitMobileDto;
import com.org.televora.ForfaitMobile.services.ForfaitMobileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forfait-mobile")
public class ForfaitMobileController {

    private final ForfaitMobileService service;

    public ForfaitMobileController(ForfaitMobileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ForfaitMobileDto> create(@RequestBody ForfaitMobileDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForfaitMobileDto> update(@PathVariable Long id, @RequestBody ForfaitMobileDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
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
