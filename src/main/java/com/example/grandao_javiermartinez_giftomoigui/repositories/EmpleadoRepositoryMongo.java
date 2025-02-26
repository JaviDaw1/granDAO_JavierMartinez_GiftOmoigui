package com.example.grandao_javiermartinez_giftomoigui.repositories;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpleadoRepositoryMongo extends MongoRepository<Empleado, String> {
    @Override
    void deleteById(String id);
}
