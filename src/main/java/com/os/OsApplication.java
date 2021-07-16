package com.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;

import com.os.domain.Cliente;
import com.os.domain.OS;
import com.os.domain.Tecnico;
import com.os.enuns.Prioridade;
import com.os.enuns.Status;
import com.os.repositories.ClienteRepository;
import com.os.repositories.OSRepository;
import com.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico t1 = new Tecnico(null, "Sebastiao Rodrigo", "010.460.381-09", "(88) 98230-4040");
		Cliente c1 = new Cliente(null, "Aline Nogueira", "010.460.381-09", "(66) 97230-2030");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste no pc", Status.ABERTO, t1, c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
