package com.example.portfoliotracker.service;

import com.example.portfoliotracker.entity.Symbol;
import com.example.portfoliotracker.repository.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SymbolServiceImpl implements SymbolService{

    @Autowired
    private SymbolRepository symbolRepository;

    @Override
    public List<Symbol> fetchSymbolList() {
        return (List<Symbol>) symbolRepository.findAll();
    }

    @Override
    public Optional<Symbol> getSymbolById(Long id){
        return (Optional<Symbol>) symbolRepository.findById(id);
    }

    @Override
    public Symbol save(Symbol symbol) {
        return symbolRepository.save(symbol);
    }

    @Override
    public Symbol updateSymbol(Symbol symbol, Long id) {
        Symbol symbolDB
                = symbolRepository.findById(id)
                .get();

//        if (Objects.nonNull(symbol.getSymbolName())
//                && !"".equalsIgnoreCase(
//                symbol.getSymbolName())) {
//            symbolDB.setSymbolName(
//                    symbol.getSymbolName());
//        }

        return symbolRepository.save(symbolDB);
    }
}
