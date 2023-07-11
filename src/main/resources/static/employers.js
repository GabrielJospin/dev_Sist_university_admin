var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

function formatarMoeda(valor) {
    const valorEmReais = (valor).toLocaleString('pt-BR', {
        style: 'currency',
        currency: 'BRL',
    });

    return valorEmReais;
}

async function obterRespostasDaRequisicao() {
    try {
        const response = await fetch("http://localhost:8080/employer/", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "person_id": userId
            }
        });
        if (!response.ok) {
            throw new Error('Erro na requisição: ', response.status);
        }

        const resposeBody = await response.text();
        console.log(resposeBody);
        return JSON.parse(resposeBody);
    }catch (error){
        console.error('Erro ao obter resposta da requisição ',error)
        return [];
    }
}

obterRespostasDaRequisicao().then(data =>{
    console.log(data)
    if(data === null || Object.keys(data).length === 0) {
        console.log(data)
    } else {
        var tableBody = document.getElementById('personTableBody');

        tableBody.innerHTML = '';

        data.forEach(function(line) {
            var row = tableBody.insertRow();

            var idEmployerCell = row.insertCell();
            idEmployerCell.textContent = line.idEmployer;

            var functionCell = row.insertCell();
            functionCell.textContent = line.function;

            var salaryCell = row.insertCell();
            salaryCell.textContent = formatarMoeda(line.salary);


        });

    }
})
    .catch(error => {
        console.log(error);
    });