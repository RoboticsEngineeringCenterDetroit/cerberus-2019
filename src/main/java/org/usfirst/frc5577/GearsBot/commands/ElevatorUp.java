package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;
import org.usfirst.frc5577.GearsBot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUp extends Command {

	private double speed = 0;
	private double time = 3;
	private double distanceInInches = 12;

	public ElevatorUp() {
		requires(Robot.lift);
	}

	public ElevatorUp(double distanceInFeet) {
		this();
		this.distanceInInches = 12 * distanceInFeet;
	}

	// public UpLift(double speed) {
	// requires(Robot.lift);
	// this.speed = speed;
	// this.time = 0;
	// }

	public ElevatorUp(double speed, double time) {
		this(speed);
		this.time = time;
	}

	@Override
	protected void initialize() {
		System.out.println("This is the timeout time: " + time);
		if (time > 0) {
			setTimeout(time);
		}
	}

	@Override
	protected void execute() {
		Robot.lift.MoveLift(speed);
	}

	@Override
	protected boolean isFinished() {
		// return isTimedOut();
		System.out.println("Elevator encoder count: " + RobotMap.elevatorEncoder.get());
		System.out.println("Elevator encoder distance traveled: " + RobotMap.elevatorEncoder.getDistance() / 12);

		if (RobotMap.elevatorEncoder.getDistance() >= this.distanceInInches) {
			System.out.println("Finished the command!");
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		System.out.println("UpLift command has ended!");
		Robot.lift.MoveLift(0);
	}

}
