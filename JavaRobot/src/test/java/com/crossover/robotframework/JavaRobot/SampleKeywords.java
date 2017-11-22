package com.crossover.robotframework.JavaRobot;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 

@RobotKeywords
public class SampleKeywords {

    @RobotKeyword("Print Message")
    @ArgumentNames({"message"})
    public void printMessage(String message) {
        System.out.println(message);
    }
    
    @RobotKeyword("Verify the results with text")
    @ArgumentNames({"text"})
    public boolean verifyResults(String text) {
    	
		return false;
    	
    }
}

