package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command {

	double turnValue = 0.5;
	int degrees = 0;

	public Turn() {
		requires(Robot.driveTrain);
		this.turnValue = 0.9;
	}

	public Turn(double turnValue) {
		requires(Robot.driveTrain);

		this.turnValue = turnValue;
	}

	public Turn(int degrees) {
		this.degrees = degrees;
		if (degrees < 0) {
			turnValue = turnValue * -1;
		}
	}

	protected void initialize() {
		Robot.gyro.reset();
	}

	protected void execute() {
		System.out.println("The robot is at this angle from starting bearing in degrees: " + getAngleOfRotation());
		System.out.println("The turnValue is " + turnValue);
		Robot.driveTrain.turn(turnValue);
	}

	protected boolean isFinished() {
		return Math.abs(getAngleOfRotation()) >= Math.abs(degrees);
	}

	protected void end() {
		System.out.println("Turning has ended!");
		Robot.gyro.reset();
		Robot.driveTrain.stop();
	}

	private double getAngleOfRotation() {
		return Robot.gyro.getAngle();
	}

}
