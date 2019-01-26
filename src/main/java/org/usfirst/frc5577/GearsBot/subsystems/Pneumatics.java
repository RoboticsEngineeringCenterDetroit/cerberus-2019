package org.usfirst.frc5577.GearsBot.subsystems;

import org.usfirst.frc5577.GearsBot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	
	private boolean isHighGear = false;
	private boolean isClawOpen = false;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void shiftGear() {
		if (isHighGear) {
			shiftToLowGear();
		} else {
			shiftToHighGear();
		}
	}
	
	public void shiftClaw() {
		if (isClawOpen) {
			closeClaw();
		} else {
			openClaw();
		}
	}	
	public boolean isHighGear() {
		return isHighGear;
	}
	
	public boolean isClawOpen() {
		return isClawOpen;
	}
	
	private void shiftToHighGear() {
		RobotMap.driveTrainSwitch.set(DoubleSolenoid.Value.kForward);
		isHighGear = true;
	}
	
	private void shiftToLowGear() {
		RobotMap.driveTrainSwitch.set(DoubleSolenoid.Value.kReverse);
		isHighGear = false;
	}
	
	private void openClaw() {
		RobotMap.clawSwitch.set(DoubleSolenoid.Value.kForward); 
		isClawOpen = true;
	
	}
	
	private void closeClaw() {
		RobotMap.clawSwitch.set(DoubleSolenoid.Value.kReverse);
		isClawOpen = false;
	}
	public void stop() {
		RobotMap.driveTrainSwitch.set(DoubleSolenoid.Value.kOff); 
	}
	
}
