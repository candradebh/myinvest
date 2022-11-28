package dev.carlosandrade.microservice.myinvest.controller;

import dev.carlosandrade.microservice.myinvest.model.Ativos;
import dev.carlosandrade.microservice.myinvest.model.Carteira;
import dev.carlosandrade.microservice.myinvest.repository.AtivosRepository;
import dev.carlosandrade.microservice.myinvest.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    @Autowired
    CarteiraRepository carteiraRepository;

    @Autowired
    AtivosRepository ativosRepository;

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody Ativos ativo) {

        if (ativo.getCarteira() == null) {
            return ResponseEntity.badRequest().body("Informe a carteira");
        }

        Optional<Carteira> carteira = carteiraRepository.findById(ativo.getCarteira().getId());
        if (carteira.isPresent() == false) {
            return ResponseEntity.badRequest().body("Carteira não encontrada");
        }
        Carteira carteiraAtualizada = carteira.get();
        ativo.setCarteira(carteiraAtualizada);

        Ativos ativoCreated = ativosRepository.save(ativo);
        carteiraAtualizada.getAtivos().add(ativoCreated);

        carteiraRepository.save(carteiraAtualizada);

        return ResponseEntity.ok(carteiraAtualizada);

    }
}
