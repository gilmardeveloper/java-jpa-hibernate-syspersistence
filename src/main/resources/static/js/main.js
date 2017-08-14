
        $(() => {

            $(".adicionar-valor").click(servicoAjax);

        });

        function servicoAjax(){
            event.preventDefault();
            var link = $(this).attr('href');

            $.get(link, (data, status) => {
                
                if(status == "success"){
                 abrirModalValor(data);
                }    
            });

        };


        function abrirModalValor(data){
            console.log(data);
            var servico = data;
            $("#modal-valor-servico-id").val(servico.id);
            $("#modal-valor-servico-nome").text(servico.nome);
            $("#modal-valor").modal('show');
        }
        


