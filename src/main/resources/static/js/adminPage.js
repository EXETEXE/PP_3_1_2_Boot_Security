document.querySelector(".ggg").innerText = "bbbbbbbbbbbbbbbb"


const userTable = async () => {

    let tableData = ""
    const data = await fetch("http://localhost:8080/api/admin/users")
        .then(response => response.json()).then(data => {
            return data
        })

    data.forEach(el => {
        tableData += "<tr>"
        tableData += "<td>" + el.id + "</td>"
        tableData += "<td>" + el.name + "</td>"
        tableData += "<td>" + el.lastName + "</td>"
        tableData += "<td>" + el.age + "</td>"
        tableData += "<td>" + el.email + "</td>"

        let userRoles = ""

        for (const role of el.roles) {
            userRoles += role.name + " "

        }
        tableData += "<td>" + userRoles + "</td>"

        tableData += "<td><button type=\"button\" data-id=" + el.id + " class=\"btn btn-info\" id='editButton' data-toggle=\"modal\" data-bs-target=\"#userUpdateModal\">Edit</button></td>"
        tableData += "<td> <button type=\"submit\" data-id=" + el.id + " class=\"btn btn-danger\" id='deleteButton' data-toggle=\"modal\" data-bs-target=\"#deleteModal\">Delete</button></td>"
    })

    document.querySelector(".test1").innerHTML = tableData
}

userTable()


document.querySelector(`#addUserSubmitButton`).onclick = addUserInputData;

function addUserInputData() {


    let itemList = document.getElementById("rolesSelectorInput")

    let roleArray = [];

    let collection = itemList.selectedOptions;

    for (let a of collection) {

        roleArray.push(a.value)
    }

    let userDTOBody = {
        user: {
            name: document.querySelector(`#nameInput`).value,
            lastName: document.querySelector(`#lastNameInput`).value,
            age: document.querySelector(`#ageInput`).value,
            email: document.querySelector(`#emailInput`).value,
            password: document.querySelector(`#passwordInput`).value
        },
        rolesId: roleArray
    }


    fetch("http://localhost:8080/api/admin", {
        method: `POST`,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userDTOBody)
    }).then(response => {
        return response
    })
}




