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

import br.rest.eleicao.model.Candidato;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Candidato candidato) {
		if (candidato.getCategoria() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoria não informada.");
		else if (candidato.getNumero() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número não informado.");
		else if (candidato.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Candidato criado com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {

		List<Candidato> lista = new ArrayList<Candidato>();

		Candidato c = new Candidato();
		c.setCategoria("Prefeito");
		c.setNome("João Da Vila");
		c.setNumero("33");
		lista.add(c);

		c = new Candidato();
		c.setCategoria("Prefeito");
		c.setNome("João Da Vila");
		c.setNumero("33");
		lista.add(c);

		c = new Candidato();
		c.setCategoria("Prefeito");
		c.setNome("João Da Vila");
		c.setNumero("33");
		lista.add(c);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Candidato c = new Candidato();
		c.setCategoria("Prefeito");
		c.setNome("Maria do Bairro");
		c.setNumero("44");

		return ResponseEntity.status(HttpStatus.OK).body(c);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Candidato candidato, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(candidato);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
