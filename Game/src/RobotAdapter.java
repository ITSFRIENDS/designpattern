package game;
import external.robo.EnemyRobot;

public class RobotAdapter extends Enemy {
    private EnemyRobot robot;
    

    public RobotAdapter(EnemyRobot robot, ComportamientoAtaque comportamientoAtaque) {
        super(comportamientoAtaque);
        this.robot = robot;
    }

    @Override
    public void move() {
        int movement = (int)(Math.random() * 15) + 5;
        robot.moveForward(movement);
        System.out.println("Robot moviendose " + movement + " unidades");
    }

    @Override
    public void takeDamage(int damage) {
        robot.receiveShock(damage); 
    }

    @Override
    public int getHealth() {
        return robot.energyLevel(); 
    }
}