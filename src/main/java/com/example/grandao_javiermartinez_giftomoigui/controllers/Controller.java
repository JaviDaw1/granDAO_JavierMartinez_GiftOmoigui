package com.example.grandao_javiermartinez_giftomoigui.controllers;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Cliente;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Empleado;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Producto;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import com.example.grandao_javiermartinez_giftomoigui.services.Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grandao")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class Controller {
    private final Service service;


    // Clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> findAllClientes() {
        try {
            List<Cliente> clientes = service.findAllClientes();
            return ResponseEntity.ok(clientes);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> findByClienteId(@PathVariable Integer id) {
        try {
            Cliente empleado = service.findClienteById(id);
            return ResponseEntity.ok(empleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/postCliente")
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente empleado) {
        try {
            Cliente savedCliente = service.saveClientes(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @Valid @RequestBody Cliente empleado) {
        try {
            Cliente updatedCliente = service.updateClientes(id, empleado);
            return ResponseEntity.ok(updatedCliente);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Integer id) {
        try {
            service.deleteClientes(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    // Empleados
    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> findAllEmpleados() {
        try {
            List<Empleado> empleados = service.findAllEmpleados();
            return ResponseEntity.ok(empleados);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> findByEmpleadoId(@PathVariable String id) {
        try {
            Empleado empleado = service.findByEmpleadoId(id);
            return ResponseEntity.ok(empleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/postEmpleado")
    public ResponseEntity<Empleado> createEmpleado(@Valid @RequestBody Empleado empleado) {
        try {
            Empleado savedEmpleado = service.saveEmpleado(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable String id, @Valid @RequestBody Empleado empleado) {
        try {
            Empleado updatedEmpleado = service.updateEmpleado(id, empleado);
            return ResponseEntity.ok(updatedEmpleado);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable String id) {
        try {
            service.deleteEmpleado(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    // Productos
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> findAllProductos() {
        return ResponseEntity.ok(service.findAllProductos());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> findByProductoId(@PathVariable int id) {
        Producto producto = service.findByProductoId(id);
        return (producto != null) ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/postProducto")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(service.saveProducto(producto));
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        service.deleteByProductoId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto updatedProducto) {
        Producto producto = service.updateProducto(id, updatedProducto);
        return (producto != null) ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }


    // Proveedor
    @GetMapping("/proveedores")
    public ResponseEntity<List<Proveedor>> findAllProveedores() {
        return ResponseEntity.ok(service.findAllProveedores());
    }

    @PostMapping("/postProveedor")
    public ResponseEntity<Proveedor> saveProveedores(@RequestBody Proveedor proveedor) {
        service.saveProveedor(proveedor);  // Guardamos el proveedor
        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Void> deleteProveedores(@PathVariable Integer id) {
        service.deleteByProveedorId(id);  // Borramos el proveedor por su ID
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> updateProveedores(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        service.updateByProveedorId(id, proveedor);  // Actualizamos el proveedor por su ID
        return ResponseEntity.ok(proveedor);
    }
}
