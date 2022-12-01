
function getUser(id) {

    let user = {};

    const data = fetch("http://localhost:8080/api/admin/users/" + id)
        .then(response => response.json()).then(data => {
            return data
        })

    return data;

}

function showEditModal(id) {

    getUser(id).then(result => result).then(result => {
        document.querySelector("#idToUpdate").setAttribute(`placeholder`, result.id)
        document.querySelector("#nameToUpdate").setAttribute(`placeholder`, result.name)
        document.querySelector("#lastNameToUpdate").setAttribute(`placeholder`, result.lastName)
        document.querySelector("#ageToUpdate").setAttribute(`placeholder`, result.age)
        document.querySelector("#emailToUpdate").setAttribute(`placeholder`, result.email)
        document.querySelector("#passwordToUpdate").setAttribute(`placeholder`, result.password)
    });
}


document.querySelector(`#submitUserEditData`).onclick = sendUserUpdateData;


function sendUserUpdateData() {

    let itemList = document.getElementById("rolesUpdateSelectorInput")


    let roleArray = [];

    let collection = itemList.selectedOptions;

    for (let a of collection) {

        roleArray.push(a.value)
    }


    let userDTOBody = {
        user: {
            id: document.querySelector(`#idToUpdate`).placeholder,
            name: document.querySelector(`#nameToUpdate`).value,
            lastName: document.querySelector(`#lastNameToUpdate`).value,
            age: document.querySelector(`#ageToUpdate`).value,
            email: document.querySelector(`#emailToUpdate`).value,
            password: document.querySelector(`#passwordToUpdate`).value
        },
        rolesId: roleArray
    }

    fetch("http://localhost:8080/api/admin", {
        method: `PATCH`,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userDTOBody)
    }).then(response => {
        return response
    })

    cleanEditModal();
}

document.querySelector(`#closeEditModal1`).onclick = cleanEditModal;
document.querySelector(`#closeEditModal2`).onclick = cleanEditModal;

function cleanEditModal() {

    document.querySelector("#idToUpdate").setAttribute(`placeholder`, "")
    document.querySelector("#nameToUpdate").setAttribute(`placeholder`, "")
    document.querySelector("#lastNameToUpdate").setAttribute(`placeholder`, "")
    document.querySelector("#ageToUpdate").setAttribute(`placeholder`, "")
    document.querySelector("#emailToUpdate").setAttribute(`placeholder`, "")
    document.querySelector("#passwordToUpdate").setAttribute(`placeholder`, "")
}

function showDeleteModal(id) {

    getUser(id).then(result => result).then(result => {
        document.querySelector("#idToDelete").setAttribute(`placeholder`, result.id)
        document.querySelector("#nameToDelete").setAttribute(`placeholder`, result.name)
        document.querySelector("#lastNameToDelete").setAttribute(`placeholder`, result.lastName)
        document.querySelector("#ageToDelete").setAttribute(`placeholder`, result.age)
        document.querySelector("#emailToDelete").setAttribute(`placeholder`, result.email)
    });
}

document.querySelector(`#submitUserDeleteData`).onclick = sendUserDeleteData;

function sendUserDeleteData() {


    let id = document.querySelector(`#idToDelete`).placeholder;

    console.log(id)

    let test = "http://localhost:8080/api/admin/delete/" + id;

    console.log(test)


    fetch("http://localhost:8080/api/admin/delete/" + id, {
        method: `DELETE`,
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(r => r)

    cleanDeleteModal()
}

document.querySelector(`#closeDeleteModal1`).onclick = cleanDeleteModal;
document.querySelector(`#closeDeleteModal2`).onclick = cleanDeleteModal;

function cleanDeleteModal() {

    document.querySelector("#idToDelete").setAttribute(`placeholder`, "")
    document.querySelector("#nameToDelete").setAttribute(`placeholder`, "")
    document.querySelector("#lastNameToDelete").setAttribute(`placeholder`, "")
    document.querySelector("#ageToDelete").setAttribute(`placeholder`, "")
    document.querySelector("#emailToDelete").setAttribute(`placeholder`, "")
}

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

        tableData += "<td><button type=\"button\"  class=\"btn btn-info\" data-toggle=\"modal\" data-target=\"#userUpdateModal\" onclick=\"showEditModal(" + el.id + ")\">Edit</button></td>"
        tableData += "<td> <button type=\"submit\"  class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#userDeleteModal\" onclick=\"showDeleteModal(" + el.id + ")\">Delete</button></td>"
    })

    document.querySelector(".userList").innerHTML = tableData
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




