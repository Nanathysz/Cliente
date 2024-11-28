// ClienteDAO.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Substitua pelo seu URL
    private String jdbcUsername = "seu_usuario"; // Substitua pelo seu usuário
    private String jdbcPassword = "sua_senha"; // Substitua pela sua senha

    // Método para pesquisar cliente por nome
    public Cliente pesquisarPorNome(String nome) {
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE nome = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                cliente = new Cliente(id, nome, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}