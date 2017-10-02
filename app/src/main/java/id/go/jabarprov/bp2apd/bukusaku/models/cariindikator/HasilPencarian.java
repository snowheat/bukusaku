package id.go.jabarprov.bp2apd.bukusaku.models.cariindikator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import id.go.jabarprov.bp2apd.bukusaku.activities.CariIndikatorActivity;

public class HasilPencarian {
    @SerializedName("kata_kunci_pencarian")
    @Expose
    public String kataKunciPencarian;

    @SerializedName("indikator")
    @Expose
    public ArrayList<Indikator> indikator = null;

    public String getKataKunciPencarian() {
        return kataKunciPencarian;
    }

    public void setKataKunciPencarian(String kataKunciPencarian) {
        this.kataKunciPencarian = kataKunciPencarian;
    }

    public ArrayList<Indikator> getIndikator() {
        return indikator;
    }

    public void setIndikator(ArrayList<Indikator> indikator) {
        this.indikator = indikator;
    }
}
