package dev.carlosandrade.microservice.myinvest.service;

import dev.carlosandrade.microservice.myinvest.controller.CarteiraController;
import dev.carlosandrade.microservice.myinvest.model.Carteira;
import dev.carlosandrade.microservice.myinvest.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class CarteiraService {

    @Autowired
    private CarteiraRepository repository;

    public Carteira getById(Long id) {
        return repository.findById(id).orElse(new Carteira());
    }

    public List<Carteira> getAll() {

        List<Carteira> listRegisters = (List<Carteira>) repository.findAll();

        if (!listRegisters.isEmpty()) {

            for (Carteira register : listRegisters) {
                Long id = register.getId();
                register.add(linkTo(methodOn(CarteiraController.class).read(id)).withRel("read"));
            }
        }

        return listRegisters;
    }

    public Carteira update(Long id, Carteira Carteira) {

        Optional<Carteira> CarteiraExisting = repository.findById(id);
        if (CarteiraExisting.isPresent()) {
            Carteira updatedcarteira = CarteiraExisting.get();

            if (Carteira.getNome() != null && !Carteira.getNome().equals(updatedcarteira.getNome())) {
                updatedcarteira.setNome(Carteira.getNome());
            }

            repository.save(updatedcarteira);

            return (Carteira) repository.save(updatedcarteira).add(linkTo(methodOn(CarteiraController.class).getAll()).withRel("getAll"));

        } else {
            return null;
        }
    }

    public Carteira read(Long id) {

        Optional<Carteira> register = repository.findById(id);
        return register.isPresent() ? (Carteira) register.get().add(linkTo(methodOn(CarteiraController.class).getAll()).withRel("getAll")) : null;
    }

    public Carteira create(Carteira carteira) {

        return (Carteira) repository.save(carteira).add(linkTo(methodOn(CarteiraController.class).getAll()).withRel("getAll"));
    }

    public boolean delete(Long id) {

        return repository.findById(id).map(existingCarteira -> {
            repository.delete(existingCarteira);
            return true;
        }).orElse(false);
    }
}
