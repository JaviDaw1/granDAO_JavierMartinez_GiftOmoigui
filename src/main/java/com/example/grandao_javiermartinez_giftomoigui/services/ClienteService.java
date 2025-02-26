package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Integer id);
    Cliente update(Integer id, Cliente cliente);
    Cliente save(Cliente cliente);
    void delete(Integer id);
}
