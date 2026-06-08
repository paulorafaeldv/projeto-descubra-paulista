package com.projetoDescubraPaulista.turismo_api.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roteiro")
public class Roteiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Título do roteiro é obrigatório")
    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(length = 50)
    private String tipo;

    @Column(name = "duracao_horas")
    private Integer duracaoHoras;

    @Column(name = "nivel_dificuldade", length = 20)
    private String nivelDificuldade;

    @ManyToOne
    @JoinColumn(name = "criado_por")
    private Usuario criadoPor;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    // Relacionamento CONTÉM: roteiro tem vários pontos (na ordem definida)
    @OneToMany(mappedBy = "roteiro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RoteiroPonto> pontos = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.criadoEm = LocalDateTime.now();
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getDuracaoHoras() { return duracaoHoras; }
    public void setDuracaoHoras(Integer duracaoHoras) { this.duracaoHoras = duracaoHoras; }

    public String getNivelDificuldade() { return nivelDificuldade; }
    public void setNivelDificuldade(String nivelDificuldade) { this.nivelDificuldade = nivelDificuldade; }

    public Usuario getCriadoPor() { return criadoPor; }
    public void setCriadoPor(Usuario criadoPor) { this.criadoPor = criadoPor; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public List<RoteiroPonto> getPontos() { return pontos; }
    public void setPontos(List<RoteiroPonto> pontos) { this.pontos = pontos; }
}
