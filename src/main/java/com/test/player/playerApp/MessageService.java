/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.player.playerApp;

import com.test.player.playerEntry.PlayerParam;
import java.io.IOException;
import java.util.Scanner;

/**
 *Messages Service is a class for alle Methodes, witch will be unsed in this program
 * @author hwssa
 */
public class MessageService {

    final static Scanner sc = new Scanner(System.in);
    //The Path of shellScript file, form witch will run the program.
    final  String[] arguments = {"bash", "-c", "bash /mnt/c/Users/hwssa/OneDrive/Documents/NetBeansProjects/Player/"};
    
    /**
     *
     * Send the response from Player2 to player1 with the both messages     *
     * @author hwssa
     * @param initiator The Sender instance
     * @param receiver Thre Receivcer Instance
     * This Methode will run in the same process of main methode
     */
    public void receiverResponseToSender(PlayerParam initiator, PlayerParam receiver) {
        String str = receiver.getMessage() + "\t" + initiator.getMessage();
        //System.out.println("ResponseMeassaage.." + ProcessHandle.current().pid());
        System.out.println(receiver.getPlayerName() + ":\t" + str);

    }

    /**
     *
     * Send a message to another Player     *
     * @author hwssa
     * @param player The Sender Player
     * @param Message The message, which will be to send
     * This Methode will run in the same process of main methode
     */
    public void sendMeassaage(PlayerParam player, String Message) {
        player.setMessage(Message);
        //System.out.println("sendMeassaage.." + ProcessHandle.current().pid());

    }

    /**
     *
     * @param initiator The Sender instance
     * @param receiver Thre Receivcer Instance
     * This Methode will run in the same process of main methode
     */
    public void receciverResponseToSenderOnPro(PlayerParam initiator, PlayerParam receiver) {

        ProcessBuilder processBuilder = new ProcessBuilder();
        // -- Linux --
        // Run a shell command    
        // String[] arguments = {"bash", "-c", "bash /mnt/c/Users/hwssa/OneDrive/Documents/NetBeansProjects/Player"};

        processBuilder.command(arguments);

        try {
            Process process = processBuilder.start();
            //System.out.println("Receive Message From Process......" + process.pid());

            String str = receiver.getMessage() + "\t" + initiator.getMessage();
            System.out.println(receiver.getPlayerName() + ":\t" + str);

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.exit(0);
            }
        } catch (IOException | InterruptedException e) {
            e.getStackTrace();
        }
    }

    /**
     *
     * @param player
     * @param Message
     */
    public void sendMeassageOneProc(PlayerParam player, String Message) {

        ProcessBuilder processBuilder = new ProcessBuilder();
         // -- Linux --
        // Run a shell command
        //String[] arguments = {"bash", "-c", "bash /mnt/c/Users/hwssa/OneDrive/Documents/NetBeansProjects/Player"};
        processBuilder.command(arguments);

        try {
            Process process = processBuilder.start();
            //System.out.println("Send Message sendMeassageOneProc......" + process.pid());
            player.setMessage(Message);

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.exit(0);
            }
        } catch (IOException | InterruptedException e) {
            e.getStackTrace();
        }
    }

    /**
     *
     * In this Method will exchange all messages between the players
     *
     * @author hwssa
     * @param initiator Initiator instance
     * @param receiver Receiver instance
     * @param twoProcesses The Default value is false for one Process, then the
     * true will be used for two processes.
     * @throws java.lang.InterruptedException
     */
    public void messagesExtchange(PlayerParam initiator, PlayerParam receiver, boolean twoProcesses) throws InterruptedException {
        int i = 1;
        System.out.println("Start Texting......:)");

        while (i <= 10) {
            if (twoProcesses == false) {
                System.out.print(initiator.getPlayerName() + " writting.." + "\t");
                String sender = sc.nextLine();

                //Send am Meassage from InitiatorPlayer1 to Recever Player2
                sendMeassaage(initiator, sender);
                waitThNextProcess(5);
                System.out.print(receiver.getPlayerName() + " writting.. " + "\t");
                String rece = sc.nextLine();
                sendMeassaage(receiver, rece);
                waitThNextProcess(5);
                receiverResponseToSender(initiator, receiver);

            } else {

                System.out.print(initiator.getPlayerName() + " writting.." + "\t");
                String sender = sc.nextLine();

                //Send am Meassage from InitiatorPlayer1 to Recever Player2
                sendMeassageOneProc(initiator, sender);
                waitThNextProcess(5);
                System.out.print(receiver.getPlayerName() + " writting.. " + "\t");
                String rece = sc.nextLine();
                sendMeassageOneProc(receiver, rece);
                waitThNextProcess(5);
                receciverResponseToSenderOnPro(initiator, receiver);
            }

            i++;

        }

        gracefull();
    }

    /**
     *
     * Waiting for a specific time
     *
     * @param SleepTimeInSec This input will specify the waiting's time, and it
     * will be measured in Seconds
     * @author hwssa
     * @throws java.lang.InterruptedException
     */
    //
    public void waitThNextProcess(int SleepTimeInSec) throws InterruptedException {

        while (SleepTimeInSec != 0) {
            Thread.sleep(500);
            System.out.print(" .");
            SleepTimeInSec--;
        }
        System.out.println(" . sended!");
    }

    /**
     * The Game ende with send a gracefull message
     */
    public void gracefull() {
        System.out.println("===============================================");
        System.out.println("      >>> Thanks for your messages <<<<");
        System.out.println("===============================================");

    }

}
