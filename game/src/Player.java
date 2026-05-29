package game;

public class Player implements Enemy {
    private int life = 100;
    private int posx;
    private int posy; 
    
    // Referencia al patrón Bridge
    private ComportamientoAtaque comportamientoAtaque;

    public Player(ComportamientoAtaque comportamientoAtaque) {
        this.comportamientoAtaque = comportamientoAtaque;
    }

    public void setComportamientoAtaque(ComportamientoAtaque comportamientoAtaque) {
        this.comportamientoAtaque = comportamientoAtaque;
    }

    @Override
    public void move() {
        posx = (int)(Math.random() * 100);
        posy = (int)(Math.random() * 100);
        System.out.println("Jugador se movió a coordenadas: " + posx + ", " + posy);
    }

    @Override
    public int attack(Enemy enemy) {
        int golpe = comportamientoAtaque.calcularDano(); 
        return enemy.getHealth() - golpe;
    }

    @Override
    public void takeDamage(int damage) {
        life = damage;
    }

    @Override
    public int getHealth() {
        return life;
    }

    public int getPosx(){
        return this.posx;
    }
    
    public void setPosx(int x){
        this.posx = x;
    }
}