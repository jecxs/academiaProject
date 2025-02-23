package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.DocenteDTO;
import com.academia.academiaproject.service.DocenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocenteController {

    private final DocenteService docenteService;

    @GetMapping
    public List<DocenteDTO> listar() {
        return docenteService.listar();
    }

    @PostMapping
    public DocenteDTO guardar(@Valid @RequestBody DocenteDTO dto) {
        return docenteService.guardar(dto);
    }

    @GetMapping("/{id}")
    public DocenteDTO buscarPorId(@PathVariable Long id) {
        return docenteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        docenteService.eliminar(id);
    }
}