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

import br.rest.eleicao.model.Eleitor;

@RestController
@RequestMapping("/eleitor")
public class EleitorController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Eleitor eleitor) {
		if (eleitor.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Eleitor não informado.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor criado com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {

		List<Eleitor> lista = new ArrayList<Eleitor>();

		Eleitor e = new Eleitor();
		e.setNome("Tarsila");
		lista.add(e);

		e = new Eleitor();
		e.setNome("Carlos");
		lista.add(e);

		e = new Eleitor();
		e.setNome("Marina");
		lista.add(e);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Eleitor e = new Eleitor();
		e.setNome("Mariana");

		return ResponseEntity.status(HttpStatus.OK).body(e);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Eleitor eleitor, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
