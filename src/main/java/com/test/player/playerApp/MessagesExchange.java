/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.player.playerApp;

import com.test.player.playerEntry.PlayerParam;
import java.io.IOException;

/**
 *
 * @author hwssa
 */
public class MessagesExchange {

    final static MessageService meSer = new MessageService();

    //The path of the shellScript, from wich the programm will run.
    /**
     *
     * @param initiator The instance of first Player (sender)
     * @param receiver The instance of secound Player (Receicer)
     * @param towProcess Boolean parameter, that decide if the program will run
     * with one or tow Processes
     */
    public void ProcessMessagesExchange(PlayerParam initiator, PlayerParam receiver, boolean towProcess) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // -- Linux --
        // Run a shell command
        //String[] arguments = {"bash", "-c", "bash /mnt/c/Users/hwssa/OneDrive/Documents/NetBeansProjects/Player/"};
        String[] arguments = meSer.arguments;
        processBuilder.command(arguments);

        try {
            Process process = processBuilder.start();
            //System.out.println("Compiling SameProcess......" + process.pid());

            //MeassageExchage bettween Sender and Receiver.
            meSer.messagesExtchange(initiator, receiver, towProcess);

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.exit(0);
            }
        } catch (IOException | InterruptedException e) {
            e.getStackTrace();
        }

    }

}
