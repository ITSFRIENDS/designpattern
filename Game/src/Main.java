package game;
import external.robo.EnemyRobot;

public class Main {
    public static void main(String[] args) {

        ComportamientoAtaque ataqueMelee = new AtaqueMelee();
        ComportamientoAtaque ataqueDistancia = new AtaqueADistancia();

        System.out.println("Prueba de player");
        Enemy enemy1 = new Player(ataqueMelee);
        Enemy enemy2 = new Player(ataqueMelee);

        System.out.println("Salud inicial de enemy2: " + enemy2.getHealth());
        enemy2.takeDamage(enemy1.attack(enemy2));
        System.out.println("salud de enemy2 despues de ataque de enemy1: " + enemy2.getHealth());

        System.out.println("\nPrueba de robot");
        
        EnemyRobot robotExterno = new EnemyRobot();
        Enemy robotEnemy = new RobotAdapter(robotExterno, ataqueDistancia);
        
        robotEnemy.move();
        enemy2.takeDamage(robotEnemy.attack(enemy2));
        System.out.println("Salud de enemy2 despues de ataque del robot a distancia: " + enemy2.getHealth());

        System.out.println("\nCambio de ataque");

        robotEnemy.setComportamientoAtaque(ataqueMelee);
        
        enemy2.takeDamage(robotEnemy.attack(enemy2));
        System.out.println("Salud de enemy2 despues de ataque del Robot cuerpo a cuerpo: " + enemy2.getHealth());
    }
}