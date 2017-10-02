package id.go.jabarprov.bp2apd.bukusaku.models.cariindikator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import id.go.jabarprov.bp2apd.bukusaku.activities.CariIndikatorActivity;

public class Indikator{
    @SerializedName("id_indikator")
    @Expose
    public Integer idIndikator;

    @SerializedName("nama_indikator")
    @Expose
    public String namaIndikator;

    @SerializedName("singkatan_indikator")
    @Expose
    public String singkatanIndikator;

    @SerializedName("satuan")
    @Expose
    public String satuan;

    @SerializedName("id_daerah")
    @Expose
    public Integer idDaerah;

    @SerializedName("nilai_per_tahun")
    @Expose
    public ArrayList<NilaiPerTahun> nilaiPerTahun;

    public Integer getIdIndikator() {
        return idIndikator;
    }

    public void setIdIndikator(Integer idIndikator) {
        this.idIndikator = idIndikator;
    }

    public String getNamaIndikator() {
        return namaIndikator;
    }

    public void setNamaIndikator(String namaIndikator) {
        this.namaIndikator = namaIndikator;
    }

    public String getSingkatanIndikator() {
        return singkatanIndikator;
    }

    public void setSingkatanIndikator(String singkatanIndikator) {
        this.singkatanIndikator = singkatanIndikator;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Integer getIdDaerah() {
        return idDaerah;
    }

    public void setIdDaerah(Integer idDaerah) {
        this.idDaerah = idDaerah;
    }

    public ArrayList<NilaiPerTahun> getNilaiPerTahun() {
        return nilaiPerTahun;
    }

    public void setNilaiPerTahun(ArrayList<NilaiPerTahun> nilaiPerTahun) {
        this.nilaiPerTahun = nilaiPerTahun;
    }
}
