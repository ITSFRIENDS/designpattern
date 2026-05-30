package game;

public class Player extends Enemy {
    private int life = 100;
    private int posx;
    private int posy; 

    public Player(ComportamientoAtaque comportamientoAtaque) {
        super(comportamientoAtaque); 
    }

    @Override
    public void move() {
        posx = (int)(Math.random() * 100);
        posy = (int)(Math.random() * 100);
        System.out.println("Jugador se movio a coordenadas: " + posx + ", " + posy);
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