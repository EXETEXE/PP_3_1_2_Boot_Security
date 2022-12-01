const populateHeader = () => {
    fetch('http://localhost:8080/authenticated')
        .then(response => {
            response.json().then(user => {

                let roles = "";
                for (const role of user.roles) {
                    roles += role.name + " ";
                }
                document.querySelector("#header").textContent = user.email + " with roles: " + roles;
            })
        })
}
populateHeader()