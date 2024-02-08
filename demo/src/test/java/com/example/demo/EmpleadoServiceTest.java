// package com.example.demo;

// import java.util.ArrayList;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;

// import com.example.demo.models.EmpleadoModel;
// import com.example.demo.services.EmpleadoService;

// public class EmpleadoServiceTest {

// EmpleadoService empleadoService = new EmpleadoService();

// EmpleadoModel empleado = new EmpleadoModel("Juan", "Este", "Back", 34);

// @Test
// public void test1() {
// // EmpleadoModel empleado = empleadoService.getById((long) 1);
// ArrayList<EmpleadoModel> lista = empleadoService.getEmpleados();
// // ArrayList<EmpleadoModel> listaVacia = new ArrayList<EmpleadoModel>();
// Assertions.assertNotNull(lista, "Devuelve null");
// // Assertions.assertEquals(listaVacia, lista, "Lista no vacía");
// }

// @Test
// public void test2() {
// EmpleadoModel nuevoEmpleado = empleadoService.insertEmpleado(empleado);
// // ArrayList<EmpleadoModel> listaVacia = new ArrayList<EmpleadoModel>();
// Assertions.assertNotNull(empleado, "Es null");
// Assertions.assertEquals(nuevoEmpleado, empleado, "Empleado diferente");
// }
// }
