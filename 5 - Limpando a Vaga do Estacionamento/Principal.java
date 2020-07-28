
public class Principal {

	public static void main(String[] args) {
		Vaga vaga = new Vaga();

        //Passando a tarefa e o nome do Thread
        Thread carro1 = new Thread(new CompraRapida(vaga), "João");
        Thread carro2 = new Thread(new CompraDemorada(vaga), "Pedro");
        Thread limpeza = new Thread(new TarefaLimpeza(vaga), "Limpeza");
        
        //Não faz sentido a limpeza continuar verificando a vaga 
        //quando não há mais nenhum thread com necessidades
        //por isso setamos setDaemon(true);
        limpeza.setDaemon(true);
        
        
        carro1.start();
        carro2.start();
        
        //inicialização dos outros threads omitida
        limpeza.start();
	}

}
