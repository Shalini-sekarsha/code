package com.ops.main;
import java.util.Scanner;
import java.sql.SQLException;
import com.ops.dao.OPSDAO;
import com.ops.bean.Customer;
	public class OPSMain {
	static Scanner sc=new Scanner(System.in);	
	public static int displayMenu()
	{
		int choice=0;
		System.out.println("------------MENU------------");
		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.ViewAll");
		System.out.println("4.Update");
		System.out.println("5.Find by ID");
		System.out.println("6.Exit");
		choice=sc.nextInt();
		return choice;

	}
	public static Customer insert()
	{
		System.out.println("Enter the Customerid,Name,griev,descri");
		return(new Customer(sc.nextInt(),sc.next(),sc.next(),sc.next()));
	}
	public static Customer update()
	{
		System.out.println("Enter the customerid,Name,griev,descri for u"
				+ "update");
		return(new Customer(sc.nextInt(),sc.next(),sc.next(),sc.next()));
	}
	public static void main(String s[]) throws SQLException
	{
		OPSDAO dao=new OPSDAO();
		String ch;
		int n,id = 0;
		do {
		switch(displayMenu())
		{
		case 1:
			Customer e=insert();
			 n=dao.doInsert(e);
			if(n>0)
			{
				System.out.println("Record Inserted Successfully");
			}
			else
			{
				System.out.println("Record Insertion Failure");
			}
			break;
		case 2:
			System.out.println("Enter the id to be deleted");
			 id=sc.nextInt();
			n=dao.doDelete(id);
			if(n>0)
			{
			System.out.println("Record deleted successfully");	
			}
			else
			{
				System.out.println("Record deletion failed");
			}
			break;
		case 3:
			n=dao.viewAll();
			if(n<=0)
			{
				System.out.println("No records Found");
			}
			break;
		case 4:
			Customer e1=update();
			 n=dao.doUpdate(e1);
			if(n>0)
			{
				System.out.println("Record Updated Successfully");
			}
			else
			{
				System.out.println("Record Updation Failed");
			}
			break;
		case 5:
			System.out.println("Enter the id to be found");
			id=sc.nextInt();
			n=dao.doFindbyId(id);
			if(n<=0)
			{
				System.out.println("No such record");
			}	
			break;
		case 6:
			System.exit(0);
			break;	
		}
			System.out.println("Do u wish to continue:(yes/no)");
			ch=sc.next();
			}
		while(ch.equalsIgnoreCase("yes"));
		}
		}

