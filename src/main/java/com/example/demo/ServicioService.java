package com.example.demo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {

    private final ServicioRepository repositorio;

    public ServicioService(ServicioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Servicio> listarServicios() {
        return repositorio.findAll();
    }

    public Servicio buscarPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }

    public List<Servicio> buscarPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public Servicio guardarServicio(Servicio servicio) {
        return repositorio.save(servicio);
    }

    public Servicio actualizarServicio(int id, Servicio nuevoServicio) {
        Servicio servicio = buscarPorId(id);

        if (servicio != null) {
            servicio.setNombre(nuevoServicio.getNombre());
            servicio.setPrecio(nuevoServicio.getPrecio());
            servicio.setDescripcion(nuevoServicio.getDescripcion());
            return servicio;
        }

        return null;
    }

    public Servicio actualizarParcial(int id, Servicio datos) {
        Servicio servicio = buscarPorId(id);

        if (servicio != null) {
            if (datos.getNombre() != null) {
                servicio.setNombre(datos.getNombre());
            }

            if (datos.getPrecio() > 0) {
                servicio.setPrecio(datos.getPrecio());
            }

            if (datos.getDescripcion() != null) {
                servicio.setDescripcion(datos.getDescripcion());
            }

            return servicio;
        }

        return null;
    }

    public boolean eliminarServicio(int id) {
        return repositorio.deleteById(id);
    }
}