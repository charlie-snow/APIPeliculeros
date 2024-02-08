package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.EmpleadoModel;

public interface IEmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {

}
