package com.vesche.portfolio_vesche.finances;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class FinancesController {

    private final FinancesService financesService;

    FinancesController(FinancesService financesService) {
        this.financesService = financesService;
    }

    public ResponseEntity<Integer> retrieveFinancesFromTicker

}
