package com.projetoDescubraPaulista.turismo_api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "roteiro_ponto")
public class RoteiroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "roteiro_id", nullable = false)
    @JsonBackReference
    private Roteiro roteiro;

    @ManyToOne
    @JoinColumn(name = "ponto_turistico_id", nullable = false)
    private PontoTuristico pontoTuristico;

    @Column(nullable = false)
    private Integer ordem;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Roteiro getRoteiro() { return roteiro; }
    public void setRoteiro(Roteiro roteiro) { this.roteiro = roteiro; }

    public PontoTuristico getPontoTuristico() { return pontoTuristico; }
    public void setPontoTuristico(PontoTuristico pontoTuristico) { this.pontoTuristico = pontoTuristico; }

    public Integer getOrdem() { return ordem; }
    public void setOrdem(Integer ordem) { this.ordem = ordem; }
}
