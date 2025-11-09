package frc.robot.modes;

import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.controllers.Driver;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class Teleoperated {
    //Subsystems
    private final Drivetrain m_drivetrain = Drivetrain.getDrivetrain();
    private final Arm m_arm = Arm.getArm();

    //Controllers
    //private final Driver m_driver = Driver.getDriver();
    private final XboxController m_controller = new XboxController(0);

    private static Teleoperated INSTANCE;

    private Teleoperated() {}

    public static Teleoperated getTeleop() {
        if(INSTANCE == null) {
            INSTANCE = new Teleoperated();
        }
        return INSTANCE;
    }

    /**
     * Code that runs in the teleop periodic function
     */
    public void run() {
        m_drivetrain.arcadeDrive(m_controller.getLeftY(), 
                                 m_controller.getRightTriggerAxis());

        double armAngle = 0;
        if(m_controller.getBButton()) {
            armAngle = 90;
        }
        else if (m_controller.getAButton()) {
            armAngle = 45;
        }
        m_arm.setAngle(armAngle);
    }
}
