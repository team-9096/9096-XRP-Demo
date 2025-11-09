// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final XRPServo m_armServo;
  // Device number 4 maps to the physical Servo 1 port on the XRP
  private final int m_servoPort = 4;
  private static Arm INSTANCE;

  /** Creates a new Arm. */
  private Arm() {
    
    m_armServo = new XRPServo(m_servoPort);
  }

  /**
   * Provides an instance of the Arm object
   * 
   * This is a singleton design pattern, this forces the system to only create
   * one of a given object and share it. We want this because if we created
   * multiple Arm objects, they might conflict with each other, and act
   * unpredictably.
   * @return The Arm object
   */
  public static Arm getArm() {
    if (INSTANCE == null) {
      INSTANCE = new Arm();
    }
    return INSTANCE;
  }

  /**
   * Set the current angle of the arm (0 - 180 degrees).
   *
   * @param angleDeg Desired arm angle in degrees
   */
  public void setAngle(double angleDeg) {
    m_armServo.setAngle(angleDeg);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
