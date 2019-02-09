// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5577.GearsBot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5577.GearsBot.commands.*;
import org.usfirst.frc5577.GearsBot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;

    Command autonomousCommand;
    SendableChooser<CommandGroup> autoChooser;

    public static OI oi;

    // Subsystems and Hardware
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static Climber climber;
    public static Pneumatics pneumatics;
    public static Lift lift;
    public static ADXRS450_Gyro gyro;

    // Camera and Vision
    public static CameraServer cameraServer1;
    public static CameraServer cameraServer2;
    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    public void robotInit() {
        RobotMap.init();

        driveTrain = new DriveTrain();
        intake = new Intake();
        climber = new Climber();
        pneumatics = new Pneumatics();
        lift = new Lift();
        gyro = new ADXRS450_Gyro(kGyroPort);
        gyro.calibrate();

        // OI must be constructed after subsystems. If the OI creates Commands
        // (which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        UsbCamera camera0 = CameraServer.getInstance().startAutomaticCapture(0);
        camera0.setResolution(IMG_WIDTH, IMG_HEIGHT);
    }

    // ************************************************************************************************************************************************************************

    public void autonomous() {

    }

    /**
     * This function is called when the disabled button is hit. You can use it to
     * reset subsystems before shutting down.
     */
    public void disabledInit() {

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called only once when autonomous begins. Creates a
     * SendableChooser Object that allows selection of Autonomous code. Adds
     * Autonomous options to the SmartDashboard.
     */
    public void autonomousInit() {
        autoChooser = new SendableChooser<CommandGroup>();
        autoChooser.addDefault("Default program", new AutonDriveStraight());
        autoChooser.addObject("Left", new AutonDriveFromLeft());
        autoChooser.addObject("Center", new AutonDriveFromCenter());
        autoChooser.addObject("Right", new AutonDriveFromRight());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);

        autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This fucntion is called only once when teleop begins
     */
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        // LiveWindow.run();
    }

    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
            Timer.delay(0.005); // wait for a motor update time
        }
    }

}
