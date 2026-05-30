package game;

public abstract class Enemy {
    protected ComportamientoAtaque comportamientoAtaque;

    public Enemy(ComportamientoAtaque comportamientoAtaque) {
        this.comportamientoAtaque = comportamientoAtaque;
    }

    public void setComportamientoAtaque(ComportamientoAtaque comportamientoAtaque) {
        this.comportamientoAtaque = comportamientoAtaque;
    }

    public int attack(Enemy enemy) {
        int golpe = comportamientoAtaque.calcularDano();
        return enemy.getHealth() - golpe;
    }

    public abstract void move();
    public abstract void takeDamage(int damage);
    public abstract int getHealth();
}