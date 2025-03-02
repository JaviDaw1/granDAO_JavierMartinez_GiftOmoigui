/*
package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Cliente;
import com.example.grandao_javiermartinez_giftomoigui.repositories.ClienteRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepositoryJPA clienteRepository;

    public ClienteServiceImpl(ClienteRepositoryJPA clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        Cliente updated= clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con id: " + id));
        updated.setNombre(cliente.getNombre());
        updated.setCorreo(cliente.getCorreo());
        updated.setTelefono(cliente.getTelefono());
        return clienteRepository.save(updated);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
*/
