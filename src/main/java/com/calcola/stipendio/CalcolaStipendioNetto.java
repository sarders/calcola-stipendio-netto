package com.calcola.stipendio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/stipendio")
public class CalcolaStipendioNetto {

    @GetMapping("/{stipendioLordo}")
    public double calcolaNetto(@PathVariable double stipendioLordo) {
        return calcolaStipendioNetto(stipendioLordo);
    }

    private double calcolaStipendioNetto(double stipendioLordo) {
        double irpef = calcolaIRPEF(stipendioLordo);
        double inps = stipendioLordo * 0.0919;
        return stipendioLordo - irpef - inps;
    }

    private double calcolaIRPEF(double stipendioLordo) {
        double irpef = 0;

        if (stipendioLordo <= 15000) {
            irpef = stipendioLordo * 0.23;
        } else if (stipendioLordo <= 28000) {
            irpef = 3450 + (stipendioLordo - 15000) * 0.25;
        } else if (stipendioLordo <= 50000) {
            irpef = 6825 + (stipendioLordo - 28000) * 0.35;
        } else {
            irpef = 15325 + (stipendioLordo - 50000) * 0.43;
        }

        return irpef;
    }
}
