public abstract class Orang {
    protected String nama;
    protected int umur;
    protected String golonganDarah;

    public Orang(String nama, int umur, String golonganDarah) {
        this.nama = nama;
        this.umur = umur;
        this.golonganDarah = golonganDarah;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Golongan Darah: " + golonganDarah);
    }
}