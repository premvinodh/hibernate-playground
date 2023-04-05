package com.playgroup.my.hibernate_training.aao.inheritance.joinedstrategy;

import javax.persistence.Entity;

@Entity
public class RegularCustomer extends Customer {

	private int discountPricing;

	public int getDiscountPricing() {
		return discountPricing;
	}

	public void setDiscountPricing(int discountPricing) {
		this.discountPricing = discountPricing;
	}
}
