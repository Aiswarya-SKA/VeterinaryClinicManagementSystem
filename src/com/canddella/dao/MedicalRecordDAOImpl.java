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
import com.canddella.entity.MedicalRecord;
import com.canddella.entity.Owner;
import com.canddella.entity.Staff;
import com.canddella.entity.Visits;

public class MedicalRecordDAOImpl implements MedicalRecordDAO {

	@Override
	public int save(MedicalRecord medicalrecord) {
		// TODO Auto-generated method stub
		
		String insertSQL = "insert into medicalrecord(pet_id,staff_id,disease,start_date,end_date)"
				+ " values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, medicalrecord.getAnimal().getPetId());
			preparedStatement.setInt(2, medicalrecord.getStaff().getStaffId());
			preparedStatement.setString(3,medicalrecord.getDisease());
			preparedStatement.setString(4, medicalrecord.getStartDate());
			preparedStatement.setString(5, medicalrecord.getEndDate());
			
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
	public List<MedicalRecord> findAll() {
		// TODO Auto-generated method stub
		
		List<MedicalRecord> medicalrecordList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from medicalrecord";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int recordId = resultSet.getInt(1);
				int petId= resultSet.getInt(2);
				int staffId= resultSet.getInt(3);
				String disease = resultSet.getString(4);
				String startDate = resultSet.getString(5);
				String endDate = resultSet.getString(6);
				
				
				//Owner owner=new Owner();
				//owner.setOwnerId(ownerId);
				
				Animal animal=new Animal();
				animal.setPetId(petId);
				Staff staff=new Staff();
				staff.setStaffId(staffId);
                MedicalRecord medicalrecord= new MedicalRecord(recordId,animal,staff,disease,startDate,endDate);
				medicalrecordList.add(medicalrecord);
				
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

		return medicalrecordList;
	
		
	}

	@Override
	public int update(MedicalRecord medicalrecord) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update medicalrecord set pet_id=?,staff_id=?,disease=?,start_date=? ,end_date=? where record_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, medicalrecord.getAnimal().getPetId());
			preparedStatement.setInt(2, medicalrecord.getStaff().getStaffId());
			preparedStatement.setString(3,medicalrecord.getDisease());
			preparedStatement.setString(4, medicalrecord.getStartDate());
			preparedStatement.setString(5, medicalrecord.getEndDate());
			preparedStatement.setInt(6, medicalrecord.getRecordId());
			
			
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
	public MedicalRecord recordId(int id) {
		// TODO Auto-generated method stub
		
		MedicalRecord medicalrecord =null;
//	    
		String searchSQL = "select * from medicalrecord where record_id="+id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement = connection.prepareStatement(searchSQL);
			
			

			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				int recordId = resultSet.getInt(1);
				int petId = resultSet.getInt(2);
				int staffId = resultSet.getInt(3);
				String disease = resultSet.getString(4);
				String startDate = resultSet.getString(5);
				String endDate = resultSet.getString(6);
				Animal animal = new Animal();
				animal.setPetId(petId);
				Staff staff = new Staff();
				staff.setStaffId(staffId);
				
				 
			
				
				medicalrecord = new  MedicalRecord(recordId,animal,staff,disease,startDate,endDate);
				
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
		return medicalrecord;
	}

	@Override
	public int delete(MedicalRecord medicalrecord) {
		// TODO Auto-generated method stub
		String deleteSQL = "delete from medicalrecord where record_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,medicalrecord.getRecordId());
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

}
