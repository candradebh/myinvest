package dev.carlosandrade.microservice.myinvest.repository;

import dev.carlosandrade.microservice.myinvest.model.Ativos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivosRepository extends CrudRepository<Ativos, Long> {
}