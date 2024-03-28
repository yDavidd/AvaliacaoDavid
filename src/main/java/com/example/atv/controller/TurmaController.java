package com.example.atv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.atv.entities.Turma;
import com.example.atv.services.TurmaServico;



@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	private final TurmaServico turmaServico;

	@Autowired
	public TurmaController(TurmaServico turmaServico) {
		this.turmaServico = turmaServico;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscaTurmaControlId(@PathVariable Long id) {
		Turma turma = turmaServico.buscaTurmaId(id);
		if (turma != null) {
			return ResponseEntity.ok(turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Turma>> buscaTodosTurmasControl() {
		List<Turma> turma = turmaServico.buscaTodosTurmas();
		return ResponseEntity.ok(turma);
	}

	@PostMapping
	public ResponseEntity<Turma> salvaTurmaControl(@RequestBody Turma turma) {
		Turma salvaTurma = turmaServico.salvaTurma(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Turma> alteraTurmaControl(@PathVariable Long id, @RequestBody Turma turma) {
		Turma alteraTurma = turmaServico.alterarTurma(id, turma);
		if (alteraTurma != null) {
			return ResponseEntity.ok(turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> apagaTurmaControl(@PathVariable Long id) {
		boolean apagar = turmaServico.apagarTurma(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
