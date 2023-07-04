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
        .then(response => {
            const errorElement = document.createElement('p');
            if (response.ok) {
                const contentType = response.headers.get('content-type');
                if (contentType && contentType.includes('application/json')) {
                    return response.json();
                } else {
                    return null;
                }
            }
            errorElement.textContent = 'Login Invlido. Por favor, tente novamente.';
            errorElement.style.color = 'red';
            document.body.appendChild(errorElement);
        }).then(data =>{
            if(data === null || Object.keys(data).length === 0) {
                const errorElement = document.createElement('p');
                errorElement.textContent = 'Login Invlido. Por favor, tente novamente.';
                errorElement.style.color = 'red';
                document.body.appendChild(errorElement);
        } else {
            localStorage.setItem("user_id", data.id);
            localStorage.setItem("user_name", data.name);
            window.location.href = "home"
        }
    })
        .catch(error => {
            console.log(error);
        });
});