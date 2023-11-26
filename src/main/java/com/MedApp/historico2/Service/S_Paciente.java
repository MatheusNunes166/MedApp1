package com.MedApp.historico2.Service;

import com.MedApp.historico2.Model.M_Paciente;
import com.MedApp.historico2.Model.M_Resposta;
import com.MedApp.historico2.Model.M_Usuario;
import com.MedApp.historico2.Repository.R_Paciente;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Paciente {
    private static R_Paciente r_paciente;

    public S_Paciente(R_Paciente r_paciente) {
        this.r_paciente = r_paciente;
    }
    public static M_Resposta insertPaciente(String doencas,String alergias,String uso_medicamentos,Object paciente){
        boolean podeEditar = false;
        String mensagem = "";

        if (!S_Generico.textoEstaVazio(doencas)) {
            podeEditar = true;
            mensagem += "O nome precisa ser preenchido!";
        }
        if (S_Generico.textoEstaVazio(alergias)) {
            podeEditar = true;
            mensagem += "E-mail inválido!";
        }
        if (S_Generico.textoEstaVazio(uso_medicamentos)) {
            podeEditar = true;
            mensagem += "A nova senha e a confirmação de senha precisam ser iguais!";
        }


        if(podeEditar){
            M_Paciente m_paciente = new M_Paciente();
            m_paciente.setDoencas(doencas);
            m_paciente.setAlergias(alergias);
            m_paciente.setUso_medicamentos(uso_medicamentos);
            try {
                r_paciente.save(m_paciente);
                mensagem += "Perfil atualizado com sucesso";
            }catch (DataIntegrityViolationException e){
                podeEditar = false;
                mensagem += "Falha ao tentar atualizar o cadastro: "+ e.getMessage();
            }
        }
        return new M_Resposta(podeEditar,mensagem);
    }
}
