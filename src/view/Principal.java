package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Principal {
	
	public static Semaphore semaforo;
	public static void main(String[] args) {
		
		int id;
		semaforo = new Semaphore(1);
		for (id = 1; id <=4; id++) {
			
			Thread pessoa = new ThreadPessoa(id, semaforo );
			pessoa.start();
		}
	}
}