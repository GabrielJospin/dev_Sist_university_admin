var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

function enviarFormulario() {
    // Obtenha os dados do formulário
    var idPerson = document.getElementById("idPerson").value;
    var course = document.getElementById("course").value;
    var grade = document.getElementById("grade").value;
    let _data = {
        "id_person": idPerson,
        "course": course,
        "entry_grade": grade
    }

    try {
        const response = fetch("http://localhost:8080/student/", {
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
        const response = await fetch("http://localhost:8080/student/", {
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

            var idStudentCell = row.insertCell();
            idStudentCell.textContent = line.idStudent;

            var courseStudentCell = row.insertCell();
            courseStudentCell.textContent = line.course;

            var gradeCell = row.insertCell();
            gradeCell.textContent = line.entryGrade;

        });

    }
})
    .catch(error => {
        console.log(error);
    });