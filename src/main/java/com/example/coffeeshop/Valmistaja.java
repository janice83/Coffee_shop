package com.example.coffeeshop;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class Valmistaja extends AbstractPersistable<Long>{
    private String nimi;
    private String url;
    
}
