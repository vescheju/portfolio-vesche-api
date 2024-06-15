package com.vesche.portfolio_vesche.finances;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinancesController {

    private final FinancesService financesService;

    FinancesController(FinancesService financesService) {
        this.financesService = financesService;
    }

//    @Operation(summary = "Retrieves a response regards to a specific stock via its ticker.")
//    @GetMapping("stocks/")
//    public ResponseEntity<Integer> retrieveFinancesFromTicker()

}
