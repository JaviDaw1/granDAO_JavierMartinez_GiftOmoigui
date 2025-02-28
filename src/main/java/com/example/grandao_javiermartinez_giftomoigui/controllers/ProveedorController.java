package com.example.grandao_javiermartinez_giftomoigui.controllers;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import com.example.grandao_javiermartinez_giftomoigui.services.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // Obtener todos (BD o Archivo)
    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerTodos(@RequestParam(required = false) String fuente) {
        boolean desdeArchivo = "archivo".equalsIgnoreCase(fuente);
        return ResponseEntity.ok(proveedorService.findAll(desdeArchivo));
    }

    // Obtener por ID (solo BD)
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(proveedorService.findById(id));
    }

    // Guardar (BD o Archivo)
    @PostMapping
    public ResponseEntity<Proveedor> guardar(@RequestBody Proveedor proveedor, @RequestParam(required = false) String fuente) {
        boolean enArchivo = "archivo".equalsIgnoreCase(fuente);
        return ResponseEntity.ok(proveedorService.save(proveedor, enArchivo));
    }

    // Actualizar (solo BD)
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.update(id, proveedor));
    }

    // Eliminar (solo BD)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proveedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
