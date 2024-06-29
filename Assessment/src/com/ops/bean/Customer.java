package com.ops.bean;

public class Customer {

	int customerid;
	String customername;
	String griev;
	String descri;

		public Customer() {
		super();
		
	}

		public Customer(int customerid, String customername, String griev, String descri) {
			super();
			this.customerid = customerid;
			this.customername = customername;
			this.griev = griev;
			this.descri = descri;
		}

		public int getCustomerid() {
			return customerid;
		}

		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}

		public String getCustomername() {
			return customername;
		}

		public void setCustomername(String customername) {
			this.customername = customername;
		}

		public String getGriev() {
			return griev;
		}

		public void setGriev(String griev) {
			this.griev = griev;
		}

		public String getDescri() {
			return descri;
		}

		public void setDescri(String descri) {
			this.descri = descri;
		}

		

}
