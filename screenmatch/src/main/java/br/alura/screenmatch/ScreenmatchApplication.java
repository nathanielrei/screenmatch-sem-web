package br.alura.screenmatch;

import br.alura.screenmatch.model.DadosSerie;
import br.alura.screenmatch.service.ConsumoApi;
import br.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumindoApi = new ConsumoApi();
		var json = consumindoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=faec7b04");
		System.out.println(json);
//		  json = consumindoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
