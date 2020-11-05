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
import br.rest.eleicao.model.Eleitor;
import br.rest.eleicao.model.Voto;
import br.rest.eleicao.model.ZonaEleitoral;

@RestController
@RequestMapping("/voto")
public class VotoController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Voto voto) {
		if (voto.getCandidato() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Candidato não informado.");
		else if (voto.getZonaEleitoral() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Zona eleitoral não informada");
		else if (voto.getEleitor() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Eleitor não informado.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Voto criado com sucesso.");
	}

	@GetMapping
	public ResponseEntity listar() {
		List<Voto> lista = new ArrayList<Voto>();

		Voto v = new Voto();
		v.setCandidato("José da Rua");
		v.setZonaEleitoral("A234");
		v.setEleitor("Tarsila");
		lista.add(v);

		v = new Voto();
		v.setCandidato("Murilo da Terra");
		v.setZonaEleitoral("A245");
		v.setEleitor("Carlos");
		lista.add(v);

		v = new Voto();
		v.setCandidato("Maria do Bairro");
		v.setZonaEleitoral("A278");
		v.setEleitor("Danilo");
		lista.add(v);

		return ResponseEntity.status(HttpStatus.OK).body(lista);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Voto v = new Voto();
		v.setCandidato("Talita");
		v.setZonaEleitoral("A478");
		v.setEleitor("Maria Tereza");

		return ResponseEntity.status(HttpStatus.OK).body(v);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Voto voto, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(voto);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

}
