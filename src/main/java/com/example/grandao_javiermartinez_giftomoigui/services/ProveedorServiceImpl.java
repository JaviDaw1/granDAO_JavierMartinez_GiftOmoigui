package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.dao.ProveedorFicherosDAO;
import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import com.example.grandao_javiermartinez_giftomoigui.repositories.ProveedorRepositoryFicheros;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepositoryFicheros proveedorRepository;
    private final ProveedorFicherosDAO proveedorFicherosDAO;

    public ProveedorServiceImpl(ProveedorRepositoryFicheros proveedorRepository, ProveedorFicherosDAO proveedorFicherosDAO) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorFicherosDAO = proveedorFicherosDAO;
    }

    @Override
    public List<Proveedor> findAll(boolean desdeArchivo) {
        return desdeArchivo ? proveedorFicherosDAO.obtenerTodos() : proveedorRepository.findAll();
    }

    @Override
    public Proveedor findById(Integer id) {
        return proveedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor, boolean enArchivo) {
        if (enArchivo) {
            proveedorFicherosDAO.guardar(proveedor);
            return proveedor; // No retorna ID porque está en archivo
        }
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor update(Integer id, Proveedor proveedor) {
        Proveedor proveedorExistente = findById(id);
        proveedorExistente.setNombre(proveedor.getNombre());
        proveedorExistente.setDireccion(proveedor.getDireccion());
        proveedorExistente.setTelefono(proveedor.getTelefono());
        return proveedorRepository.save(proveedorExistente);
    }
}
