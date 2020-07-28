package threadLista;

public class TarefaAdicionarElemento implements Runnable {

    private Lista lista;
    int numeroDoThread;

    public TarefaAdicionarElemento(Lista lista, int numeroDoThread) {
    	this.lista = lista;
        this.numeroDoThread = numeroDoThread;
    }

    @Override
    public void run() {

    	for (int i = 0; i < 10; i++) {
            lista.adicionaElementos("Thread " + numeroDoThread + " - " + i);
        }
    	
    }

}
