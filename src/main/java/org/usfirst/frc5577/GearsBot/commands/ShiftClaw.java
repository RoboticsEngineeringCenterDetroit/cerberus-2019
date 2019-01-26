package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftClaw extends Command {

	private boolean initialClawState;
	private double time = 0.5;
	
	public ShiftClaw() {
		requires(Robot.pneumatics);
		
	}
	protected void initialize() {
		setTimeout(time);
	  	initialClawState = Robot.pneumatics.isClawOpen(); 
	  }

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	 // Called once after isFinished returns true
	  protected void end() {	  	
//	  	Robot.pneumatics.stop();
	  	}
	  
	protected void execute() {
		if (initialClawState == Robot.pneumatics.isClawOpen()) {
			Robot.pneumatics.shiftClaw();
		}
	}

}
