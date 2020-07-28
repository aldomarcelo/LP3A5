package Servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

	public static void main(String[] args) throws Exception {
        System.out.println("---- Iniciando Servidor ----");
        ServerSocket servidor = new ServerSocket(12346);
        
        //aqui..
        //ira permitir apenas 2 clientes
        ExecutorService poolDeThreads = Executors.newFixedThreadPool(2); 
        
		//aqui
        //ira permitir vários cliente
       // ExecutorService poolDeThreads = Executors.newCachedThreadPool();
        
        //Aceitando varios clientes
        while (true) {
            Socket socket = servidor.accept();    
            System.out.println("Aceitando novo cliente na porta " + socket.getPort());
            DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
            
            //aqui..
            poolDeThreads.execute(distribuirTarefas);
        }

    }
	
}
