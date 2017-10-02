package id.go.jabarprov.bp2apd.bukusaku.models.cariindikator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NilaiPerTahun{
    @SerializedName("tahun")
    @Expose
    public Integer tahun;

    @SerializedName("nilai")
    @Expose
    public String nilai;

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}