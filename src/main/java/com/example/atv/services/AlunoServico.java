package com.example.atv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atv.entities.Aluno;
import com.example.atv.repository.AlunoRepository;
@Service
public class AlunoServico {
	
	private final AlunoRepository alunoRepository;

	@Autowired
	public AlunoServico(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	public List<Aluno> buscaTodosAlunos(){
		return alunoRepository.findAll();
	}
	public Aluno buscaAlunoId(Long id) {
		Optional <Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElse(null);
	}
	public Aluno salvaAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	public Aluno alterarAluno(Long id, Aluno alterarAluno) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		if(existeAluno.isPresent()) {
			alterarAluno.setId(id);
			return alunoRepository.save(alterarAluno);
		}
		return null;
	}
	public boolean apagarAluno(Long id) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	
	}

}
	
		
	

