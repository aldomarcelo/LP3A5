package Cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12346);
        System.out.println("Conexão Estabelecida");
        
        PrintStream saida = new PrintStream(socket.getOutputStream());
        
        
		//sem Thread
        //aqui
        //envia dados para o servidor
        Scanner teclado = new Scanner(System.in);
        while (teclado.hasNextLine()) {
            String linha = teclado.nextLine();
            
            //enter para o cliente
            if (linha.trim().equals("")) {
                break;
            }
            
            saida.println(linha);
        }

        //sem Thread
        //aqui
        //recebe dados para o servidor
        Scanner respostaServidor = new Scanner(socket.getInputStream());
        while (respostaServidor.hasNextLine()) {
            String linha = respostaServidor.nextLine();
            System.out.println(linha);
        }
        respostaServidor.close();
        
        saida.close();
        teclado.close();
        
        
        
        /*
        Thread threadEnviaComando = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    System.out.println("Pode enviar comandos!");
                    PrintStream saida = new PrintStream(socket.getOutputStream());

                    Scanner teclado = new Scanner(System.in);
                    while (teclado.hasNextLine()) {

                        String linha = teclado.nextLine();

                        if (linha.trim().equals("")) {
                            break;
                        }

                        saida.println(linha);
                    }

                    saida.close();
                    teclado.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        
        
        Thread threadRecebeResposta = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    System.out.println("Recebendo dados do servidor");
                    Scanner respostaServidor = new Scanner(socket.getInputStream());

                    while (respostaServidor.hasNextLine()) {
                        String linha = respostaServidor.nextLine();
                        System.out.println(linha);
                    }

                    respostaServidor.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        
        threadRecebeResposta.start();
        threadEnviaComando.start();
      //thread main vai esperar 
        threadEnviaComando.join();

        System.out.println("Fechando o socket do cliente");
        */
        
        socket.close();
    }
	
}
