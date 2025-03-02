/*
package com.example.grandao_javiermartinez_giftomoigui.controllers;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Producto;
import com.example.grandao_javiermartinez_giftomoigui.services.ProductoServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoServiceImpl productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable int id) {
        Producto producto = productoService.findById(id);
        return (producto != null) ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable int id, @RequestBody Producto updatedProducto) {
        Producto producto = productoService.update(id, updatedProducto);
        return (producto != null) ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }
}
*/
