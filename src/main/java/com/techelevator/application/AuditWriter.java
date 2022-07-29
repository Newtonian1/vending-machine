package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class AuditWriter {
    private LocalDateTime dateTime;
    private String action;
    private BigDecimal oldBalance;
    private BigDecimal newBalance;

    public BigDecimal getBalance() {
        return newBalance;
    }


    public void write (String action, BigDecimal oldBalance, BigDecimal newBalance){
            File file = new File("Audit.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTime = LocalDateTime.now().format(format);
            FileOutputStream auditOutput = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(auditOutput);
            writer.println(formatDateTime + "\t" + action + "\t$" + oldBalance + "\t$" + newBalance);
            writer.flush();
            writer.close();
        }catch(IOException e){
            UserOutput.fileNotFound();
        }
    }
}
