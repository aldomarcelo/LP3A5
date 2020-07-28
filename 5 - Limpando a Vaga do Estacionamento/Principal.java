
public class Principal {

	public static void main(String[] args) {
		Vaga vaga = new Vaga();

        //Passando a tarefa e o nome do Thread
        Thread carro1 = new Thread(new CompraRapida(vaga), "Jo�o");
        Thread carro2 = new Thread(new CompraDemorada(vaga), "Pedro");
        Thread limpeza = new Thread(new TarefaLimpeza(vaga), "Limpeza");
        
        //N�o faz sentido a limpeza continuar verificando a vaga 
        //quando n�o h� mais nenhum thread com necessidades
        //por isso setamos setDaemon(true);
        limpeza.setDaemon(true);
        
        
        carro1.start();
        carro2.start();
        
        //inicializa��o dos outros threads omitida
        limpeza.start();
	}

}
