package com.academia.academiaproject.service;

import com.academia.academiaproject.controller.dto.request.AdministrativoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AdministrativoResponseDTO;
import com.academia.academiaproject.controller.exception.CargoException;
import com.academia.academiaproject.controller.exception.ResourceNotFoundException;
import com.academia.academiaproject.repository.AdministrativoRepository;
import com.academia.academiaproject.repository.model.Administrativo;
import com.academia.academiaproject.service.mapper.AdministrativoMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdministrativoService {
    private final AdministrativoRepository administrativoRepository;
    private final AdministrativoMapper administrativoMapper;


    public AdministrativoResponseDTO createAdministrativo(AdministrativoRequestDTO request) {
        if(request.cargo()==null || request.cargo().isEmpty()){
            throw new CargoException("El cargo no puede estar vacio");
        }
        if(request.email()==null || request.email().isEmpty()){
            throw new CargoException("El correo no puede estar vacio");
        }
        Administrativo administrativo = new Administrativo();
        administrativo.setNombre(request.nombre());
        administrativo.setApellido(request.apellido());
        administrativo.setTelefono(request.telefono());
        administrativo.setCargo(request.cargo());
        administrativo.setEmail(request.email());
        administrativo = administrativoRepository.save(administrativo);
        return new AdministrativoResponseDTO(administrativo.getId(), administrativo.getNombre(), administrativo.getApellido(), administrativo.getTelefono(), administrativo.getCargo(), administrativo.getEmail());
    }

    public List<AdministrativoResponseDTO> obtenerTodos() {
        return administrativoRepository.findAll()
                .stream()
                .map(administrativoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AdministrativoResponseDTO obtenerPorId(Long id) {
        Administrativo administrativo = administrativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrativo con ID " + id + " no encontrado."));
        return administrativoMapper.toDTO(administrativo);
    }

//    @Transactional
//    public AdministrativoResponseDTO crear(AdministrativoRequestDTO dto) {
//        Administrativo administrativo = administrativoMapper.toEntity(dto);
//        return administrativoMapper.toDTO(administrativoRepository.save(administrativo));
//    }

    @Transactional
    public AdministrativoResponseDTO actualizar(Long id, AdministrativoRequestDTO dto) {
        Administrativo administrativo = administrativoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrativo con ID " + id + " no encontrado."));

        administrativo.setNombre(dto.nombre());
        administrativo.setApellido(dto.apellido());
        administrativo.setTelefono(dto.telefono());
        administrativo.setEmail(dto.email());
        administrativo.setCargo(dto.cargo());

        return administrativoMapper.toDTO(administrativoRepository.save(administrativo));
    }

    @Transactional
    public void eliminar(Long id) {
        if (!administrativoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Administrativo con ID " + id + " no encontrado.");
        }
        administrativoRepository.deleteById(id);
    }
}
