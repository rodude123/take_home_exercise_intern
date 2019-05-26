package com.shutl.model;

public class Quote
{
	private String pickupPostcode;
	private String deliveryPostcode;
	private Long price;
	private String vehicle;

	public Quote()
	{
		this("Default pick up postcode", "Default delivery postcode");
	}

	public Quote(String pickupPostcode, String deliveryPostcode)
	{
		this.pickupPostcode = pickupPostcode;
		this.deliveryPostcode = deliveryPostcode;
	}
	public Quote(String pickupPostcode, String deliveryPostcode, Long price)
	{
		this.pickupPostcode = pickupPostcode;
		this.deliveryPostcode = deliveryPostcode;
		this.price = price;
	}

	public Quote(String pickupPostcode, String deliveryPostcode, String vehicle)
	{
		this.pickupPostcode = pickupPostcode;
		this.deliveryPostcode = deliveryPostcode;
		this.vehicle = vehicle;
	}

	public Quote(String pickupPostcode, String deliveryPostcode, Long price, String vehicle)
	{
		this.pickupPostcode = pickupPostcode;
		this.deliveryPostcode = deliveryPostcode;
		this.price = price;
		this.vehicle = vehicle;
	}



	public String getPickupPostcode()
	{
		return pickupPostcode;
	}

	public void setPickupPostcode(String pickupPostcode)
	{
		this.pickupPostcode = pickupPostcode;
	}

	public String getDeliveryPostcode()
	{
		return deliveryPostcode;
	}

	public void setDeliveryPostcode(String deliveryPostcode)
	{
		this.deliveryPostcode = deliveryPostcode;
	}

	public Long getPrice()
	{
		return price;
	}

	public void setPrice(Long price)
	{
		this.price = price;
	}

	public String getVehicle()
	{
		return vehicle;
	}

	public void setVehicle(String vehicle)
	{
		this.vehicle = vehicle;
	}
}
