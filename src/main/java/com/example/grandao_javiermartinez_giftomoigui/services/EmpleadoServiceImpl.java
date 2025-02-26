package com.example.grandao_javiermartinez_giftomoigui.services;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Empleado;
import com.example.grandao_javiermartinez_giftomoigui.repositories.EmpleadoRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepositoryMongo empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepositoryMongo empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findById(String id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(String id, Empleado empleado) {
        Empleado updated= empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el empleado con id: " + id));
        updated.setNombre(empleado.getNombre());
        updated.setPuesto(empleado.getPuesto());
        updated.setSalario(empleado.getSalario());
        return empleadoRepository.save(updated);
    }

    @Override
    public void delete(String id) {
        empleadoRepository.deleteById(id);
    }
}
