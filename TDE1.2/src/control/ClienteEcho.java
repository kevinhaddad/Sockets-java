package control;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteEcho {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 4000);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            Scanner leitor = new Scanner(System.in);
            System.out.print("Digite a temperatura em Celsius: ");
            double temperaturaCelsius = leitor.nextDouble();

            saida.println(temperaturaCelsius);

            String resultado = entrada.readLine();
            System.out.println("Temperatura em Kelvin: " + resultado);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}