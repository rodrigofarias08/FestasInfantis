package br.senai.sc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Cliente;
import br.senai.sc.domain.Festa;
import br.senai.sc.domain.Tema;
import br.senai.sc.repositories.ClienteRepository;
import br.senai.sc.repositories.FestaRepository;
import br.senai.sc.repositories.TemaRepository;

@SpringBootApplication
public class FestasInfantisApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private FestaRepository festaRepo;
	@Autowired
	private TemaRepository temaRepo;

	public static void main(String[] args) {
		SpringApplication.run(FestasInfantisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Tema frozen = new Tema(id, itens, cor_toalha, preco);
		Tema frozen = new Tema(null, new ArrayList<String>(), "branca", 1000.0);
		Tema batman = new Tema(null, new ArrayList<String>(), "preta", 800.0);
		Tema galinha_pintadinha = new Tema(null, new ArrayList<String>(), "azul", 500.0);

		//Cliente maria = new Cliente(id, nome, telefone, data_criacao);
		Cliente maria = new Cliente(null, "Maria Helena", "4812343687", Calendar.getInstance().getTime());
		Cliente joao = new Cliente(null, "João Morimbundo", "4992333687", Calendar.getInstance().getTime());
		Cliente pedro = new Cliente(null, "Pedro Jajá", "4994333667", Calendar.getInstance().getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		//Festa frozen_relution = new Festa(id, endereco, data_hora_inicio, data_hora_fim, cliente, tema);
		Festa frozen_revolution = new Festa(null, "Rua dos Alfeneiros", sdf.parse("20/09/2020 10:32"), sdf.parse("20/09/2020 13:33"), maria, frozen);
		Festa batman_revolution = new Festa(null, "Rua dos Alfeneiros", sdf.parse("10/08/2020 10:32"), sdf.parse("10/08/2020 13:33"), joao, batman);
		Festa galinha_pintadinha_revolution = new Festa(null, "Rua dos Alfeneiros", sdf.parse("01/07/2020 10:32"), sdf.parse("01/07/2020 13:33"), pedro, galinha_pintadinha);

		frozen.getFestas().add(frozen_revolution);
		batman.getFestas().add(batman_revolution);
		galinha_pintadinha.getFestas().add(galinha_pintadinha_revolution);
		
		maria.getFestas().add(frozen_revolution);
		joao.getFestas().add(batman_revolution);
		pedro.getFestas().add(galinha_pintadinha_revolution);

		temaRepo.save(frozen);
		temaRepo.save(batman);
		temaRepo.save(galinha_pintadinha);
		
		clienteRepo.save(maria);
		clienteRepo.save(joao);
		clienteRepo.save(pedro);

		festaRepo.save(frozen_revolution);
		festaRepo.save(batman_revolution);
		festaRepo.save(galinha_pintadinha_revolution);
		
		
	}

}
