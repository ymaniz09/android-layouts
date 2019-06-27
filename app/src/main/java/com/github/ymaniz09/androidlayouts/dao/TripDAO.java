package com.github.ymaniz09.androidlayouts.dao;

import com.github.ymaniz09.androidlayouts.model.Trip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripDAO {
    public List<Trip> getMock() {
        return new ArrayList<>(Arrays.asList(
                new Trip("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99)),
                new Trip("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal(421.50)),
                new Trip("Recife", "recife_pe", 4, new BigDecimal(754.20)),
                new Trip("Rio de Janeiro", "rio_de_janeiro_rj", 6, new BigDecimal(532.55)),
                new Trip("Salvador", "salvador_ba", 5, new BigDecimal(899.99)),
                new Trip("Foz do Iguaçu", "foz_do_iguacu_pr", 1, new BigDecimal(289.90))));
    }
}
