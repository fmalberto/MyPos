package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cliente;

public class DbConnection {	

	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Connection connection;
	private ArrayList<Cliente> listaClientes;
	

	public DbConnection () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/csdb?user=cs&password=cs");
			statement = connection.createStatement();
			listaClientes = new ArrayList<Cliente>();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}				
	}
	
	
	public void adicionarCliente(Cliente cliente) {
		
		try {
			preparedStatement = connection.prepareStatement("insert into agenda values (?,?,?,?,?)");
			preparedStatement.setString(1, cliente.getNombre());
			preparedStatement.setString(2, cliente.getApellido());
			preparedStatement.setString(3, cliente.getEdad());
			preparedStatement.setString(4, cliente.getTelefono());
			preparedStatement.setString(5, cliente.getCiudad());
			preparedStatement.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Cliente> getClientes() {
		
		try {
			resultSet = statement.executeQuery("select * from agenda");
			while(resultSet.next()) {
				listaClientes.add(new Cliente(resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("edad"), resultSet.getString("telefono"), resultSet.getString("ciudad")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	return listaClientes;		
	}
	
	
	
}
