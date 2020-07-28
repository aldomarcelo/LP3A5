public class Vaga {
	
	//aqui..
	private boolean ehSuja = true;
	
	
	public void compraRapida() {

		String nome = Thread.currentThread().getName();

	    System.out.println(nome + " procurando vaga no estacionamento");

	    synchronized (this) {

	    	System.out.println(nome + " entrou na vaga!");
	    	
	    	//aqui..
	    	while (this.ehSuja) {
	            esperaLaFora(nome);
	        }
	    	
	    	
	        System.out.println(nome + " fazendo compra rapida");

	        try {
	            Thread.sleep(8000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        //seta somente quando quiser que toda utilização da vaga fique sujo. 
	        //tem que fazer nos dois métodos e tbm add o while ehSuja
	        this.ehSuja = true;
	        
	        System.out.println(nome + " colocando as compras no carro");
	        System.out.println(nome + " entrando no carro");
	        System.out.println(nome + " saindo da vaga");
	    }
		
		
    }

    public void compraDemorada() {

    	String nome = Thread.currentThread().getName();

    	System.out.println(nome + " procurando vaga no estacionamento");

        synchronized (this) {

	        System.out.println(nome + " entrou na vaga!");
	      
	        //aqui..
	    	while (this.ehSuja) {
	            esperaLaFora(nome);
	        }
	        
	        System.out.println(nome + " fazendo compra demorada");

	        try {
	            Thread.sleep(15000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	      //seta somente quando quiser que toda utilização da vaga fique sujo. 
	        //tem que fazer nos dois métodos e tbm add o while ehSuja
	        this.ehSuja = true;
	        
	        System.out.println(nome + " colocando as compras no carro");
	        System.out.println(nome + " entrando no carro");
	        System.out.println(nome + " saindo da vaga");
	    }
        
    	
    }
    
  //aqui..
    private void esperaLaFora(String nome) {

        System.out.println(nome + ", eca, vaga está suja");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
  //aqui..
    public void limpa() {
    	String nome = Thread.currentThread().getName();

    	System.out.println(nome + " procurando vaga para limpar");
    	synchronized (this) {

	        System.out.println(nome + " entrou na vaga!");
	        
	        if (!ehSuja) {
	        	System.out.println(nome + "não esta sujo, vou sair!");
	        	return;
	        }
	        
	        System.out.println(nome + " limpando vaga");
	        this.ehSuja = false;

	        try {
	            Thread.sleep(13000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        this.notifyAll(); // notifica todas as thread que estao esperando que podem entrar na vaga
	        
	        System.out.println(nome + " saindo da vaga");
	    }
    }
    
}
