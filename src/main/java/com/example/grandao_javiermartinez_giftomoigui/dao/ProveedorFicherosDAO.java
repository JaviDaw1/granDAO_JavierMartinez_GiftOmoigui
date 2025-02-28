package com.example.grandao_javiermartinez_giftomoigui.dao;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProveedorFicherosDAO {
    private static final String FILE_PATH = "proveedores.txt";

    public List<Proveedor> obtenerTodos() {
        List<Proveedor> proveedores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    Proveedor proveedor = new Proveedor(null, partes[0], partes[1], partes[2]);
                    proveedores.add(proveedor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    public void guardar(Proveedor proveedor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(proveedor.getNombre() + ";" + proveedor.getDireccion() + ";" + proveedor.getTelefono());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
