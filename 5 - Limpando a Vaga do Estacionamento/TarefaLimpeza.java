
public class TarefaLimpeza implements Runnable {

    private Vaga vaga;

    public TarefaLimpeza(Vaga vaga) {
        this.vaga = vaga;
    }

    public void run() {
    	//this.vaga.limpa();
    	
    	//Vamos fazer que a limpeza volte periodicamente, por exemplo a cada 15 segundos.
    	
    	while(true) {
            this.vaga.limpa();
            try {
                Thread.sleep(15000);//limpando cada 15s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}