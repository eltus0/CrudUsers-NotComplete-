package org.david.crudusers.models;

public enum GenFav {

    High_Energy("High Energy"), Pop("Pop"), Rock("Rock"), Electronica("Electronica");

    private final String generoFavorito;

    GenFav(String generoFavorito) {
        this.generoFavorito = generoFavorito;
    }

    public String getGeneroFavorito() {
        return generoFavorito;
    }
}
