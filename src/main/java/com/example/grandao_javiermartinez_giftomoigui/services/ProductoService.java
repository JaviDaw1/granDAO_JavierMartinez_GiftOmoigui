package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Integer id);
    Producto save(Producto producto);
    void deleteById(Integer id);
    Producto update(int id, Producto producto);
}
