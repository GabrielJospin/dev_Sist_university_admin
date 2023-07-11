var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
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