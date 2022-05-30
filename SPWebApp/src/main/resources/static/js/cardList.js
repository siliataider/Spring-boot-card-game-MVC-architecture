function handleSubmit(){

    let form = document.getElementById("formCard");
    let data = new FormData(form);

    const value = Object.fromEntries(data.entries());

    console.log({value});

    sendCard(value);


}
function sendCard(data){

    const POST_URL="localhost:/8080/buy"; 
    let context =   {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json',
                        },
                        body: JSON.stringify(data),
                    };
        
    fetch(POST_URL,context)
            .then(response => callback(response))
            .catch(error => err_callback(error));
}

function callback(response){
    console.log(response.value);
}

function err_callback(error){
    console.log(error);
}


let template = document.querySelector("#row");

for(const card of cardList){
    let clone = document.importNode(template.content, true);

    newContent= clone.firstElementChild.innerHTML
                .replace(/{{family_src}}/g, card.family_src)
                .replace(/{{family_name}}/g, card.family_name)
                .replace(/{{img_src}}/g, card.img_src)
                .replace(/{{name}}/g, card.name)
                .replace(/{{description}}/g, card.description)
                .replace(/{{hp}}/g, card.hp)
                .replace(/{{energy}}/g, card.energy)
                .replace(/{{attack}}/g, card.attack)
                .replace(/{{defense}}/g, card.defense)
                .replace(/{{price}}/g, card.price);
    clone.firstElementChild.innerHTML= newContent;

    let cardContainer= document.querySelector("#tableContent");
    cardContainer.appendChild(clone);
}





