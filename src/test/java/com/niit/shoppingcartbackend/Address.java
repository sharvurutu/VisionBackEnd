package com.niit.shoppingcartbackend;

import java.util.Scanner;

public class Address {
	public static void main(String[] args) {
		
	
	
	Scanner sc = new Scanner(System.in);
	String address="";
	System.out.println("Enter Address Line1");
	String address1=sc.nextLine();
	System.out.println("Enter Address Line2");
	String address2=sc.nextLine();
	System.out.println("Enter City");
	String city=sc.nextLine();
	System.out.println("Enter State");
	String state=sc.nextLine();
	System.out.println("Enter Pincode");
	String pincode=sc.nextLine();
	
	System.out.println("Full Address is :- ");
	
	
	address+= address1+" "+address2+" "+city+" "+state+" "+pincode;
	
	System.out.println(address);

}
}