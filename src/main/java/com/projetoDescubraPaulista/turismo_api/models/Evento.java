package com.projetoDescubraPaulista.turismo_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Título do evento é obrigatório")
    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(length = 200)
    private String local;

    private Float latitude;
    private Float longitude;

    @Column(name = "foto_url", length = 500)
    private String fotoUrl;

    private Boolean gratuito = false;

    // Relacionamento com Usuario (ORGANIZA)
    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Usuario organizador;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public Float getLatitude() { return latitude; }
    public void setLatitude(Float latitude) { this.latitude = latitude; }

    public Float getLongitude() { return longitude; }
    public void setLongitude(Float longitude) { this.longitude = longitude; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public Boolean getGratuito() { return gratuito; }
    public void setGratuito(Boolean gratuito) { this.gratuito = gratuito; }

    public Usuario getOrganizador() { return organizador; }
    public void setOrganizador(Usuario organizador) { this.organizador = organizador; }
}
