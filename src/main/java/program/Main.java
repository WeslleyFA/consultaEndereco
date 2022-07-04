package program;

import entity.Endereco;
import service.EnderecoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu cep: ");
        String cep = scanner.next();

        Endereco endereco = EnderecoService.buscaEnderecoPorCep(cep);

        System.out.println(endereco);
    }
}
