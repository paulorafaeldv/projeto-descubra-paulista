package com.projetoDescubraPaulista.turismo_api.models;

import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O usuário é obrigatório")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull(message = "O tipo da entidade é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_entidade", nullable = false, length = 30)
    private TipoEntidade tipoEntidade;

    @NotNull(message = "O id da entidade favoritada é obrigatório")
    @Column(name = "entidade_id", nullable = false)
    private Integer entidadeId;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public TipoEntidade getTipoEntidade() { return tipoEntidade; }
    public void setTipoEntidade(TipoEntidade tipoEntidade) { this.tipoEntidade = tipoEntidade; }

    public Integer getEntidadeId() { return entidadeId; }
    public void setEntidadeId(Integer entidadeId) { this.entidadeId = entidadeId; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}