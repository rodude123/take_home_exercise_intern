/*
$("#btnSubmit").submit(e =>
{
    fetch("localhost:8080/quote",
    {
        method: "POST",
        body: JSON.stringify(`{ "pickup_postcode":   "${$("#pickup_postcode").val()}", "delivery_postcode": "${$("#delivery_postcode").val()}, "vehicle": "${$("#vehicle").val()}"}`),
    }).then(response =>
    {
        response.json(json =>
        {
            if (response.ok)
            {
                $("#priceInfo").val(`A  delivery from ${json.pickup_postcode} to ${json.delivery_postcode} using a ${json.vehicle.replace(/_/g, ' ')} will cost you £ ${json.price}.`);
            }
            else
            {
                $("#priceInfo").val(`Waiting for server response.`)
            }
        })
    });
});*/

(function(){
    function toJSONString(form){
        let obj = {};
        const elements = form.querySelectorAll("input, select, textarea");
        for (let i = 0; i < elements.length; ++i){
            const element = elements[i];
            const name = element.name;
            const value = element.value;
            if(name){
                obj[name] = value;
            }
        }
        return obj;
    }
    document.addEventListener('DOMContentLoaded', async function () {
        const form = document.getElementById('form');
        const output = document.getElementById('priceInfo');
        form.addEventListener('submit', async function (e){
            e.preventDefault();
            const json = toJSONString(this);
            const xhr = new XMLHttpRequest();
            const url = 'http://localhost:8080/quote';
            xhr.open('POST', url, true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify(json));
            xhr.onreadystatechange = function () {
                if(xhr.readyState == 4 && xhr.status == 200){
                    let response = JSON.parse(xhr.responseText);
                    output.innerHTML = 'A delivery from ' + response.pickupPostcode + ' to ' + response.deliveryPostcode + ' using a ' + response.vehicle.replace(/_/g, ' ') + ' will cost you £' + response.price + '.';
                } else {
                    output.innerHTML = xhr.status;
                }
            }
        }, false);
    });
})();