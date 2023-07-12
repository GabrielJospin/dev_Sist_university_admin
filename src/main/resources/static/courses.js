var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

function enviarFormulario() {
    // Obtenha os dados do formulário
    var codeCourse = document.getElementById("codeCourse").value;
    var nome = document.getElementById("nome").value;
    var description = document.getElementById("description").value;
    var menu = document.getElementById("menu").value;
    var institution = document.getElementById("institution").value;
    var creation = document.getElementById("creation").value;
    let _data = {
        "cod_Course": codeCourse,
        "name": nome,
        "description": description,
        "menu": menu,
        "institution": institution,
        "creation": creation
    }

    try {
        const response = fetch("http://localhost:8080/course/", {
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
        const response = await fetch("http://localhost:8080/course/", {
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

            var codeCurs = row.insertCell();
            codeCurs.textContent = line.codCourse;

            var nameCell = row.insertCell();
            nameCell.textContent = line.name;

            var descriptionCell = row.insertCell();
            descriptionCell.textContent = line.description;

            var menuCell = row.insertCell();
            menuCell.textContent = line.menu;

            var institutionCell = row.insertCell();
            institutionCell.textContent = line.institution;

            var creationCell = row.insertCell();
            creationCell.textContent = line.creation;


        });

    }
})
    .catch(error => {
        console.log(error);
    });