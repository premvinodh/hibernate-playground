package com.playgroup.my.hibernate_training.aam.inheritance.singletablestrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Regular")
public class RegularCustomer extends Customer {

	private int discountPricing;

	public int getDiscountPricing() {
		return discountPricing;
	}

	public void setDiscountPricing(int discountPricing) {
		this.discountPricing = discountPricing;
	}
}
