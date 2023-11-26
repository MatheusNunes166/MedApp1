package com.MedApp.historico2.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class M_Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doencas;
    private String alergias;
    private String uso_medicamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getUso_medicamentos() {
        return uso_medicamentos;
    }

    public void setUso_medicamentos(String uso_medicamentos) {
        this.uso_medicamentos = uso_medicamentos;
    }
}
