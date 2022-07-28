package com.techelevator.application;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuditWriter {
    private LocalDateTime dateTime;
    private String action;
    private BigDecimal balance;
    private BigDecimal changeToBalance;

    public AuditWriter(LocalDateTime dateTime, String action, BigDecimal balance, BigDecimal changeToBalance) {
        this.dateTime = dateTime;
        this.action = action;
        this.balance = balance;
        this.changeToBalance = changeToBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void write (){
            File file = new File("Audit.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream auditOutput = new FileOutputStream(file);
            PrintWriter writer = new PrintWriter(auditOutput);
        }catch(IOException e){
            System.out.println("File not found");
        }
    }
    /*File file = new File("Audit.txt");
    try {
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream auditOutput = new FileOutputStream(file);
        PrintWriter writer = new PrintWriter(auditOutput);
    }catch(IOException e){
        System.out.println("File not found");
    }*/
}
