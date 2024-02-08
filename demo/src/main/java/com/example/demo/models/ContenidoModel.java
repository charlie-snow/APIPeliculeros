package com.example.demo.models;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "contenidos")
public class ContenidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean serie;

    @Column
    private String titulo;

    @Column
    private Integer año;

    @Column
    private String director;

    @Column
    private String genero;

    @Column
    private Integer temporadas;

    @Column
    private Integer duracion;

    @Column
    private Integer implementador;

    @Column
    private Integer proponedor;

    @Column
    private Double notaMedia;

    @Column
    private Timestamp registrado;
    // private Instant registrado = Instant.now();

    @PrePersist
    protected void onCreate() {
        this.registrado = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSerie() {
        return serie;
    }

    public void setSerie(Boolean serie) {
        this.serie = serie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getImplementador() {
        return implementador;
    }

    public void setImplementador(Integer implementador) {
        this.implementador = implementador;
    }

    public Integer getProponedor() {
        return proponedor;
    }

    public void setProponedor(Integer proponedor) {
        this.proponedor = proponedor;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public Timestamp getRegistrado() {
        return registrado;
    }

    public void setRegistrado(Timestamp registrado) {
        this.registrado = registrado;
    }
}
