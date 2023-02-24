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

public class AnimalDAOImpl implements AnimalDAO {

	@Override
	public List<Animal> findAll() {
		
			List<Animal> animalList = new ArrayList();
			Connection connection = null;
			PreparedStatement prepStmt = null;

			String selectSQL = "Select * from animal";
			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				prepStmt = connection.prepareStatement(selectSQL);
				ResultSet resultSet = prepStmt.executeQuery();
				while (resultSet.next()) {
					int petId = resultSet.getInt(1);
					int age = resultSet.getInt(2);
					double weight=resultSet.getDouble(3);
					String species = resultSet.getString(4);
					String sex = resultSet.getString(5);
					String breed = resultSet.getString(6);
					String petCategory = resultSet.getString(7);
					
                    Animal animal = new Animal(petId,age,weight,species,sex,breed,petCategory);
					animalList.add(animal);
					
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

			return animalList;
		}


	@Override
	public int save(Animal animal) {
		
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			final String INSERT_SQL = "insert into animal(pet_id,age,weight,species,sex,breed,pet_category) values(?,?,?,?,?,?,?)";
			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(INSERT_SQL);
				  preparedStatement.setInt(1, animal.getPetId());
			      preparedStatement.setInt(2, animal.getAge());
			      preparedStatement.setDouble(3, animal.getWeight());
			      preparedStatement.setString(4, animal.getSpecies());
			      preparedStatement.setString(5, animal.getSex());
			      preparedStatement.setString(6, animal.getBreed());
			      preparedStatement.setString(7, animal.getPetCategory());
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
	public int update(Animal animal) {
		// TODO Auto-generated method stub
		
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		
		final String UPDATE_SQL = "UPDATE animal SET age=?,weight=?,species=?,sex=?,breed=?,pet_category=? WHERE pet_id=?"; 
		try {
			DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      preparedStatement = connection.prepareStatement(UPDATE_SQL);
		      preparedStatement.setInt(1, animal.getAge());
		      preparedStatement.setDouble(2, animal.getWeight());
		      preparedStatement.setString(3, animal.getSpecies());
		      preparedStatement.setString(4, animal.getSex());
		      preparedStatement.setString(5, animal.getBreed());
		      preparedStatement.setString(6, animal.getPetCategory());
		      preparedStatement.setInt(7, animal.getPetId());
		      
		      int row = preparedStatement.executeUpdate();
		      return row ;
		      
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

finally
	{
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

		return 0;
	}


	@Override
	public int delete(Animal animal) {
		// TODO Auto-generated method stub
		
		
			String deleteSQL = "delete from animal where pet_id=? ";

			PreparedStatement preparedStatement = null;

			Connection connection = null;

			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();

				preparedStatement = connection.prepareStatement(deleteSQL);
				preparedStatement.setInt(1,animal.getPetId());
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
	public Animal petId(int id){
	
	Animal animal =null;
//	    
		String searchSQL = "select * from animal where pet_id="+id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement = connection.prepareStatement(searchSQL);
			
			

			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				int petId = resultSet.getInt(1);
				int age = resultSet.getInt(2);
				double weight = resultSet.getDouble(3);
				String species = resultSet.getString(4);
				String sex = resultSet.getString(5);
				String breed = resultSet.getString(6);
				String petCategory = resultSet.getString(7);
			
				
				animal = new  Animal(petId,age,weight,species,sex,breed,petCategory);
				
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
		return animal;


 }
	
	}



