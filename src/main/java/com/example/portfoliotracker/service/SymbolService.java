package com.example.portfoliotracker.service;

import com.example.portfoliotracker.entity.Symbol;

import java.util.List;
import java.util.Optional;

public interface SymbolService {

    List<Symbol> fetchSymbolList();

    Optional<Symbol> getSymbolById(Long id);


    Symbol updateSymbol(Symbol symbol, Long id);

    Symbol save(Symbol symbol);
}
