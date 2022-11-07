// document.querySelector(`#testId1`).onclick = myClick;
//
// function myClick(){
//     console.log(`work`);
//
//     let name = document.querySelector(`#name`).value;
//
//     let body = {
//         user : {
//             name: name
//
//         }
//
//     }
//     console.log(name)
//
//     console.log(body)
// }

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

    console.log(userDTOBody)

    return fetch("http://localhost:8080/api/admin", {
        method: `POST`,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userDTOBody)
    })
}