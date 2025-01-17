package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Cliente;
import com.coderhouse.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
    private ClienteRepository clienteRepository;
	
	public List<Cliente> getALLAlumnos(){
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
	   return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
    }
	
   @Transactional
   public Cliente saveAlumno(Cliente alumno) {
	   return clienteRepository.save(alumno);
	   
   }

public List<Cliente> getALLClientes() {

	return null;
}

public Cliente saveCliente(Cliente cliente) {

	return null;
}

public Cliente obtenerPorId(Long id) {

	return null;
}

public void eliminar(Long id) {
	
}
}