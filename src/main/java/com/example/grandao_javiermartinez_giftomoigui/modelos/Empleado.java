package com.example.grandao_javiermartinez_giftomoigui.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "empleados")  // Esta anotación indica que la clase será mapeada a una colección "empleados"
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id  // MongoDB usa este campo como identificador único
    private String id;  // El tipo debe ser String para que MongoDB gestione el ObjectId internamente

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;

    @Size(max = 100, message = "El puesto no puede superar los 100 caracteres")
    private String puesto;

    @NotNull(message = "El salario no puede ser nulo")
    private BigDecimal salario;
}
