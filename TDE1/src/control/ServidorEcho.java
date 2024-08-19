package control;

import java.io.*;
import java.net.*;

public class ServidorEcho {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4000);

            while (true) {
                Socket socket = serverSocket.accept();

                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

                double temperaturaCelsius = Double.parseDouble(entrada.readLine());
                double temperaturaKelvin = temperaturaCelsius + 273.15;

                saida.println(temperaturaKelvin);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
