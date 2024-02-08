package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmpleadoModel;
import com.example.demo.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ArrayList<EmpleadoModel> getEmpleados() {
        System.out.println("controlador getEmpleados");
        return this.empleadoService.getEmpleados();
    }

    @PostMapping
    public EmpleadoModel insertEmpleado(@RequestBody EmpleadoModel empleado) {
        return this.empleadoService.insertEmpleado(empleado);
    }

    @GetMapping("/{id}")
    public Optional<EmpleadoModel> getEmpleadoById(@PathVariable("id") Long id) {
        return this.empleadoService.getById(id);
    }

    @PutMapping("/{id}")
    public EmpleadoModel updateEmpleadoById(@RequestBody EmpleadoModel request, @PathVariable("id") Long id) {
        return this.empleadoService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpleadoById(@PathVariable("id") Long id) {
        boolean ok = this.empleadoService.deleteEmpleado(id);
        if (ok) {
            return "Empleado con id " + id + " borrado";
        } else {
            return "Empleado con id " + id + " no ha podido ser borrado";
        }
    }
}
