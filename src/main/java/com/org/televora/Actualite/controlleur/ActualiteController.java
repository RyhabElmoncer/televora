package com.org.televora.Actualite.controlleur;

import com.org.televora.Actualite.dto.ActualiteDto;
import com.org.televora.Actualite.services.ActualiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actualites")
@RequiredArgsConstructor
public class ActualiteController {

    private final ActualiteService actualiteService;

    @PostMapping
    public ResponseEntity<ActualiteDto> create(@RequestBody ActualiteDto dto) {
        return ResponseEntity.ok(actualiteService.createActualite(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ActualiteDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(actualiteService.getAllActualites(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActualiteDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(actualiteService.getActualiteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActualiteDto> update(@PathVariable Long id, @RequestBody ActualiteDto dto) {
        return ResponseEntity.ok(actualiteService.updateActualite(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actualiteService.deleteActualite(id);
        return ResponseEntity.noContent().build();
    }
}
