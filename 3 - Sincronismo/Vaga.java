public class Vaga {
	public void compraRapida() {

		
		String nome = Thread.currentThread().getName();

	    System.out.println(nome + " procurando vaga no estacionamento");

	    synchronized (this) {

	    	System.out.println(nome + " entrou na vaga!");
	        System.out.println(nome + " fazendo compra rapida");

	        try {
	            Thread.sleep(8000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println(nome + " colocando as compras no carro");
	        System.out.println(nome + " entrando no carro");
	        System.out.println(nome + " saindo da vaga");
	    }
		
		/*
		 * Sem sincronização
		 
		String nome = Thread.currentThread().getName();

	    System.out.println(nome + " entrando no banheiro");
	    System.out.println(nome + " fazendo coisa rapida");

	    try {
	        Thread.sleep(8000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    System.out.println(nome + " dando descarga");
	    System.out.println(nome + " lavando a mao");
	    System.out.println(nome + " saindo do banheiro");
	    */
    }

    public void compraDemorada() {

    	String nome = Thread.currentThread().getName();

    	System.out.println(nome + " procurando vaga no estacionamento");

        synchronized (this) {

	        System.out.println(nome + " entrou na vaga!");
	        System.out.println(nome + " fazendo compra demorada");

	        try {
	            Thread.sleep(15000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println(nome + " colocando as compras no carro");
	        System.out.println(nome + " entrando no carro");
	        System.out.println(nome + " saindo da vaga");
	    }
        
    	/*
        sem sincronização
    	System.out.println("entrando no banheiro");
        System.out.println("fazendo coisa demorada");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("dando descarga");
        System.out.println("lavando a mao");
        System.out.println("saindo do banheiro");
        */
    }
}
