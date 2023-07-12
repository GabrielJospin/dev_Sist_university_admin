var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

function enviarFormulario() {
    // Obtenha os dados do formulário
    var personId = document.getElementById("personId").value;
    var specialization = document.getElementById("specialization").value;
    var posgraduate = document.getElementById("posgraduate").checked;
    let _data = {
        "id_person": personId,
        "specialization": specialization,
        "is_postgraduate_student": posgraduate
    }
    console.log(_data)

    try {
        const response = fetch("http://localhost:8080/researchers/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "person_id": userId
            },
            body: JSON.stringify(_data)
        });
        if (!response.ok) {
            throw new Error('Erro na requisição: ', response.status);
        }

    }catch (error){
        console.error('Erro ao obter resposta da requisição ',error)
    }

    // Feche o modal
    $('#myModal').modal('hide');
}

async function obterRespostasDaRequisicao() {
    try {
        const response = await fetch("http://localhost:8080/researchers/", {
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

            var idResearcherCell = row.insertCell();
            idResearcherCell.textContent = line.idResearcher;

            var specializationCell = row.insertCell();
            specializationCell.textContent = line.specialization;

            var posgraduateCell = row.insertCell();
            posgraduateCell.textContent = "Não"
            if(line.postgraduateStudent === true){
                posgraduateCell.textContent = "Sim"
            }


        });

    }
})
    .catch(error => {
        console.log(error);
    });