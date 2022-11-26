package com.example.demo.service;

import com.example.demo.entity.Symbol;

import java.util.List;
import java.util.Optional;

public interface SymbolService {

    List<Symbol> fetchSymbolList();

    Optional<Symbol> getSymbolById(Long id);


    Symbol updateSymbol(Symbol symbol, Long id);

    Symbol save(Symbol symbol);
}
