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

import com.example.atv.entities.Aluno;
import com.example.atv.services.AlunoServico;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private final AlunoServico alunoServico;

	@Autowired
	public AlunoController(AlunoServico alunoServico) {
		this.alunoServico = alunoServico;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id) {
		Aluno aluno = alunoServico.buscaAlunoId(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> buscaTodosAlunosControl() {
		List<Aluno> aluno = alunoServico.buscaTodosAlunos();
		return ResponseEntity.ok(aluno);
	}

	@PostMapping
	public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody Aluno aluno) {
		Aluno salvaAluno = alunoServico.salvaAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody Aluno aluno) {
		Aluno alteraAluno = alunoServico.alterarAluno(id, aluno);
		if (alteraAluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> apagaAlunoControl(@PathVariable Long id) {
		boolean apagar = alunoServico.apagarAluno(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
