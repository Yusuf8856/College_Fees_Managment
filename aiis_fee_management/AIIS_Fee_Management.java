/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aiis_fee_management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Yusuf Ali
 */
public class AIIS_Fee_Management extends JFrame {

    public static void main(String[] args) {
        JFrame jf=new JFrame("AIIS FEES MANAGEMENT");
        jf.setVisible(true);
        jf.setSize(700,450);
        JLabel lb=new JLabel("WELCOME TO AIIS FEES MANAGEMENT SYSTEM");
       // lb.setVerticalTextPosition(JLabel.BOTTOM);
        //lb.setHorizontalAlignment(JLabel.CENTER);
        JButton bt=new JButton("For SignUp");
       // bt.setHorizontalAlignment(JLabel.CENTER);
       // bt.setSize(50,50);
        bt.setBounds(100,100,100,50);
        bt.addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e){ 
            //SignUpPage s1=new SignUpPage();
            //s1.setVisible(true);
            jf.dispose();
        }
        });
        jf.add(lb);
        jf.add(bt);


    }
}
