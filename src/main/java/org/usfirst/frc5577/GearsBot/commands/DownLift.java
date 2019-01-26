package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DownLift extends Command {
	
	private double speed = 0;
	
	public DownLift(double speed) {
		requires(Robot.lift);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.lift.MoveLift(speed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
