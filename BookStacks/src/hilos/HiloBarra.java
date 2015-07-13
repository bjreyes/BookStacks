package hilos;
import aplicaciones.login;

public class HiloBarra extends Thread {
		public void run() {
			for (int i = 0; i <= 100; i++) {
				login.barra.setValue(i);
			}try{
				Thread.sleep(100);
			}catch (InterruptedException e) {
				System.out.println("Error en la barra");
			}
		}
}
