package dev.carlosandrade.microservice.myinvest;

import dev.carlosandrade.microservice.myinvest.repository.AtivosRepository;
import dev.carlosandrade.microservice.myinvest.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyinvestApplication implements CommandLineRunner {

    @Autowired
    CarteiraRepository carteiraRepository;

    @Autowired
    AtivosRepository ativosRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyinvestApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

       /* Carteira carteira = carteiraRepository.findById(1L).get();
        Ativos vale3 = Ativos.builder().ticker("VALE3").quantidade(1L).preco(83L).total(83L).carteira(carteira).build();
        carteira.getAtivos().add(vale3);
        carteiraRepository.save(carteira);*/
    }

}
