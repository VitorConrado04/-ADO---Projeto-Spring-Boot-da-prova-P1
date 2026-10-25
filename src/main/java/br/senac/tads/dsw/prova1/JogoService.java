package br.senac.tads.dsw.prova1;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class JogoService {

	private AtomicInteger contador = new AtomicInteger(0);
	private Map<Integer, JogoDto> mapJogos = new ConcurrentHashMap<>();

	public Optional<JogoDto> obterPorId(Integer id) {
		return Optional.ofNullable(mapJogos.get(id));
	}

	public JogoDto incluir(JogoDto jogo) {
		jogo.setId(contador.incrementAndGet());
		mapJogos.put(jogo.getId(), jogo);
		return jogo;
	}
}
