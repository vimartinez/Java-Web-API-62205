package com.educacionit.jwa01.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.jwa01.conf.MySQLConnection;
import com.educacionit.jwa01.model.User;

public class UserDao implements Dao<User, Long>, MySQLConnection {

	private PreparedStatement psGetUserById = null;
	private PreparedStatement psGetAllUsers = null;
	private PreparedStatement psAdd = null;
	private PreparedStatement psDel = null;
	private PreparedStatement psUpd = null;
	
	@Override
	public User getById(Long id) {
		User user = null;
		try {
			psGetUserById = conectarDB().prepareStatement(
					"SELECT id, nombreApellido, mail, direccion, clave "
					+ "FROM Users "
					+ "WHERE id = ?;");
			psGetUserById.setLong(1, id);
			ResultSet resultado = psGetUserById.executeQuery();
			if(resultado.next()){
				user = new User();
				user.setNombreApellido(resultado.getString("nombreApellido"));
				user.setId(resultado.getLong("id"));
				user.setDireccion(resultado.getString("direccion"));
				user.setMail(resultado.getString("mail"));
				user.setClave(resultado.getNString("clave"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> usersList = new ArrayList<>();
		try {
			if(psGetAllUsers == null) {
				psGetAllUsers = conectarDB().prepareStatement(
						"SELECT id, nombreApellido, mail, direccion, clave "
						+ " FROM Users");
			}
			ResultSet resultado = psGetAllUsers.executeQuery();
			while(resultado.next()) {
				User usuarioAuxiliar = new User();
				usuarioAuxiliar.setNombreApellido(resultado.getString("nombreApellido"));
				usuarioAuxiliar.setId(resultado.getLong("id"));
				usuarioAuxiliar.setDireccion(resultado.getString("direccion"));
				usuarioAuxiliar.setMail(resultado.getString("mail"));
				usuarioAuxiliar.setClave(resultado.getNString("clave"));
				usersList.add(usuarioAuxiliar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	@Override
	public Boolean add(User user) {
		Boolean resultado = false;
		try {
			if (psAdd == null) {
				psAdd = conectarDB().prepareStatement(
						"INSERT INTO Users (id, nombreApellido, mail, direccion, clave) "
						+ " VALUES (?,?,?,?,MD5(?));");
			}
			psAdd.setLong(1, user.getId());
			psAdd.setString(2, user.getNombreApellido());
			psAdd.setString(3, user.getMail());
			psAdd.setString(4, user.getDireccion());
			psAdd.setString(5, user.getClave());
			if (psAdd.executeUpdate()==1) resultado = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean del(User user) {
		Boolean resultado = false;
		try {
			if (psDel == null) {
				psDel = conectarDB().prepareStatement("DELETE FROM Users WHERE id = ?");
			}
			psDel.setLong(1, user.getId());
			if (psDel.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean upd(User user) {
		Boolean resultado = false;
		try {
			if (psUpd == null) {
				psUpd = conectarDB().prepareStatement(
						"UPDATE Users set nombreApellido=?, mail=?, direccion=?, clave=MD5(?) "
						+ " WHERE id = ?");
			}
			psUpd.setString(1, user.getNombreApellido());
			psUpd.setString(2, user.getMail());
			psUpd.setString(3, user.getDireccion());
			psUpd.setString(4, user.getClave());
			psUpd.setLong(5, user.getId());
			if (psUpd.executeUpdate() == 1 ) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	

}
