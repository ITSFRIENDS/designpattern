package game;

public class AtaqueMelee implements ComportamientoAtaque {
    @Override
    public int calcularDano() {
        System.out.println("Realiza un ataque cuerpo a cuerpo");
        return (int)(Math.random() * 10); 
    }
}