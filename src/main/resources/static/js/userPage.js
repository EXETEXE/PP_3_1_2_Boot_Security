const getUserData = () => {
    fetch('http://localhost:8080/authenticated')
        .then(response => {
            response.json().then(user => {

                let roles = "";
                for (const role of user.roles) {
                    roles += role.name + " ";
                }
                document.querySelector("#userId").textContent = user.id;
                document.querySelector("#userName").textContent = user.name;
                document.querySelector("#userLastName").textContent = user.lastName;
                document.querySelector("#userAge").textContent = user.age;
                document.querySelector("#userEmail").textContent = user.email;
                document.querySelector("#userRoles").textContent = roles;
            })
        })
}
getUserData()