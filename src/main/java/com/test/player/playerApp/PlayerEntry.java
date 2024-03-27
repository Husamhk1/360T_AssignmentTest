/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.player.playerApp;

import com.test.player.playerEntry.PlayerParam;
import java.util.Scanner;

/**
 *EntryMethod for the all Program
 * @author hwssa
 */
public class PlayerEntry {
    static  Scanner sc = new Scanner(System.in);
    /**
     * 
     * Input the Player's parameters (Names)
     *
     * @param initiator An instance for the first Player
     * @param receiver  An instance for the second Player
     */
    public void startMessaging(PlayerParam initiator, PlayerParam receiver) {
        System.out.println("===============================================");
        System.out.println("        >>> Hello Players :) <<<<");
        System.out.println("===============================================");
        
        int i = 1;

        while (i < 3) {
           
            if (i == 1) {
                System.out.println("Enter the name of first Player");
                initiator.setPlayerName(sc.nextLine());

            } else {
                System.out.println("Enter the name of the secound Player");
                receiver.setPlayerName(sc.nextLine());

            }
            i++;

        }

    }

    /**
     *Define if the program will run with one or tow Processes
     * @return false or ture
     */
    public boolean oneProcceOrTwoProcessesMessageExchange(){
        System.out.println("How would you run the program?");
        System.out.println("For one process Enter 1");
        System.out.println("For two processs wit differnet DIP Enter 2");
        int towProcesses = sc.nextInt();
        if(towProcesses == 1 ){
            return false;
        }else {
            return true;   
        }
        
    }

}
