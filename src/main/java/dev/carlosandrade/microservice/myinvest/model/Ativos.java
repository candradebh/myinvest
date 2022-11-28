package dev.carlosandrade.microservice.myinvest.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ativos")
public class Ativos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;

    private String ticker;

    private int quantidade;

    private Long preco;

    private Long total;

    @Column(nullable = true)
    private Date ultimaAtualizacao;


}
