package game;

public class AtaqueADistancia implements ComportamientoAtaque {
    @Override
    public int calcularDano() {
        System.out.println("-> Dispara un ataque a distancia.");
        return (int)(Math.random() * 15) + 5; 
    }
}