function salvarHistorico(){
    let doencas = $("#doencas").val();
    let alergias = $("#alergias").val();
    let uso_medicamentos = $("#uso_medicamentos").val();

    $.ajax({
        type: "POST",
        url: "/edit/Historico",
        data:{
            doencas:doencas,
            alergias:alergias,
            uso_medicamentos:uso_medicamentos,
        },
        success: function(data){
            if(data.sucesso){
                alertaSucesso("Historico atualizado com sucesso");
            }else{
                alert(data.mensagem);
            }
        },
        error: function(){
            alert("Deu ruim");
        }
    })
}