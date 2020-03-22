package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {

	private int id;
	private Semaphore semaforo;
	
	public ThreadPessoa (int id, Semaphore semaforo) {
		
		this.id = id;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		andar();
		try {
			
			semaforo.acquire();
			entrarPorta();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} finally {
			
			semaforo.release();
			
		}
		
	}

	private void andar() {
		
		int x = 0, y = 0, res;
		while (x <= 200) {
			
			y = y + (int)((Math.random()*2)+4);
			x = y;
			if (y < 200) {
				
				res = 200 - y;
				
			} else {
				
				res = 0;
				
			}
			System.out.println("Pessoa " + id + " está a " + res + "m de distância da porta");
			
		}
	}
	private void entrarPorta() {
		
		try {
			System.out.println("Pessoa " + id + " está entrando na porta");
			sleep (2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
