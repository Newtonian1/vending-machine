package com.techelevator.application;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuditWriter {
    private LocalDateTime dateTime;
    private String action;
    private BigDecimal oldBalance;
    private BigDecimal newBalance;

    /*public AuditWriter(LocalDateTime dateTime, String action, BigDecimal oldBalance, BigDecimal newBalance) {
        this.dateTime = dateTime;
        this.action = action;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;*/
   // }

    public BigDecimal getBalance() {
        return newBalance;
    }
    public BigDecimal setNewBalance(){

    }

    public void write (LocalDateTime dateTime, String action, BigDecimal oldBalance, BigDecimal newBalance){
            File file = new File("Audit.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream auditOutput = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(auditOutput);
            writer.println(dateTime + " " + action + ": " + oldBalance + " " + newBalance);
            writer.flush();
            writer.close();
        }catch(IOException e){
            System.out.println("File not found");
        }
    }
}
