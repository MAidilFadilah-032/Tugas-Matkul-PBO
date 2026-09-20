public class Donor extends Orang {
    private int jumlahDonorKe; 

    public Donor(String nama, int umur, String golonganDarah, int jumlahDonorKe) {
        super(nama, umur, golonganDarah); 
        this.jumlahDonorKe = jumlahDonorKe;
    }

    public int getJumlahDonorKe() {
        return jumlahDonorKe;
    }

    public void tambahRiwayatDonor() {
        jumlahDonorKe++;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Donor ===");
        super.tampilkanInfo(); 
        System.out.println("Donor ke: " + jumlahDonorKe);
    }
}