package Servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	//aqui
    private ServidorTarefas servidor; //novo atributo


 // recebendo servidor
    public DistribuirTarefas(Socket socket, ServidorTarefas servidor) {
        this.socket = socket;
        this.servidor = servidor; //novo
    }

    @Override
    public void run() {
        
    	//aqui..
    	try {
    		System.out.println("Distribuindo as tarefas para o cliente " + socket);

            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

            while (entradaCliente.hasNextLine()) {

                String comando = entradaCliente.nextLine();
                System.out.println("Comando recebido " + comando);

                switch (comando) {
                    case "c1": {
                        // confirmação do o cliente
                        saidaCliente.println("Confirmação do comando c1");
                        break;
                    }
                    case "c2": {
                        saidaCliente.println("Confirmação do comando c2");
                        break;
                    }
                    case "fim" : {
                        saidaCliente.println("Desligando o servidor");
                        servidor.parar();
                        return;//sainda do método, break só sairia do switch
                    }
                    default: {
                        saidaCliente.println("Comando não encontrado");
                    }
                }

                System.out.println(comando);
            }

            saidaCliente.close();
            entradaCliente.close();
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

}
