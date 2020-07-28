package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {

	public static void main(String[] args) throws Exception {
        System.out.println("---- Iniciando Servidor ----");
        ServerSocket servidor = new ServerSocket(12346);
        
        //aceitando apenas uma cliente
        //apenas nosso cliente rodar o servidor ira parar de rodar, pois aceite uma conexão. 
        //Socket socket = servidor.accept();    
        
        //Aceitando varios clientes
        while (true) {
            Socket socket = servidor.accept();    
            System.out.println("Aceitando novo cliente na porta " + socket.getPort());
            DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
            new Thread(distribuirTarefas).start();
        }

    }
	
}
