
public class Principal {

	public static void main(String[] args) {
		Vaga vaga = new Vaga();

        //Passando a tarefa e o nome do Thread
        Thread carro1 = new Thread(new CompraRapida(vaga), "João");
        Thread carro2 = new Thread(new CompraDemorada(vaga), "Pedro");

        carro1.start();
        carro2.start();
	}

}
