package com.shutl.controller;

import com.shutl.model.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuoteController
{

	@RequestMapping(value = "/quote", method = RequestMethod.POST)
	public @ResponseBody Quote quote(@RequestBody Quote quote)
	{
		Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36)) / 100000000);

		try
		{
			switch (quote.getVehicle())
			{
				case "bicycle":
					price = Math.round(price.intValue() * 1.1);
					break;
				case "motorbike":
					price = Math.round(price.intValue() * 1.15);
					break;
				case "parcel_car":
					price = Math.round(price.intValue() * 1.2);
					break;
				case "small_van":
					price = Math.round(price.intValue() * 1.3);
					break;
				case "large_van":
					price = Math.round(price.intValue() * 1.4);
					break;
			}
		}
		catch (NullPointerException e)
		{
			return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), price);
		}

		return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), price, quote.getVehicle());
	}
}
