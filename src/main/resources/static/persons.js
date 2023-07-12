var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

function enviarFormulario() {
    // Obtenha os dados do formulário
    var nusp = document.getElementById("nusp").value;
    var nome = document.getElementById("nome").value;
    var documento = document.getElementById("documento").value;
    var institution = document.getElementById("institution").value;
    var email = document.getElementById("email").value;
    var birth = document.getElementById("birth").value;
    let _data = {
        "nusp": nusp,
        "name": nome,
        "document": documento,
        "institution": institution,
        "email": email,
        "birth": birth
    }

    try {
        const response = fetch("http://localhost:8080/person/", {
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
        const response = await fetch("http://localhost:8080/person/", {
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
                nuspCell.textContent = line.nusp;

                var nameCell = row.insertCell();
                nameCell.textContent = line.name;

                var documentCell = row.insertCell();
                documentCell.textContent = line.document;

                var institutionCell = row.insertCell();
                institutionCell.textContent = line.institution;

                var mailCell = row.insertCell();
                mailCell.textContent = line.email;

                var birthCell = row.insertCell();
                birthCell.textContent = line.birth;
            });

        }
    })
        .catch(error => {
            console.log(error);
    });