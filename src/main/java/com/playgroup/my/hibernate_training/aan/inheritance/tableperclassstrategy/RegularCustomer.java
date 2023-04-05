package com.playgroup.my.hibernate_training.aan.inheritance.tableperclassstrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Regular_Customer")
public class RegularCustomer extends Customer {

	private int discountPricing;

	public int getDiscountPricing() {
		return discountPricing;
	}

	public void setDiscountPricing(int discountPricing) {
		this.discountPricing = discountPricing;
	}
}
