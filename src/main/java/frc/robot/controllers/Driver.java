package frc.robot.controllers;

import edu.wpi.first.wpilibj.XboxController;

public class Driver {
    //The controller the driver uses
    private final XboxController m_driver = new XboxController(0);

    private static Driver INSTANCE;

    private Driver(){
    }

    public static Driver getDriver() {
        if (INSTANCE == null) {
            INSTANCE = new Driver();
        }
        return INSTANCE;
    }

    
}
