package com.descubrapaulista.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome da categoria é obrigatório")
    @Column(nullable = false, unique = true, length = 80)
    private String nome;

    @Column(length = 50)
    private String icone;

    @Column(length = 20)
    private String cor;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getIcone() { return icone; }
    public void setIcone(String icone) { this.icone = icone; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
}
