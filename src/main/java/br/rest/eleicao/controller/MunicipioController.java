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


import br.rest.eleicao.model.Municipio;



@RestController
@RequestMapping("/municipio")
public class MunicipioController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Municipio municipio) {
		if (municipio.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Municipio não informado.");
		else if (municipio.getPopulacao() == "" )
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("População não informada.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Municipio criado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity listar() {

		List<Municipio> lista = new ArrayList<Municipio>();

		Municipio m = new Municipio();
		m.setNome("São Paulo");
		m.setPopulacao("12000000");
		lista.add(m);

		m = new Municipio();
		m.setNome("Guarulhos");
		m.setPopulacao("100000");
		lista.add(m);

		m = new Municipio();
		m.setNome("Piracaia");
		m.setPopulacao("140000");
		lista.add(m);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Municipio m = new Municipio();
		m.setNome("Pirangi");
		m.setPopulacao("40000");
		return null;

		
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Municipio municipio, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(municipio);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
