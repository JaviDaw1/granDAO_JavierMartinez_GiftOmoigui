package com.example.grandao_javiermartinez_giftomoigui.repositories;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Producto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
public class ProductoList {
    private List<Producto> productos;

    @XmlElement(name = "producto")
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

