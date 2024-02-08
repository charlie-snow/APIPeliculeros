package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ContenidoModel;
import com.example.demo.services.ContenidoService;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public List<ContenidoModel> getContenidos(@RequestParam(required = false) String genero,
            @RequestParam(required = false) String puntuacion, @RequestParam(required = false) String año) {

        if (genero == null && puntuacion == null && año == null) {
            return this.contenidoService.getContenidos();
        } else {
            if (genero != null && puntuacion != null && año != null) {
                // Filter by genero, puntuacion, and año
                return this.contenidoService.findByGeneroAndPuntuacionAndAño(genero, puntuacion, año);
            } else if (genero != null && puntuacion != null) {
                // Filter by genero and puntuacion
                return this.contenidoService.findByGeneroAndPuntuacion(genero, puntuacion);
            } else if (genero != null && año != null) {
                // Filter by genero and año
                return this.contenidoService.findByGeneroAndAño(genero, año);
            } else if (puntuacion != null && año != null) {
                // Filter by puntuacion and año
                return this.contenidoService.findByPuntuacionAndAño(puntuacion, año);
            } else if (genero != null) {
                // Filter by genero
                return this.contenidoService.findByGenero(genero);
            } else if (puntuacion != null) {
                // Filter by puntuacion
                return this.contenidoService.findByPuntuacion(puntuacion);
            } else if (año != null) {
                // Filter by año
                return this.contenidoService.findByAño(año);
            } else {
                // Handle other combinations or return an empty list as per your requirements
                return Collections.emptyList();
            }
        }

    }

    @GetMapping("/peliculas")
    public List<ContenidoModel> getPeliculas() {
        return this.contenidoService.listContenidos(false);
    }

    @GetMapping("/series")
    public List<ContenidoModel> getSeries() {
        return this.contenidoService.listContenidos(true);
    }

    @PostMapping
    public ContenidoModel saveContenido(@RequestBody ContenidoModel contenido) {
        return this.contenidoService.saveContenido(contenido);
    }

    @GetMapping("/{id}")
    public Optional<ContenidoModel> getContenidoById(@PathVariable("id") Long id) {
        return this.contenidoService.getById(id);
    }

    @PutMapping("/{id}")
    public ContenidoModel updateContenidoById(@RequestBody ContenidoModel request, @PathVariable("id") Long id) {
        return this.contenidoService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteContenidoById(@PathVariable("id") Long id) {
        boolean ok = this.contenidoService.deleteContenido(id);
        if (ok) {
            return "Contenido con id " + id + " borrado";
        } else {
            return "Contenido con id " + id + " no ha podido ser borrado";
        }
    }

    @PatchMapping("/{id}")
    public ContenidoModel updateContenidoMediaById(@RequestBody ContenidoModel request, @PathVariable("id") Long id) {
        return this.contenidoService.updateMediaById(request, id);
    }

    @GetMapping("/ganador")
    public Map<String, Object> getGanador() {
        return this.contenidoService.getGanador();
    }
}
