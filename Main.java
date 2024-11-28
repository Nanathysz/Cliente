public // Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.print("Digite o nome do cliente que deseja pesquisar: ");
        String nome = scanner.nextLine();

        Cliente cliente = clienteDAO.pesquisarPorNome(nome);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }

        scanner.close();
    }
} {
    
}
