package com.simbaazar.bean;

public class AddressBean {

	private int address_id;
	
	private String addressLineOne;
	
	private String addressLineTwo;
	
	private long pincode;

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLineOne == null) ? 0 : addressLineOne.hashCode());
		result = prime * result + ((addressLineTwo == null) ? 0 : addressLineTwo.hashCode());
		result = prime * result + address_id;
		result = prime * result + (int) (pincode ^ (pincode >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBean other = (AddressBean) obj;
		if (addressLineOne == null) {
			if (other.addressLineOne != null)
				return false;
		} else if (!addressLineOne.equals(other.addressLineOne))
			return false;
		if (addressLineTwo == null) {
			if (other.addressLineTwo != null)
				return false;
		} else if (!addressLineTwo.equals(other.addressLineTwo))
			return false;
		if (address_id != other.address_id)
			return false;
		if (pincode != other.pincode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressBean [address_id=" + address_id + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", pincode=" + pincode + "]";
	}
	

	
	
}
