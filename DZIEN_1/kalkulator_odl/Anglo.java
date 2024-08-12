package com.marcin.kalkulator_odl;

public class Anglo extends MiaraAnglo implements IPrzeliczniki{


    public Anglo(double odl, double mang) {
        super(odl, mang);
    }

    @Override
    public double policzOdl() {
        return odl/mang;
    }
}
