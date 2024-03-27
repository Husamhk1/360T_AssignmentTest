/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.test.player.mainPlayer;

import com.test.player.playerApp.MessagesExchange;
import com.test.player.playerApp.MessageService;
import com.test.player.playerApp.PlayerEntry;
import com.test.player.playerEntry.PlayerParam;
import java.util.concurrent.BrokenBarrierException;

/**
 *
 * @author hwssa
 */
public class Player {

    final static MessageService meSe = new MessageService();
    final static PlayerEntry entry = new PlayerEntry();
    final static MessagesExchange dipM = new MessagesExchange();
    final static PlayerParam initiator = new PlayerParam("Initiator", "");
    final static PlayerParam receiver = new PlayerParam("Receiver", "");

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        //Start the program and input the player's names
        entry.startMessaging(initiator, receiver);
        
        /*Define the running way of the program "one Process or two Processes"
        * When the program run in two differenent processes the variable twoProc = true, 
        *Otherwise for one Process towProc = false
        */
        boolean twoProc = entry.oneProcceOrTwoProcessesMessageExchange();
        
        //With this method run the program the messages exchange between the Initiator and the Receiver
        dipM.ProcessMessagesExchange(initiator, receiver,twoProc);


    }

}
