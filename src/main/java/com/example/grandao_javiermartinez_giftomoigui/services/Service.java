package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.dao.ProveedorFicherosDAO;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Cliente;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Empleado;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Producto;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import com.example.grandao_javiermartinez_giftomoigui.repositories.ClienteRepositoryJPA;
import com.example.grandao_javiermartinez_giftomoigui.repositories.EmpleadoRepositoryMongo;
import com.example.grandao_javiermartinez_giftomoigui.repositories.ProductoRepository;
import com.example.grandao_javiermartinez_giftomoigui.repositories.ProveedorRepositoryFicheros;
import lombok.AllArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    private final ClienteRepositoryJPA clienteRepository;
    private final EmpleadoRepositoryMongo empleadoRepository;
    private final ProductoRepository productoRepository;
    private final ProveedorRepositoryFicheros proveedorRepository;
    private final ProveedorFicherosDAO proveedorFicherosDAO;

    // Clientes
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente updateClientes(Integer id, Cliente cliente) {
        Cliente updated= clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con id: " + id));
        updated.setNombre(cliente.getNombre());
        updated.setCorreo(cliente.getCorreo());
        updated.setTelefono(cliente.getTelefono());
        return clienteRepository.save(updated);
    }

    public Cliente saveClientes(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteClientes(Integer id) {
        clienteRepository.deleteById(id);
    }


    // Empleados
    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado findByEmpleadoId(String id) {
        return empleadoRepository.findById(id).get();
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado updateEmpleado(String id, Empleado empleado) {
        Empleado updated= empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el empleado con id: " + id));
        updated.setNombre(empleado.getNombre());
        updated.setPuesto(empleado.getPuesto());
        updated.setSalario(empleado.getSalario());
        return empleadoRepository.save(updated);
    }

    public void deleteEmpleado(String id) {
        empleadoRepository.deleteById(id);
    }


    // Productos
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    public Producto findByProductoId(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteByProductoId(Integer id) {
        productoRepository.delete(id);
    }

    public Producto updateProducto(int id, Producto updatedProducto) {
        return productoRepository.update(id, updatedProducto);
    }


    // Proveedor
    public List<Proveedor> findAllProveedores() {
        List<Proveedor> proveedores = proveedorRepository.findAll();  // Obtener todos los proveedores desde la base de datos
        actualizarArchivo(proveedores);  // Sincronizar el archivo con la base de datos
        return proveedores;
    }

    public void saveProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);  // Guardar en la base de datos
        proveedorFicherosDAO.guardar(proveedor);  // Guardar en el archivo
    }

    public void deleteByProveedorId(Integer id) {
        proveedorRepository.deleteById(id);  // Eliminar de la base de datos
        proveedorFicherosDAO.eliminar(id);  // Eliminar del archivo
    }

    public void updateByProveedorId(Integer id, Proveedor proveedor) {
        if (proveedorRepository.existsById(id)) {
            proveedor.setId(id);
            proveedorRepository.save(proveedor);  // Actualizar en la base de datos
            proveedorFicherosDAO.actualizar(id, proveedor);  // Actualizar en el archivo
        }
    }

    // Método para sincronizar la base de datos con el archivo
    private void actualizarArchivo(List<Proveedor> proveedores) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/data/proveedores.txt", false))) {
            for (Proveedor proveedor : proveedores) {
                // Escribir el ID al principio, seguido por el nombre, dirección y teléfono
                bw.write(proveedor.getId() + "," + proveedor.getNombre() + ";" + proveedor.getDireccion() + ";" + proveedor.getTelefono());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
