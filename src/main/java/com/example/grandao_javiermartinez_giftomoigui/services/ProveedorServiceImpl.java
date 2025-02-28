package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.dao.ProveedorFicherosDAO;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import com.example.grandao_javiermartinez_giftomoigui.repositories.ProveedorRepositoryFicheros;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepositoryFicheros proveedorRepository;
    private final ProveedorFicherosDAO proveedorFicherosDAO;

    public ProveedorServiceImpl(ProveedorRepositoryFicheros proveedorRepository, ProveedorFicherosDAO proveedorFicherosDAO) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorFicherosDAO = proveedorFicherosDAO;
    }

    @Override
    public List<Proveedor> findAll() {
        List<Proveedor> proveedores = proveedorRepository.findAll();  // Obtener todos los proveedores desde la base de datos
        actualizarArchivo(proveedores);  // Sincronizar el archivo con la base de datos
        return proveedores;
    }

    @Override
    public void save(Proveedor proveedor) {
        proveedorRepository.save(proveedor);  // Guardar en la base de datos
        proveedorFicherosDAO.guardar(proveedor);  // Guardar en el archivo
    }

    @Override
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);  // Eliminar de la base de datos
        proveedorFicherosDAO.eliminar(id);  // Eliminar del archivo
    }

    @Override
    public void updateById(Integer id, Proveedor proveedor) {
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
