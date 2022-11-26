package com.example.demo.controller;

import com.example.demo.entity.Symbol;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SymbolRepository;
import com.example.demo.service.SymbolService;
import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequestMapping("/symbols")
public class SymbolController {
    @Autowired
    private SymbolService symbolService;

    @GetMapping
    public List<Symbol> fetchSymbolList() {
        return symbolService.fetchSymbolList();
    }

    @GetMapping("/{symbolId}")
    public Symbol getSymbolById(@PathVariable(name = "symbolId") Long id)
        throws ResourceNotFoundException {
            Optional<Symbol> symbolOptional = symbolService.getSymbolById(id);

            if (symbolOptional.isEmpty()) {
                throw new ResourceNotFoundException(String.format("String [%s] not found", id));
            }
            return symbolOptional.get();
    }

    @PostMapping
    @Transactional(rollbackOn = DataAccessException.class)
    public Symbol addSymbol(@RequestBody Symbol symbol) {
        return symbolService.save(symbol);
    }
}
