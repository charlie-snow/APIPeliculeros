package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.ContenidoModel;

public interface IContenidoRepository extends JpaRepository<ContenidoModel, Long> {

    List<ContenidoModel> findBySerie(Boolean serie);

    List<ContenidoModel> findByGenero(String genero);

    List<ContenidoModel> findByNotaMedia(Double puntuacion);

    List<ContenidoModel> findByAño(Integer año);

    List<ContenidoModel> findByGeneroAndNotaMedia(String genero, Double puntuacion);

    List<ContenidoModel> findByGeneroAndAño(String genero, Integer año);

    List<ContenidoModel> findByNotaMediaAndAño(Double puntuacion, Integer año);

    List<ContenidoModel> findByGeneroAndNotaMediaAndAño(String genero, Double puntuacion, Integer año);

    @Query(value = "SELECT e.nombre, e.apellido, y.titulo, (SELECT MAX(y2.nota_media) FROM  cleverpy_test. contenidos y2) as max_nota_media FROM cleverpy_test.contenidos y INNER JOIN cleverpy_test.empleados e ON y.proponedor=e.id WHERE y.nota_media=(SELECT MAX(y2.nota_media) FROM cleverpy_test.contenidos y2)", nativeQuery = true)
    String findProponedorWithHighestPuntuacion();

    // @Query(value = "SELECT * FROM cleverpy_test.contenidos WHERE genero = 'Género
    // de Ejemplo' AND "año"=2022 AND nota_media>=8.0", nativeQuery = true)
    // String findContenidosBy();

    // @Query("SELECT new com.example.GanadorModel(e.nombre, y.titulo, (SELECT
    // MAX(y2.notaMedia) FROM cleverpy_test.contenidos y2)) FROM
    // cleverpy_test.contenidos y INNER JOIN cleverpy_test.empleados e ON
    // y.proponedor = e.id WHERE y.notaMedia = (SELECT MAX(y2.notaMedia) FROM
    // cleverpy_test.contenidos y2)")
    // GanadorModel findNombreTituloAndMaxNotaMedia();

}
