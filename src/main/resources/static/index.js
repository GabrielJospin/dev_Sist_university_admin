document.getElementById("login").addEventListener("submit", function(event) {
    event.preventDefault();

    var login = document.getElementById("email").value;
    var pass = document.getElementById("pass").value;

    var data = {
        login: login,
        pass: pass
    };

    fetch("http://localhost:8080/auth/", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(function(response) {
            if (response.ok) {
                var obj = response.json();
                localStorage.setItem("userId", obj.valueOf("id"));
                localStorage.setItem("userName", obj.valueOf("userName"));
                window.location.href = "home"
                return response.json();
            }
            throw new Error("Erro na requisição.");
        })
        .then(function(data) {
            // Manipula a resposta da requisição
            console.log(data);
        })
        .catch(function(error) {
            // Manipula erros ocorridos durante a requisição
            console.log(error);
        });
});