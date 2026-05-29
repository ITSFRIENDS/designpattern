package game;
import external.robo.EnemyRobot;

public class Main {
    public static void main(String[] args) {

        ComportamientoAtaque ataqueMelee = new AtaqueMelee();
        ComportamientoAtaque ataqueDistancia = new AtaqueADistancia();

        System.out.println("=== PRUEBA DE PLAYER ===");
        Enemy enemy1 = new Player(ataqueMelee);
        Enemy enemy2 = new Player(ataqueMelee);

        System.out.println("Salud inicial enemy2: " + enemy2.getHealth());
        enemy2.takeDamage(enemy1.attack(enemy2));
        System.out.println("Salud enemy2 post-ataque de enemy1: " + enemy2.getHealth());

        System.out.println("\n=== PRUEBA DE ROBOT CON PATRONES ===");
        
        EnemyRobot robotExterno = new EnemyRobot();
        
        Enemy robotEnemy = new RobotAdapter(robotExterno, ataqueDistancia);
        
        robotEnemy.move();
        enemy2.takeDamage(robotEnemy.attack(enemy2));
        System.out.println("Salud enemy2 post-ataque del Robot a Distancia: " + enemy2.getHealth());

        System.out.println("\n=== CAMBIO DINÁMICO DE ATAQUE (FLEXIBILIDAD) ===");

        ((RobotAdapter) robotEnemy).setComportamientoAtaque(ataqueMelee);
        
        enemy2.takeDamage(robotEnemy.attack(enemy2));
        System.out.println("Salud enemy2 post-ataque del Robot Cuerpo a Cuerpo: " + enemy2.getHealth());
    }
}