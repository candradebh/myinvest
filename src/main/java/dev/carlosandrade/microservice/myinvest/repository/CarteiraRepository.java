package dev.carlosandrade.microservice.myinvest.repository;

import dev.carlosandrade.microservice.myinvest.model.Carteira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarteiraRepository extends CrudRepository<Carteira, Integer> {


}
