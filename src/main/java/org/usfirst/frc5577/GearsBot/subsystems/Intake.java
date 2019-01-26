package org.usfirst.frc5577.GearsBot.subsystems;

import org.usfirst.frc5577.GearsBot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.*;

public class Intake extends Subsystem {
		
	public void intakeCube(double speed) {
		
		RobotMap.talonSRX5.set(ControlMode.PercentOutput, -speed);
		RobotMap.talonSRX6.set(ControlMode.PercentOutput, speed);
	}
	
	public void pushOutCube(double speed) {
		RobotMap.talonSRX5.set(ControlMode.PercentOutput, speed);
		RobotMap.talonSRX6.set(ControlMode.PercentOutput, -speed);
	}
	
	public void stop() {
		RobotMap.talonSRX5.set(ControlMode.PercentOutput, 0);
		RobotMap.talonSRX6.set(ControlMode.PercentOutput, 0);
	}

	@Override
	protected void initDefaultCommand() {
	}

}
