package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.EmpleadoModel;
import com.example.demo.repositories.IEmpleadoRepository;

@Service
@Transactional // para que se hagan efectivos los cambios en la bd al modificar registros
public class EmpleadoService {

    @Autowired
    IEmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoModel> getEmpleados() {
        // System.out.println("getEmpleados en /empleado GET");
        try {
            ArrayList<EmpleadoModel> Empleados = (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
            return new ArrayList<>(Empleados);
        } catch (Exception e) {
            System.err.println("Error recuperando Empleados: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public EmpleadoModel insertEmpleado(EmpleadoModel empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<EmpleadoModel> getById(Long id) {
        return empleadoRepository.findById(id);
    }

    public EmpleadoModel updateById(EmpleadoModel request, Long id) {
        EmpleadoModel empleado = empleadoRepository.findById(id).get();
        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setSeccion(request.getSeccion());
        empleado.setEdad(request.getEdad());
        return empleado;
    }

    public Boolean deleteEmpleado(Long id) {
        // FALTA: habría que eliminar registros de la tabla de contenidos que hagan
        // referencia al empleado, como proponedor, y quizás como implantador
        try {
            empleadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
