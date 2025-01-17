package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Cliente;
import com.coderhouse.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
     private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getALLClientes() {
		try {
			List<Cliente> clientes= clienteService.getALLClientes();
			return ResponseEntity.ok(clientes);
		}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long Id){
		try {
			Cliente cliente = clienteService.findById(Id);
			return ResponseEntity.ok(cliente);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
	   try {
		   Cliente clienteCreado = clienteService.saveCliente(cliente);
		       return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
	   }catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.obtenerPorId(id);
        if (cliente != null) {
            clienteService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

