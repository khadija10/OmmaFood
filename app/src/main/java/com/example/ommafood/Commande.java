package com.example.ommafood;

public class Commande {
    String repas, addresse, telephone;

    public Commande(String repas, String addresse, String telephone) {
        this.repas = repas;
        this.addresse = addresse;
        this.telephone = telephone;
    }

    public Commande() {
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
