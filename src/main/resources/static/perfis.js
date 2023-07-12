var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

function enviarFormulario() {
    // Obtenha os dados do formulário
    var person = document.getElementById("person").value;
    var perfil = document.getElementById("perfil").value;
    var initDate = document.getElementById("initDate").value;
    var endDate = document.getElementById("endDate").value;
    let _data = {
        "person": person,
        "profile": perfil,
        "initDate": initDate,
        "endDate": endDate
    }

    try {
        const response = fetch("http://localhost:8080/permission/", {
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
        const response = await fetch("http://localhost:8080/permission/", {
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

            var nuspCell = row.insertCell();
            nuspCell.textContent = line.person.nusp;

            var nameCell = row.insertCell();
            nameCell.textContent = line.person.name;

            var codePerfCell = row.insertCell();
            codePerfCell.textContent = line.profile.codProfile;

            var namePerfCell = row.insertCell();
            namePerfCell.textContent = line.profile.name;

            var initCell = row.insertCell();
            initCell.textContent = line.initDate;

            var endCell = row.insertCell();
            endCell.textContent = line.endDate;



        });

    }
})
    .catch(error => {
        console.log(error);
    });