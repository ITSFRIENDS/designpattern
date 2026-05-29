package game;

import external.robo.EnemyRobot;

public class RobotAdapter implements Enemy {
    private EnemyRobot robot;

    public RobotAdapter(EnemyRobot robot) {
        this.robot = robot;
    }

    @Override
    public void move() {
        // Usamos una distancia predeterminada, por ejemplo, 5 unidades.
        robot.moveForward(3);
    }

    @Override
    public int attack(Enemy enemy) {
        // Usamos el método smash. Según el bytecode, gasta 5 de energía.
        // Como 'smash' en el JAR es void, definimos un daño estándar.
        int damageDealt = 10; 
        robot.smash(damageDealt);
        return damageDealt;
    }

    @Override
    public void takeDamage(int damage) {
        // El método equivalente en el JAR es receiveShock
        robot.receiveShock(damage);
    }

    @Override
    public int getHealth() {
        // En el robot, la "vida" es el nivel de energía
        return robot.energyLevel();
    }
}