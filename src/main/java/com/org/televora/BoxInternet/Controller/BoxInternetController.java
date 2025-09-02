package com.org.televora.BoxInternet.Controller;

import com.org.televora.BoxInternet.DTO.BoxInternetDTO;
import com.org.televora.BoxInternet.Services.BoxInternetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/box-internet")
@RequiredArgsConstructor
public class BoxInternetController {

    private final BoxInternetService service;

    @GetMapping
    public List<BoxInternetDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BoxInternetDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public BoxInternetDTO create(@RequestBody BoxInternetDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public BoxInternetDTO update(@PathVariable Long id, @RequestBody BoxInternetDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
