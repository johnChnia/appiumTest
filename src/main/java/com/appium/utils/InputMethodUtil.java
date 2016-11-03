package com.appium.utils;

import java.io.IOException;

public class InputMethodUtil {
	String[] inputArray;

	CommandPrompt cp = new CommandPrompt();
	String device = Thread.currentThread().getName().split("_")[1];
	String command0 = "adb -s " + device + " shell ime list -s";
	String command1 = "adb -s " + device + " shell ime set io.appium.android.ime/.UnicodeIME";
	String command2 = "adb -s " + device + " shell ime set " + getDefaultInput();
	
	public void enableLatinIME() {
	System.out.println(command2);
		try {
			cp.runCommand(command2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enableAppiumUnicodeIME() {
		try {
			cp.runCommand(command1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getDefaultInput() {
		try {
			inputArray = cp.runCommand(command0).split("\n");
			for (String s : inputArray) {
				if (!s.equalsIgnoreCase("io.appium.android.ime/.UnicodeIME")) {
					return s;
				}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
