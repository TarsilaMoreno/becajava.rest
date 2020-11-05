package br.rest.eleicao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rest.eleicao.model.ZonaEleitoral;

@RestController
@RequestMapping("/zonaEleitoral")
public class ZonaEleitoralController {

	@PostMapping
	public ResponseEntity criar(@RequestBody ZonaEleitoral zonaEleitoral) {
		if (zonaEleitoral.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Zona Eleitoral não informada.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Zona Eleitoral criada com sucesso!");
			
	}

	@GetMapping
	public ResponseEntity listar() {
		
		List<ZonaEleitoral> lista = new ArrayList<ZonaEleitoral>();
		
		
		ZonaEleitoral z = new ZonaEleitoral();
		z.setNome("A456");
		lista.add(z);
		
		z = new ZonaEleitoral();
		z.setNome("B234");
		lista.add(z);
		
		z = new ZonaEleitoral();
		z.setNome("C345");
		lista.add(z);
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "{/id}")
	public ResponseEntity byId(@PathVariable Long id) {
		ZonaEleitoral z = new ZonaEleitoral();
		z.setNome("D999");
		return null;
		

	}

	@PutMapping(path = "/{id}'")
	public ResponseEntity atualizar(@RequestBody ZonaEleitoral zonaEleitoral, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(zonaEleitoral);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}
}
