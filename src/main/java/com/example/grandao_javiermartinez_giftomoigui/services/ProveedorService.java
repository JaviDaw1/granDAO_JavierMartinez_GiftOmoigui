package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> findAll(boolean desdeArchivo);
    Proveedor findById(Integer id);
    void deleteById(Integer id);
    Proveedor save(Proveedor proveedor, boolean enArchivo);
    Proveedor update(Integer id, Proveedor proveedor);
}
