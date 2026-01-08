package entities;
import java.util.Scanner;
 
public class CadastroProduto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Digite o preço do produto: ");
            double preco = Double.parseDouble(sc.nextLine());
            System.out.println("Preço com desconto: " + (preco * 0.9));
        } catch (NumberFormatException e){
            System.out.println("Erro: valor inválido! Digite um número válido.");
        } finally {
            sc.close();
            System.out.println("Execução finalizada.");
        }
    }
}