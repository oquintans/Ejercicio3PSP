/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oquintansocampo
 */
public class Main extends Thread {

    Thread hilo;
    static int cont = 1;
    int cont2 = 0;

    public Main(String nom) {
        super(nom);
    }

    public static void main(String[] args) {

        new Main("Hilo" + cont).start();
    }

    //Metodos que se ejecuta cuando llamamos al metodo .start()
    @Override
    public void run() {
        try {
            //Indica que el hilo comienza
            System.out.println("Nombre: " + getName() + " ha comenzado");
            //Crearemos en total 5 hilos
            while (cont <= 5) {
                //Numero de hilo
                cont++;                
                //Bucle que indica que cada hilo se esta procesando
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName() + " procesando");
                    sleep((long) ((Math.random() * (600 - 100)) + 100));
                }                
                //Dentro de cada hilo crea el siguiente
                hilo = new Main("Hilo" + cont);
                //Condicional para que arranque solo hasta 5 hilos
                if (cont <= 5) {
                    //Inicia el siguiente hilo
                    hilo.start();
                    //Espera a que termine el hilo hijo
                    hilo.join();
                }
                System.out.println(getName() + " ha terminado");
            }
        } catch (Throwable ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
