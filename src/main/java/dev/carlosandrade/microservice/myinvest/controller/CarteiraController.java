package dev.carlosandrade.microservice.myinvest.controller;

import dev.carlosandrade.microservice.myinvest.model.Carteira;
import dev.carlosandrade.microservice.myinvest.service.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {


    @Autowired
    CarteiraService service;

    @GetMapping("/")
    public ResponseEntity getAll() {

        List<Carteira> lista = service.getAll();
        return !lista.isEmpty() ? ResponseEntity.ok(lista) : ResponseEntity.notFound().build();

    }

    @RequestMapping("/{id}")
    public ResponseEntity read(@PathVariable("id") Integer id) {
        Carteira carteira = service.getById(id);
        return carteira != null ? ResponseEntity.ok(carteira) : ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity create(@Validated @RequestBody Carteira carteira) {
        Carteira itemCreated = service.create(carteira);
        return itemCreated != null ? ResponseEntity.ok(itemCreated) : ResponseEntity.badRequest().body("Ativo ja exisite.");
    }


    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Integer id, @Validated @RequestBody Carteira carteira) {
        Carteira itemUpdated = service.update(id, carteira);
        return itemUpdated != null ? ResponseEntity.ok(itemUpdated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Integer id) {

        return service.delete(id) == true ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }
}
