/*
package com.example.grandao_javiermartinez_giftomoigui.controllers;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Empleado;
import com.example.grandao_javiermartinez_giftomoigui.services.EmpleadoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoServiceImpl empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> findAll() {
        try {
            List<Empleado> empleados = empleadoService.findAll();
            return ResponseEntity.ok(empleados);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> findById(@PathVariable String id) {
        try {
            Empleado empleado = empleadoService.findById(id);
            return ResponseEntity.ok(empleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empleado> create(@Valid @RequestBody Empleado empleado) {
        try {
            Empleado savedEmpleado = empleadoService.save(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable String id, @Valid @RequestBody Empleado empleado) {
        try {
            Empleado updatedEmpleado = empleadoService.update(id, empleado);
            return ResponseEntity.ok(updatedEmpleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empleado> delete(@PathVariable String id) {
        try {
            empleadoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
*/
