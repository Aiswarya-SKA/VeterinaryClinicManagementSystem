package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Animal;
import com.canddella.entity.Bill;
import com.canddella.entity.Owner;
import com.canddella.entity.Visits;


public class BillDAOImpl implements BillDAO {

	@Override
	public int save(Bill bill) {
		// TODO Auto-generated method stub
		

			String insertSQL = "insert into bill(visit_id,total_amount,payment_mode,payment_date)"
					+ " values(?,?,?,?)";
			PreparedStatement preparedStatement = null;
			Connection connection = null;

			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();

				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setInt(1, bill.getVisits().getVisitId());
				preparedStatement.setInt(2, bill.getTotalAmount());
				preparedStatement.setString(3, bill.getPaymentMode());
				preparedStatement.setString(4, bill.getPaymentDate());
				int row = preparedStatement.executeUpdate();
				return row;

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return 0;
		}

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		List<Bill> billList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bill";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int billId = resultSet.getInt(1);
				int visitId = resultSet.getInt(2);
				
				int totalAmount = resultSet.getInt(3);
				String paymentMode = resultSet.getString(4);
				String paymentDate = resultSet.getString(5);
				
				
				Visits visits=new Visits();
				visits.setVisitId(visitId);
                Bill bill = new Bill(billId,visits,totalAmount,paymentMode,paymentDate);
				billList.add(bill);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		return billList;
		
		
	}

	@Override
	public int update(Bill bill) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update bill set visit_id=?,total_amount=?,payment_mode=?,payment_date=? where bill_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, bill.getVisits().getVisitId());
			preparedStatement.setInt(2, bill.getTotalAmount());
			preparedStatement.setString(3,bill.getPaymentMode());
			preparedStatement.setString(4, bill.getPaymentDate());
			preparedStatement.setInt(5, bill.getBillId());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		
		
		return 0;
	}

	@Override
	public int delete(Bill bill) {
		// TODO Auto-generated method stub
		
		String deleteSQL = "delete from bill where bill_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,bill.getBillId());
			int row = preparedStatement.executeUpdate();
			return row;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Bill billId(int id) {
		// TODO Auto-generated method stub
		
		Bill bill =null;
//	    
		String searchSQL = "select * from bill where bill_id="+id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement = connection.prepareStatement(searchSQL);
			
			

			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				int billId = resultSet.getInt(1);
				int visitId = resultSet.getInt(2);
				int totalAmount = resultSet.getInt(3);
				String paymentMode = resultSet.getString(4);
				String paymentDate = resultSet.getString(5);

				Visits visits = new Visits();
				visits.setVisitId(visitId);
			
			
				bill = new  Bill(billId,visits,totalAmount,paymentMode,paymentDate);
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
		
		return bill;
	}

	
}
