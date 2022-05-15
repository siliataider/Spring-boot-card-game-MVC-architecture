
function newLocation(){
	window.location.replace("http://127.0.0.1:8080/welcome.html");
	console.log(location);
}

function POSTHTML(){
	newLocation();
	const GET_CHUCK_URL="https://localhost:8080/addUser";
	const data = getInput();
	let context = {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(data)
    };
    
    fetch(GET_CHUCK_URL, context)
        .then(response => callback(response))
        .catch(error => err_callback(error));
}

function callback(response){
    let mess = "il y a eu une erreur leur du fetch";
    if (response.status == 200){
        mess = "success"
    }
    return mess;
}
