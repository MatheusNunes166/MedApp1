package com.MedApp.historico2.Controller;

import com.MedApp.historico2.Model.M_Resposta;
import com.MedApp.historico2.Service.S_Paciente;
import com.MedApp.historico2.Service.S_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Paciente {
    @GetMapping("/edit/Historico")
    public String getEditHistorico(HttpServletRequest request,
                                 HttpSession session,
                                 Model model) {
        if (request.getHeader("Referer") != null) {
            Object paciente = session.getAttribute("paciente");
            model.addAttribute("paciente", paciente);
            return "/usuario/pv/edit_Historico";
        }
        return "redirect:/";
    }
    @PostMapping("/edit/Historico")
    @ResponseBody
    public M_Resposta postEditHistorico(@RequestParam("doencas") String doencas,
                                      @RequestParam("alergias") String alergias,
                                      @RequestParam("uso_medicamentos") String uso_medicamentos,
                                        HttpSession session

    ) {
        return S_Paciente.insertPaciente(doencas, alergias,uso_medicamentos,session.getAttribute("paciente"));
    }
}
