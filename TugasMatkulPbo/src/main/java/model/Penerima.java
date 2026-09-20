public class Penerima extends Orang {
    private String namaRumahSakit;

    public Penerima(String nama, int umur, String golonganDarah, String namaRumahSakit) {
        super(nama, umur, golonganDarah);
        this.namaRumahSakit = namaRumahSakit;
    }

    public String getNamaRumahSakit() {
        return namaRumahSakit;
    }

    public void setNamaRumahSakit(String namaRumahSakit) {
        this.namaRumahSakit = namaRumahSakit;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Penerima ===");
        super.tampilkanInfo();
        System.out.println("Rumah Sakit: " + namaRumahSakit);
    }
}