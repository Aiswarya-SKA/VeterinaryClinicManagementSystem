package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Owner;
import com.canddella.entity.Staff;

public class StaffDAOImpl implements StaffDAO {

	@Override
	public List<Staff> findAll() {
		List<Staff> staffList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from staff";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int staffId = resultSet.getInt(1);
				String staffName = resultSet.getString(2);
				String speciality = resultSet.getString(3);
				String staffphoneNumber = resultSet.getString(4);
				String staffEmail = resultSet.getString(5);
				
				
                Staff staff = new Staff(staffId,staffName,speciality,staffphoneNumber,staffEmail);
				staffList.add(staff);
				
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

		return staffList;
		
		
	}

	@Override
	public int save(Staff staff) {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into staff(staff_id,staff_name,speciality,staff_phonenumber,staff_email) values(?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, staff.getStaffId());
		      preparedStatement.setString(2, staff.getStaffName());
		      preparedStatement.setString(3, staff.getSpeciality());
		      preparedStatement.setString(4, staff.getStaffphoneNumber());
		      preparedStatement.setString(5, staff.getStaffEmail());
		      int row=preparedStatement.executeUpdate();
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

		return 0 ;
	}

	@Override
	public int update(Staff staff) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "UPDATE staff SET staff_name=?,speciality=?,staff_phonenumber=?,staff_email=? WHERE staff_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
		      preparedStatement.setString(1, staff.getStaffName());
		      preparedStatement.setString(2, staff.getSpeciality());
		      preparedStatement.setString(3, staff.getStaffphoneNumber());
		      preparedStatement.setString(4, staff.getStaffEmail());
		      preparedStatement.setInt(5, staff.getStaffId());
		      int row=preparedStatement.executeUpdate();
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
	public int delete(Staff staff) {
		// TODO Auto-generated method stub
		
		String deleteSQL = "delete from staff where staff_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,staff.getStaffId());
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
	public Staff staffId(int id) {
		// TODO Auto-generated method stub
		
		Staff staff =null;
//	    
		String searchSQL = "select * from staff where owner_id="+id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement = connection.prepareStatement(searchSQL);
			
			

			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				int staffId = resultSet.getInt(1);
				String staffName = resultSet.getString(2);
				String speciality = resultSet.getString(3);
				String staffphoneNumber = resultSet.getString(4);
				String staffEmail = resultSet.getString(5);
				 
			
				
				staff = new  Staff(staffId,staffName,speciality,staffphoneNumber,staffEmail);
				
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
		return staff;
	}

}
