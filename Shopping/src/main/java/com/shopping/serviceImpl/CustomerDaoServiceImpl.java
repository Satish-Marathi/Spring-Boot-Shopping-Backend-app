package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Customer;
import com.shopping.service.CustomerDaoService;
import com.shopping.util.DButil;

@Service
public class CustomerDaoServiceImpl implements CustomerDaoService {
	
	ArrayList<Customer> customerList=new ArrayList<Customer>();

	private PreparedStatement stmt;
	
	private static Connection connection=null;
	
	public CustomerDaoServiceImpl() {
		try {
			connection =DButil.getConnection();
			System.out.println("connection: "+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getCustomer() {
		String getCustomerQuery="SELECT * FROM customer;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(getCustomerQuery);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Customer cust=new Customer();
				cust.setCustomerId(rs.getInt(1));
				cust.setCustomerName(rs.getString(2));
				cust.setGender(rs.getString(3));
				cust.setContactNo(rs.getLong(4));
				cust.setEmail(rs.getString(5));
				cust.setAddress(rs.getString(6));
				cust.setPincode(rs.getInt(7));
				cust.setUsername(rs.getString(8));
				cust.setPassword(rs.getString(9));
				customerList.add(cust);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return customerList;
	}

	@Override
	public void addCustomer(Customer customer) {

		int customerid=customer.getCustomerId();
		String customerName=customer.getCustomerName();
		String Gender=customer.getGender();
		long contactno=customer.getContactNo();
		String email=customer.getEmail();
		String address=customer.getAddress();
		int pincode=customer.getPincode();
		String username=customer.getUsername();
		String password=customer.getPassword();
		
		String insertQuery="INSERT INTO CUSTOMER VALUE("+customerid+",'"+customerName+"','"+Gender+"',"+contactno+",'"+email+"','"+address+"',"+pincode+")";
		
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Customer addded Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean customerLoginValidation(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCustomer(Customer customer) {
		int customerid=customer.getCustomerId();
		String customerName=customer.getCustomerName();
		String Gender=customer.getGender();
		long contactno=customer.getContactNo();
		String email=customer.getEmail();
		String address=customer.getAddress();
		int pincode=customer.getPincode();
		String username=customer.getUsername();
		String password=customer.getPassword();
		
		String updateQuery="UPDATE customer SET customerName='"+customerName+"',Gender='"+Gender+"',contactNo="+contactno+",email='"+email+"',address='"+address+"',pincode="+pincode+",username='"+username+"',password='"+password+"' WHERE customerid="+customerid+"";          
		

		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Customer addded Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeCustomer(Customer customer) {
		String removeQuery="DELETE FROM customer WHERE userid=userid";
		try {
			stmt=connection.prepareStatement(removeQuery);
			stmt.executeUpdate();
			System.out.println("Customer Removed Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
