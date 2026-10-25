package br.senac.tads.dsw.prova1;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

// *** PACKAGE E IMPORTS USUAIS OMITIDOS ***
@RestController
@RequestMapping("/jogos")
public class JogoController {

	private final JogoService jogoService;

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@GetMapping("/{id}")
	public JogoDto obterPorId(@PathVariable("id") Integer id) {
		Optional<JogoDto> optJogo = jogoService.obterPorId(id);
		if (optJogo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Jogo não encontrado");
		}
		return optJogo.get();
	}

	@PostMapping
	public ResponseEntity<?> incluir(@RequestBody @Valid JogoDto jogo) {
		jogoService.incluir(jogo);
		URI location = ServletUriComponentsBuilder
			.fromCurrentContextPath()
			.path("/jogos/{id}")
			.buildAndExpand(jogo.getId())
			.toUri();
		return ResponseEntity.created(location).build();
	}
}
