package com.example.grandao_javiermartinez_giftomoigui.repositories;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Producto;
import jakarta.xml.bind.*;

import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {
    private static final String FILE_PATH = "src/main/resources/data/productos.xml";

    public List<Producto> findAll() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();

            JAXBContext context = JAXBContext.newInstance(ProductoList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ProductoList wrapper = (ProductoList) unmarshaller.unmarshal(file);
            return wrapper.getProductos();
        } catch (JAXBException e) {
            throw new RuntimeException("Error al leer el archivo XML", e);
        }
    }

    public Producto save(Producto producto) {
        List<Producto> productos = findAll();
        producto.setId(productos.size() + 1); // Asignar ID único
        productos.add(producto);
        writeToFile(productos);
        return producto;
    }

    public Producto findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean delete(int id) {
        List<Producto> productos = findAll();
        boolean removed = productos.removeIf(p -> p.getId() == id);
        if (removed) writeToFile(productos);
        return removed;
    }

    private void writeToFile(List<Producto> productos) {
        try {
            JAXBContext context = JAXBContext.newInstance(ProductoList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new ProductoList(productos), new File(FILE_PATH));
        } catch (JAXBException e) {
            throw new RuntimeException("Error al escribir en el archivo XML", e);
        }
    }
    public Producto update(int id, Producto updatedProducto) {
        List<Producto> productos = findAll();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                updatedProducto.setId(id);
                productos.set(i, updatedProducto);
                writeToFile(productos);
                return updatedProducto;
            }
        }
        return null; // Producto no encontrado
    }

}

