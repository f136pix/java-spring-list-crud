package com.f136px.toDoList.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Afazer {

		@Id
		@GeneratedValue
		private int id;
		private String username;
		@Size(min=10, message="Descrição deve conter ao menos 10 caracteres")
		private String descricao;
		private LocalDate dataAlvo;
		private boolean feito;
		
		public Afazer(int id, String username, String descricao, LocalDate dataAlvo, boolean feito) {
			super();
			this.id = id;
			this.username = username;
			this.descricao = descricao;
			this.dataAlvo = dataAlvo;
			this.feito = feito;
		}

		public Afazer() {

		}
}
