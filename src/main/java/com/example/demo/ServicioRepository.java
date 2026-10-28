package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ServicioRepository {

    private List<Servicio> servicios = new ArrayList<>();

    public ServicioRepository() {
        servicios.add(new Servicio(1, "Pestañas", 100000, "Servicios de pestañas"));
        servicios.add(new Servicio(2, "Cejas", 40000, "Servicios de cejas"));
        servicios.add(new Servicio(3, "Uñas", 85000, "Servicios de uñas"));
        servicios.add(new Servicio(4, "Depilación", 650000, "Servicios de depilación"));
        servicios.add(new Servicio(5, "Cabello", 300000, "Servicios para el cabello"));
        servicios.add(new Servicio(6, "Maquillaje", 280000, "Servicios de maquillaje"));
    }

    public List<Servicio> findAll() {
        return servicios;
    }

    public Optional<Servicio> findById(int id) {
        return servicios.stream()
                .filter(servicio -> servicio.getId() == id)
                .findFirst();
    }

    public List<Servicio> findByNombre(String nombre) {
        return servicios.stream()
                .filter(servicio -> servicio.getNombre()
                        .equalsIgnoreCase(nombre))
                .toList();
    }

    public Servicio save(Servicio servicio) {
        servicios.add(servicio);
        return servicio;
    }

    public boolean deleteById(int id) {
        return servicios.removeIf(servicio -> servicio.getId() == id);
    }
}