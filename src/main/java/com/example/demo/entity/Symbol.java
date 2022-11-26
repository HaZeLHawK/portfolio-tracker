package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticker;
    private String name;


    public Long getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

//    public String getSymbolName() {
//        return name;
//    }

    public void setSymbolName(String name) {

    }
}
