var userId = localStorage.getItem('user_id');
if(userId === null){
    window.location.href = "index"
}

function enviarFormulario() {
    // Obtenha os dados do formulário
    var idCourse = document.getElementById("idCourse").value;
    var idStudent = document.getElementById("idStudent").value;
    var idProfessor = document.getElementById("idProfessor").value;
    var initDate = document.getElementById("initDate").value;
    var endDate = document.getElementById("endDate").value;
    var grade = document.getElementById("grade").value;
    var classroom = document.getElementById("classroom").value;
    var institution = document.getElementById("institution").value;
    let _data = {
        "idCourse": idCourse,
        "idStudent": idStudent,
        "idProfessor": idProfessor,
        "initDate": initDate,
        "endDate": endDate,
        "grade": grade,
        "classroom":classroom,
        "institution":institution
    }

    try {
        const response = fetch("http://localhost:8080/Offering/", {
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
        const response = await fetch("http://localhost:8080/Offering/", {
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

            var nuspStudentCell = row.insertCell();
            nuspStudentCell.textContent = line.student.idStudent;

            var nuspProfessorCell = row.insertCell();
            nuspProfessorCell.textContent = line.professor.idProfessor;

            var codCourseCell = row.insertCell();
            codCourseCell.textContent = line.course.codCourse;

            var nameCourseCell = row.insertCell();
            nameCourseCell.textContent = line.course.name;

            var dateInitCell = row.insertCell();
            dateInitCell.textContent = line.initDate;

            var dateEndCell = row.insertCell();
            dateEndCell.textContent = line.endDate;

            var classrommCell = row.insertCell();
            classrommCell.textContent = line.classroom;

            var gradeCell = row.insertCell();
            gradeCell.textContent = line.grade;

        });

    }
})
    .catch(error => {
        console.log(error);
    });