package com.example.demo.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Optional;

import javax.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ContenidoModel;
import com.example.demo.repositories.IContenidoRepository;

@Service
@Transactional // para que se hagan efectivos los cambios en la bd al modificar registros
public class ContenidoService {

    @Autowired
    IContenidoRepository contenidoRepository;

    public ArrayList<ContenidoModel> getContenidos() {
        try {
            ArrayList<ContenidoModel> Contenidos = (ArrayList<ContenidoModel>) contenidoRepository.findAll();
            return new ArrayList<>(Contenidos);
        } catch (Exception e) {
            System.err.println("Error recuperando Contenidos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ContenidoModel saveContenido(ContenidoModel contenido) {
        return contenidoRepository.save(contenido);
    }

    public Optional<ContenidoModel> getById(Long id) {
        return contenidoRepository.findById(id);
    }

    public ContenidoModel updateById(ContenidoModel request, Long id) {
        ContenidoModel contenido = contenidoRepository.findById(id).get();
        contenido.setSerie(request.getSerie());
        contenido.setTitulo(request.getTitulo());
        contenido.setAño(request.getAño());
        contenido.setDirector(request.getDirector());
        contenido.setGenero(request.getGenero());
        contenido.setTemporadas(request.getTemporadas());
        contenido.setDuracion(request.getDuracion());
        contenido.setImplementador(request.getImplementador());
        contenido.setProponedor(request.getProponedor());
        return contenido;
        // return contenidoRepository.updateById(contenido, id);
    }

    public Boolean deleteContenido(Long id) {
        try {
            contenidoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ContenidoModel updateMediaById(ContenidoModel request, Long id) {
        ContenidoModel contenido = contenidoRepository.findById(id).get();
        contenido.setNotaMedia(request.getNotaMedia());
        return contenido;
        // return contenidoRepository.updateById(contenido, id);
    }

    public List<ContenidoModel> listContenidos(Boolean serie) {
        return contenidoRepository.findBySerie(serie);
    }

    public Map<String, Object> getGanador() {

        String ganadorString = contenidoRepository.findProponedorWithHighestPuntuacion();
        String[] parts = ganadorString.split(",");
        String nombre = parts[0].trim();
        String apellido = parts[1].trim();
        String titulo = parts[2].trim();
        String puntuacion = parts[3].trim();

        Map<String, Object> ganador = new LinkedHashMap<>();
        ganador.put("nombre", nombre);
        ganador.put("apellido", apellido);
        ganador.put("titulo", titulo);
        ganador.put("puntuacion", puntuacion);

        return ganador;
    }

    public List<ContenidoModel> findByGenero(String genero) {
        return contenidoRepository.findByGenero(genero);
    }

    public List<ContenidoModel> findByPuntuacion(String puntuacion) {
        return contenidoRepository.findByNotaMedia(Double.parseDouble(puntuacion));
    }

    public List<ContenidoModel> findByAño(String año) {
        return contenidoRepository.findByAño(Integer.parseInt(año));
    }

    public List<ContenidoModel> findByGeneroAndPuntuacion(String genero, String puntuacion) {
        return contenidoRepository.findByGeneroAndNotaMedia(genero, Double.parseDouble(puntuacion));
    }

    public List<ContenidoModel> findByGeneroAndAño(String genero, String año) {
        return contenidoRepository.findByGeneroAndAño(genero, Integer.parseInt(año));
    }

    public List<ContenidoModel> findByPuntuacionAndAño(String puntuacion, String año) {
        return contenidoRepository.findByNotaMediaAndAño(Double.parseDouble(puntuacion), Integer.parseInt(año));
    }

    public List<ContenidoModel> findByGeneroAndPuntuacionAndAño(String genero, String puntuacion, String año) {
        return contenidoRepository.findByGeneroAndNotaMediaAndAño(genero, Double.parseDouble(puntuacion),
                Integer.parseInt(año));
    }

}
