package com.example.atv.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aluno")
@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "cidade", nullable = false,length = 255)
	private String cidade;
	
	@Column(name = "renda", nullable = false, precision = 10, scale = 2)
	private BigDecimal renda;
	
	@Column(name = "email", nullable = false,length = 255)
	private String email;
	
	@Column(name = "nome", nullable = false,length = 255)
	private String nome;
	
	@Column(name = "ra", nullable = false,length = 255)
	private String ra;
	
	@Column(name = "telefone", nullable = false,length = 255)
	private String telefone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_turma",nullable = false)
	private Turma turma;
	
	
}
