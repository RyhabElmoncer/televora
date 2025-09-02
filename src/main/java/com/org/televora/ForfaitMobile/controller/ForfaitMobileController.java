package com.org.televora.ForfaitMobile.controller;

import com.org.televora.ForfaitMobile.dto.ForfaitMobileDto;
import com.org.televora.ForfaitMobile.services.ForfaitMobileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ForfaitMobileDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
