var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

async function obterRespostasDaRequisicao() {
    try {
        const response = await fetch("http://localhost:8080/professor/", {
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

            var idProfessorCell = row.insertCell();
            idProfessorCell.textContent = line.idProfessor;

            var specializationStudentCell = row.insertCell();
            specializationStudentCell.textContent = line.specialization;

            var LevelCell = row.insertCell();
            LevelCell.textContent = line.levelOfEducation;

            var almaMatterCell = row.insertCell();
            almaMatterCell.textContent = line.almaMatter;

            var siteCell = row.insertCell();
            const linkElement = document.createElement('a');
            linkElement.href = "https://" + line.institutionalWebsite;
            linkElement.textContent = 'Link';
            siteCell.appendChild(linkElement);

        });

    }
})
    .catch(error => {
        console.log(error);
    });