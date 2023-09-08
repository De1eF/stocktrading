package com.example.stocktrading.util;

import com.example.stocktrading.model.Stock;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StocksDB {
    private final Map<Stock, Long> base = new HashMap<>();
}
