package dev.carlosandrade.microservice.myinvest.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "carteiras")
public class Carteira extends RepresentationModel {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String userName;

    @Enumerated(EnumType.STRING)
    private TipoMoeda tipoMoeda;

    private String nome;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = true)
    private Long total;

}
