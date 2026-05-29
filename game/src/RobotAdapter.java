package game;
import external.robo.EnemyRobot;

public class RobotAdapter implements Enemy {
    private EnemyRobot robot;
    private ComportamientoAtaque comportamientoAtaque;
    
    // Variable auxiliar en caso de que el .jar no tenga método para obtener la vida
    private int life = 100; 

    public RobotAdapter(EnemyRobot robot, ComportamientoAtaque comportamientoAtaque) {
        this.robot = robot;
        this.comportamientoAtaque = comportamientoAtaque;
    }

    public void setComportamientoAtaque(ComportamientoAtaque comportamientoAtaque) {
        this.comportamientoAtaque = comportamientoAtaque;
    }

    @Override
    public void move() {
        int movement = 10;
        robot.moveForward(movement);
        System.out.println("Robot adaptado moviéndose " + movement + " unidades.");
    }

    @Override
    public int attack(Enemy enemy) {
        int golpe = comportamientoAtaque.calcularDano();
        return enemy.getHealth() - golpe;
    }

    @Override
    public void takeDamage(int damage) {
        this.life = damage;
    }

    @Override
    public int getHealth() {
        return this.life;
    }
}
