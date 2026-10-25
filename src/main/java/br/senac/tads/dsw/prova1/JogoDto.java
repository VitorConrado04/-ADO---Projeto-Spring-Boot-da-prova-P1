package br.senac.tads.dsw.prova1;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JogoDto {

	private Integer id;

	@NotBlank
	@Size(max = 100) // *** ANOTAÇÕES PODEM SER COLOCADAS UMA NA FRENTE DA OUTRA
	private String titulo;

	@NotNull
	@Min(1950)
	private Integer anoLancamento;

	@NotBlank @Size(max = 50)
	private String plataforma;

	public JogoDto() {
	}

	public JogoDto(Integer id, String titulo, Integer anoLancamento, String plataforma) {
		this.id = id;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.plataforma = plataforma;
	}

	// *** MÉTODOS GET E SET DOS ATRIBUTOS CRIADOS, MAS OMITIDOS NESTE CÓDIGO ***

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
}
