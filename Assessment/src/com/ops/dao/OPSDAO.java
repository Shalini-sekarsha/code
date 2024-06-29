package com.ops.dao;


	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.*;
	import java.sql.SQLException;
import com.ops.bean.Customer;
import com.ops.util.OPSDBUtil;
	import java.sql.ResultSetMetaData;
	public class OPSDAO {	
	 public int viewAll() throws SQLException
	 {
		 Connection con1=OPSDBUtil.getConnection();
		 int count=0;
		 String sql="Select * from customer_tbl";
		 PreparedStatement ps=con1.prepareStatement(sql);
		 ResultSetMetaData rms= ps.getMetaData();
		 ResultSet rs=ps.executeQuery();
		 System.out.println(rms.getColumnName(1)+" " +rms.getColumnName(2)+" "+rms.getColumnName(3)+" "+rms.getColumnName(4));
		 while(rs.next()) {
			 System.out.println(rs.getInt(1)+"" +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		count++;
		}
		 return count;
	 }
	 public int doInsert(Customer e) throws SQLException
	 {
		 Connection con1=OPSDBUtil.getConnection();
		 String sql="insert into customer_tbl values(?,?,?,?)";
		 PreparedStatement ps=con1.prepareStatement(sql);
		 ps.setInt(1, e.getCustomerid());
		 ps.setString(2, e.getCustomername());
		 ps.setString(3, e.getGriev());
		 ps.setString(4, e.getDescri());
		 int n = ps.executeUpdate();
		 con1.close();
		 return n;	 
	 }
	 public int doUpdate(Customer e) throws SQLException
	 {
		 Connection con1=OPSDBUtil.getConnection();
		 String sql="update customer_tbl set customername=?,griev=?,descri=? where customerid=?";
		 PreparedStatement ps=con1.prepareStatement(sql);
		
		 ps.setString(1, e.getCustomername());
		 ps.setString(2, e.getGriev());
		 ps.setString(3, e.getDescri());
		 ps.setInt(4, e.getCustomerid());
		 int n = ps.executeUpdate();
		 con1.close();
		 return n;	 
	 }
	 public int doDelete(int id) throws SQLException
	 {
		 Connection con1=OPSDBUtil.getConnection();
		 String sql="delete from customer_tbl where customerid=?";
		 PreparedStatement ps=con1.prepareStatement(sql);
		 ps.setInt(1, id);
		 int n = ps.executeUpdate();
		 con1.close();
		 return n;	 
	 } 
	 public int doFindbyId(int id) throws SQLException
	 {
		 int count=0;
		 Connection con1=OPSDBUtil.getConnection();
		 String sql="select * from customer_tbl where customerid=?";
		 PreparedStatement ps=con1.prepareStatement(sql);
		 ps.setInt(1, id);
		 ResultSetMetaData rms= ps.getMetaData();
		 ResultSet rs=ps.executeQuery();
		 System.out.println(rms.getColumnName(1)+" " +rms.getColumnName(2)+" "+rms.getColumnName(3)+" "+rms.getColumnName(4));
		 while(rs.next()) {
			 System.out.println(rs.getInt(1)+"" +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		count++;
		}
		 con1.close(); 
		 return count;
	 } 
}
