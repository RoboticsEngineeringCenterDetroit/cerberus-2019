package org.usfirst.frc5577.GearsBot.subsystems;

import org.usfirst.frc5577.GearsBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
	
	private StringBuilder sb = new StringBuilder();
	int loops = 0;
	
	public Lift() {
		RobotMap.talonSRX7.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		RobotMap.talonSRX7.configNominalOutputForward(+0.0, -0);
		RobotMap.talonSRX7.configPeakOutputForward(+12.0, -12);
		RobotMap.talonSRX7.selectProfileSlot(0, 0);
		RobotMap.talonSRX7.config_kF(0, 0.01, 0);
		RobotMap.talonSRX7.config_kP(0, 0.0, 0);
		RobotMap.talonSRX7.config_kI(0, 0.0, 0);
		RobotMap.talonSRX7.config_kD(0, 0.0, 0);
		RobotMap.talonSRX7.set(ControlMode.PercentOutput, 0);
		
		RobotMap.talonSRX8.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		RobotMap.talonSRX8.configNominalOutputForward(+0.0, -0);
		RobotMap.talonSRX8.configPeakOutputForward(+12.0, -12);
		RobotMap.talonSRX8.selectProfileSlot(0, 0);
		RobotMap.talonSRX8.config_kF(0, 0.01, 0);
		RobotMap.talonSRX8.config_kP(0, 0.0, 0);
		RobotMap.talonSRX8.config_kI(0, 0.0, 0);
		RobotMap.talonSRX8.config_kD(0, 0.0, 0);
		RobotMap.talonSRX8.set(ControlMode.PercentOutput, -0);
	}
	
	public void MoveLift(double speed) {
//		Joystick controller = Robot.oi.getJoystick();
//		
		double motorOutput = RobotMap.talonSRX7.getMotorOutputVoltage() / RobotMap.talonSRX7.getBusVoltage();
		sb.append("\tout:");
		sb.append(motorOutput);
		sb.append("\tspeed");
		sb.append(RobotMap.talonSRX7.getSelectedSensorVelocity(0));
		
		double motorOutput1 = RobotMap.talonSRX8.getMotorOutputVoltage() / RobotMap.talonSRX8.getBusVoltage();
		sb.append("\tout:");
		sb.append(motorOutput1);
		sb.append("\tspeed");
		sb.append(RobotMap.talonSRX8.getSelectedSensorVelocity(0));
		
		double targetSpeed = speed; // 6000 RPM target
		RobotMap.talonSRX7.set(ControlMode.PercentOutput, targetSpeed);
		
		sb.append("/terr"); 
		sb.append(RobotMap.talonSRX7.getClosedLoopError(0)); 
		sb.append("/ttrg:");  
		sb.append(targetSpeed);
		
		double targetSpeed1 = speed; // 6000 RPM target
		RobotMap.talonSRX8.set(ControlMode.PercentOutput, -targetSpeed1);
		
		sb.append("/terr"); 
		sb.append(RobotMap.talonSRX8.getClosedLoopError(0)); 
		sb.append("/ttrg:");  
		sb.append(targetSpeed1);
	
//		Uncomment below to print out motor speed
//		if(++loops >= 10) { 
//			loops = 0; 
//			System.out.println(sb.toString()); 
//		} 
		
		sb.setLength(0);
		
		
	}
	
	public void stop() {
		RobotMap.talonSRX7.set(ControlMode.PercentOutput, 0);
		RobotMap.talonSRX8.set(ControlMode.PercentOutput, 0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
