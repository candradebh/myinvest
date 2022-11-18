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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id", nullable = false)
    private Carteira carteira;

    private String ticker;

    private Long quantidade;

    private Long preco;

    private Long total;

    private Date ultimaAtualizacao;


}
