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

public class VisitsDAOImpl implements VisitsDAO {

	@Override
	public int save(Visits visits) {
		// TODO Auto-generated method stub
		
		String insertSQL = "insert into visits(pet_id,owner_id,visit_date,visit_time)"
				+ " values(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, visits.getAnimal().getPetId());
			preparedStatement.setInt(2, visits.getOwner().getOwnerId());
			preparedStatement.setString(3, visits.getVisitDate());
			preparedStatement.setString(4, visits.getVisitTime());
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
	public List<Visits> findAll() {
		// TODO Auto-generated method stub
		
		List<Visits> visitsList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from visits";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int visitId = resultSet.getInt(1);
				int petId= resultSet.getInt(2);
				int ownerId=resultSet.getInt(3);
				String visitDate = resultSet.getString(4);
				String visitTime = resultSet.getString(5);
				Animal animal=new Animal();
				animal.setPetId(petId);
				Owner owner=new Owner();
				owner.setOwnerId(ownerId);
				
				
                Visits visits= new Visits(visitId,animal,owner,visitDate,visitTime);
				visitsList.add(visits);
				
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

		return visitsList;
	}

	@Override
	public int update(Visits visits) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update visits set pet_id=?,owner_id=?,visit_date=?,visit_time=? where visit_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, visits.getAnimal().getPetId());
			preparedStatement.setInt(2, visits.getOwner().getOwnerId());
			preparedStatement.setString(3,visits.getVisitDate());
			preparedStatement.setString(4, visits.getVisitTime());
			preparedStatement.setInt(5, visits.getVisitId());
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
	public int delete(Visits visits) {
		// TODO Auto-generated method stub
		
		String deleteSQL = "delete from visits where visit_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,visits.getVisitId());
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
	public Visits visitId(int id) {
		// TODO Auto-generated method stub
		Visits visits =null;
//	    
		String searchSQL = "select * from visits where visit_id="+id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement = connection.prepareStatement(searchSQL);
			
			

			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				int visitId = resultSet.getInt(1);
				int petId = resultSet.getInt(2);
				int ownerId = resultSet.getInt(3);
				String visitDate = resultSet.getString(4);
				String visitTime = resultSet.getString(5);

				Animal animal = new Animal();
				animal.setPetId(petId);
				Owner owner = new Owner();
				owner.setOwnerId(ownerId);
				
				
				 
			
				
				visits = new  Visits(visitId,animal,owner,visitDate,visitTime);
				
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
		
		return visits;
	}


	
	
}
