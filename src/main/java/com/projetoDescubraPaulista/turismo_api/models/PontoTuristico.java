package com.projetoDescubraPaulista.turismo_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ponto_turistico")
public class PontoTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome do ponto turístico é obrigatório")
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    // Relacionamento com Categoria (CLASSIFICA)
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Float latitude;
    private Float longitude;

    @Column(length = 255)
    private String endereco;

    @Column(name = "foto_url", length = 500)
    private String fotoUrl;

    @Column(nullable = false)
    private Boolean ativo = true;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Float getLatitude() { return latitude; }
    public void setLatitude(Float latitude) { this.latitude = latitude; }

    public Float getLongitude() { return longitude; }
    public void setLongitude(Float longitude) { this.longitude = longitude; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
