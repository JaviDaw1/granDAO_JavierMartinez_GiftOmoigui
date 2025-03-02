/*
package com.example.grandao_javiermartinez_giftomoigui.controllers;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Cliente;
import com.example.grandao_javiermartinez_giftomoigui.services.ClienteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteServiceImpl clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        try {
            List<Cliente> clientes = clienteService.findAll();
            return ResponseEntity.ok(clientes);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        try {
            Cliente empleado = clienteService.findById(id);
            return ResponseEntity.ok(empleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente empleado) {
        try {
            Cliente savedCliente = clienteService.save(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @Valid @RequestBody Cliente empleado) {
        try {
            Cliente updatedCliente = clienteService.update(id, empleado);
            return ResponseEntity.ok(updatedCliente);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
        try {
            clienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
*/
