package com.MedApp.historico2.Repository;

import com.MedApp.historico2.Model.M_Paciente;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Paciente extends JpaRepository <M_Paciente,Long> {
    @Modifying
    @Query("INSERT INTO M_Paciente (doencas, alergias, uso_medicamentos) VALUES (:doencas, :alergias, :uso_medicamentos)")
    void insereHistorico(@Param("doencas") String doencas, @Param("alergias") String alergias, @Param("uso_medicamentos") String uso_medicamentos);


}