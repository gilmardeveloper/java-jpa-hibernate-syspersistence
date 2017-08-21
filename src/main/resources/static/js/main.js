
 $(() => {

    $(".adicionar-valor").click(servicoAjax);
    $(".alterar-valor").click(precoAjaxAlterar);
    $(".alterar-servico").click(servicoAjaxAlterar);
    $('#id-valor-salvar').mask();
    $('#modal-valor-novo-alterar').mask();

});

function servicoAjax() {
    event.preventDefault();
    var link = $(this).attr('href');

    $.get(link, (data, status) => {

        if (status == "success") {
            abrirModalValor(data);
        }
    });

};

function abrirModalValor(data) {
    console.log(data);
    var servico = data;
    $("#modal-valor-servico-id").val(servico.id);
    $("#modal-valor-servico-nome").text(servico.nome);
    $("#modal-valor").modal('show');
};

function modalRemover(id){
	$("#modal-deletar-preco-id").val(id);
	$("#modal-deletar-preco").modal('show');	
};

function precoAjaxAlterar(){
    event.preventDefault();
    var link = $(this).attr('href');

    $.get(link, (data, status) => {

        if (status == "success") {
            abrirModalValorAlterar(data);
        }
    });
};

function abrirModalValorAlterar(data) {
    console.log(data);
    var preco = data;
    $("#modal-valor-alterar-id").val(preco.id);
    $("#modal-valor-alterar-servico").val(preco.servico.id);
    $("#modal-valor-formatado-alterar").val(preco.valor);
    $("#modal-valor-tipo-alterar").val(preco.tipo);
    $("#modal-valor-alterar").modal('show');
};

function modalServicoRemover(id){
	$("#modal-deletar-servico-id").val(id);
	$("#modal-deletar-servico").modal('show');	
};

function servicoAjaxAlterar(){
    event.preventDefault();
    var link = $(this).attr('href');

    $.get(link, (data, status) => {

        if (status == "success") {
            abrirModalServicoAlterar(data);
        }
    });
};

function abrirModalServicoAlterar(data) {
    console.log(data);
    var servico = data;
    $("#modal-servico-alterar-id").val(servico.id);
    $("#modal-servico-alterar-empresa").val(servico.empresa.id);
    $("#modal-servico-alterar-descricao").val(servico.descricao);
    $("#modal-servico-alterar-nome").val(servico.nome);
    $("#modal-servico-alterar").modal('show');
};