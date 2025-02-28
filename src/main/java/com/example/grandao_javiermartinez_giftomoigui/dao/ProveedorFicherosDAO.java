package com.example.grandao_javiermartinez_giftomoigui.dao;

import com.example.grandao_javiermartinez_giftomoigui.modelos.Proveedor;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProveedorFicherosDAO {
    private static final String FILE_PATH = "src/main/resources/data/proveedores.txt";

    public ProveedorFicherosDAO() {
        crearArchivoSiNoExiste();
    }

    private void crearArchivoSiNoExiste() {
        try {
            File file = new File(FILE_PATH);
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                Files.createDirectories(Paths.get(parentDir.getPath())); // Crea la carpeta si no existe
            }
            if (!file.exists()) {
                file.createNewFile(); // Crea el archivo si no existe
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Proveedor> obtenerTodos() {
        List<Proveedor> proveedores = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return proveedores; // Retorna vacío si el archivo no tiene datos
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 3) {
                    String[] idNombre = partes[0].split(",");
                    Proveedor proveedor = new Proveedor(Integer.parseInt(idNombre[0]), idNombre[1], partes[1], partes[2]);
                    proveedores.add(proveedor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    public void guardar(Proveedor proveedor) {
        int nuevoId = obtenerSiguienteId();  // Obtener el siguiente ID para el nuevo proveedor
        proveedor.setId(nuevoId);  // Asignar el ID al nuevo proveedor

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(proveedor.getId() + "," + proveedor.getNombre() + ";" + proveedor.getDireccion() + ";" + proveedor.getTelefono());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Integer id) {
        List<Proveedor> proveedores = obtenerTodos();
        proveedores.removeIf(proveedor -> proveedor.getId().equals(id));
        actualizarArchivo(proveedores);  // Reescribir el archivo sin el proveedor eliminado
    }

    public void actualizar(Integer id, Proveedor proveedorActualizado) {
        List<Proveedor> proveedores = obtenerTodos();
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getId().equals(id)) {
                proveedores.set(i, proveedorActualizado);  // Reemplazar el proveedor
                break;
            }
        }
        actualizarArchivo(proveedores);  // Reescribir el archivo con el proveedor actualizado
    }

    // Método para sincronizar el archivo con la base de datos
    private void actualizarArchivo(List<Proveedor> proveedores) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (Proveedor proveedor : proveedores) {
                bw.write(proveedor.getId() + "," + proveedor.getNombre() + ";" + proveedor.getDireccion() + ";" + proveedor.getTelefono());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int obtenerSiguienteId() {
        List<Proveedor> proveedores = obtenerTodos();
        if (proveedores.isEmpty()) {
            return 1;  // El primer proveedor tendrá el ID 1
        } else {
            return proveedores.get(proveedores.size() - 1).getId() + 1;  // ID autoincremental
        }
    }
}
