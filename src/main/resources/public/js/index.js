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
});