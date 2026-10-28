package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public List<Servicio> listarServicios() {
        return servicioService.listarServicios();
    }

    @GetMapping("/{id}")
    public Servicio buscarPorId(@PathVariable int id) {
        return servicioService.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Servicio> buscarPorNombre(@RequestParam String nombre) {
        return servicioService.buscarPorNombre(nombre);
    }

    @PostMapping
    public Servicio guardarServicio(@RequestBody Servicio servicio) {
        return servicioService.guardarServicio(servicio);
    }

    @PutMapping("/{id}")
    public Servicio actualizarServicio(
            @PathVariable int id,
            @RequestBody Servicio servicio) {
        return servicioService.actualizarServicio(id, servicio);
    }

    @PatchMapping("/{id}")
    public Servicio actualizarParcial(
            @PathVariable int id,
            @RequestBody Servicio servicio) {
        return servicioService.actualizarParcial(id, servicio);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarServicio(@PathVariable int id) {
        return servicioService.eliminarServicio(id);
    }
}