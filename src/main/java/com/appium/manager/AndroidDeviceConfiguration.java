package com.appium.manager;

import com.appium.utils.CommandPrompt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AndroidDeviceConfiguration {

    CommandPrompt cmd = new CommandPrompt();
    Map<String, String> devices = new HashMap<String, String>();
    ArrayList<String> deviceSerail = new ArrayList<String>();
    ArrayList<String> deviceModel = new ArrayList<String>();

    /**
     * This method start adb server
     */
    public void startADB() throws Exception {
        String output = cmd.runCommand("adb start-server");
        String[] lines = output.split("\n");
        if (lines[0].contains("internal or external command")) {
            System.out.println("Please set ANDROID_HOME in your system variables");
        }
    }

    /**
     * This method stop adb server
     */
    public void stopADB() throws Exception {
        cmd.runCommand("adb kill-server");
    }

    /**
     * This method return connected devices
     *
     * @return hashmap of connected devices information
     */
    public Map<String, String> getDevices() throws Exception {

        startADB(); // start adb service
        String output = cmd.runCommand("adb devices");
        String[] lines = output.split("\n");

        if (lines.length <= 1) {
            System.out.println("No Device Connected");
            stopADB();
            return null;
        } else {
            for (int i = 1; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll("\\s+", "");

                if (lines[i].contains("device")) {
                    lines[i] = lines[i].replaceAll("device", "");
                    String deviceID = lines[i];
                    String model =
                        cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.model")
                            .replaceAll("\\s+", "");
                    String brand =
                        cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.brand")
                            .replaceAll("\\s+", "");
                    String osVersion = cmd.runCommand(
                        "adb -s " + deviceID + " shell getprop ro.build.version.release")
                        .replaceAll("\\s+", "");
                    String deviceName = brand + " " + model;
                    String apiLevel =
                        cmd.runCommand("adb -s " + deviceID + " shell getprop ro.build.version.sdk")
                            .replaceAll("\n", "");

                    devices.put("deviceID" + i, deviceID);
                    devices.put("deviceName" + i, deviceName);
                    devices.put("osVersion" + i, osVersion);
                    devices.put(deviceID, apiLevel);
                } else if (lines[i].contains("unauthorized")) {
                    lines[i] = lines[i].replaceAll("unauthorized", "");
                    String deviceID = lines[i];
                } else if (lines[i].contains("offline")) {
                    lines[i] = lines[i].replaceAll("offline", "");
                    String deviceID = lines[i];
                }
            }
            return devices;
        }
    }

    public ArrayList<String> getDeviceSerial() throws Exception {

        startADB(); // start adb service
        String output = cmd.runCommand("adb devices");
        String[] lines = output.split("\n");

        if (lines.length <= 1) {
            System.out.println("No Device Connected");
            return null;
        } else {
            for (int i = 1; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll("\\s+", "");

                if (lines[i].contains("device")) {
                    lines[i] = lines[i].replaceAll("device", "");
                    String deviceID = lines[i];
                    deviceSerail.add(deviceID);
                } else if (lines[i].contains("unauthorized")) {
                    lines[i] = lines[i].replaceAll("unauthorized", "");
                    String deviceID = lines[i];
                } else if (lines[i].contains("offline")) {
                    lines[i] = lines[i].replaceAll("offline", "");
                    String deviceID = lines[i];
                }
            }
            return deviceSerail;
        }
    }

    /*
     * This method gets the device model name
     */
    public String getDeviceModel(String deviceID) {
        String deviceModelName = null;
        String brand = null;
        String deviceModel = null;
        try {
            deviceModelName =
                cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.model")
                    .replaceAll("\\W", "");

            brand = cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.brand");
        } catch (InterruptedException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        deviceModel = deviceModelName.concat("_" + brand);

        return deviceModel.trim();

    }

    /*
     * This method gets the device OS API Level
     */
    public String deviceOS(String deviceID) {
        String deviceOSLevel = null;
        try {
            deviceOSLevel =
                cmd.runCommand("adb -s " + deviceID + " shell getprop ro.build.version.sdk")
                    .replaceAll("\\W", "");
        } catch (InterruptedException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return deviceOSLevel;

    }

    /**
     * This method will close the running app
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void closeRunningApp(String deviceID, String app_package)
        throws InterruptedException, IOException {
        // adb -s 192.168.56.101:5555 com.android2.calculator3
        cmd.runCommand("adb -s " + deviceID + " shell am force-stop " + app_package);
    }

    /**
     * This method clears the app data only for android
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void clearAppData(String deviceID, String app_package)
        throws InterruptedException, IOException {
        // adb -s 192.168.56.101:5555 com.android2.calculator3
        cmd.runCommand("adb -s " + deviceID + " shell pm clear " + app_package);
    }

    /**
     * This method removes apk from the devices attached
     *
     * @param app_package
     * @throws Exception
     */

    public void removeApkFromDevices(String deviceID, String app_package) throws Exception {
        cmd.runCommand("adb -s " + deviceID + " uninstall " + app_package);
    }
    

    /**
     * 
     * @param deviceID
     * @return
     * @throws IOException
     * @throws InterruptedException
     * 查看当前手机是否支持录制
     */
    public boolean checkIfRecordable(String deviceID) throws IOException, InterruptedException {
        String screenrecord =
            cmd.runCommand("adb -s " + deviceID + " shell ls /system/bin/screenrecord");
        if (screenrecord.trim().equals("/system/bin/screenrecord")) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param deviceID
     * @return
     * @throws IOException
     * @throws InterruptedException
     * 获取手机制造商
     */
    public String getDeviceManufacturer(String deviceID) throws IOException, InterruptedException {
        return cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.manufacturer")
            .trim();
    }
    
    /**
     * 
     * @param deviceID
     * @param fileName
     * @return
     * @throws IOException
     * @throws InterruptedException
     * 录制视频，存放到 /sdcard/下，视频格式为MP4
     */
    
    public String screenRecord(String deviceID, String fileName)
            throws IOException, InterruptedException {
            return "adb -s " + deviceID + " shell screenrecord --bit-rate 1000000 /sdcard/" + fileName
                + ".mp4";
        }
    
    
    /**
     * 
     * @param deviceID
     * @param fileName
     * @param destination
     * @return
     * @throws IOException
     * @throws InterruptedException
     *  获取手机中录制好的视频
     */
    public AndroidDeviceConfiguration pullVideoFromDevice(String deviceID, String fileName,
            String destination) throws IOException, InterruptedException {
    	System.out.println("!!!!!!!!!!!!");  //临时处理
    	System.out.println(destination);
            ProcessBuilder pb =
                new ProcessBuilder("adb", "-s", deviceID, "pull", "/sdcard/" + fileName + ".mp4",
                    destination);
            Process pc = pb.start();
            pc.waitFor();
            System.out.println("Exited with Code::" + pc.exitValue());
            System.out.println("Done");
            Thread.sleep(5000);
            return new AndroidDeviceConfiguration();
        }
    
    /**
     * 
     * @param deviceID
     * @param fileName
     * @throws IOException
     * @throws InterruptedException
     * 删除录制好的视频
     */
    public void removeVideoFileFromDevice(String deviceID, String fileName)
            throws IOException, InterruptedException {
            cmd.runCommand("adb -s " + deviceID + " shell rm -f /sdcard/" + fileName + ".mp4");
        }
}
