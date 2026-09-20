import java.util.Scanner;

public class TugasMatkulPbo {
    static BankDarah bank = new BankDarah();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = bacaInt("Pilih menu: ");
            switch (pilihan) {
                case 1 -> tambahDonor();
                case 2 -> bank.lihatSemuaDonor();
                case 3 -> updateDonor();
                case 4 -> hapusDonor();
                case 5 -> tambahPenerima();
                case 6 -> bank.lihatSemuaPenerima();
                case 7 -> updatePenerima();
                case 8 -> hapusPenerima();
                case 9 -> bank.tampilkanStok();
                case 0 -> System.out.println("Program selesai. Terima kasih.");
                default -> System.out.println(">> Pilihan tidak valid.");
            }
            System.out.println();
        } while (pilihan != 0);

        sc.close();
    }

    static void tampilkanMenu() {
        System.out.println("========== SISTEM DONOR DARAH ==========");
        System.out.println("--- Data Donor ---");
        System.out.println("1. Tambah Donor");
        System.out.println("2. Lihat Semua Donor");
        System.out.println("3. Update Donor");
        System.out.println("4. Hapus Donor");
        System.out.println("--- Data Penerima ---");
        System.out.println("5. Tambah Penerima");
        System.out.println("6. Lihat Semua Penerima");
        System.out.println("7. Update Penerima");
        System.out.println("8. Hapus Penerima");
        System.out.println("--- Stok Darah ---");
        System.out.println("9. Lihat Stok Darah");
        System.out.println("0. Keluar");
        System.out.println("=========================================");
    }

 
    static void tambahDonor() {
        String nama = bacaString("Nama donor: ");
        int umur = bacaInt("Umur: ");
        String golongan = bacaString("Golongan darah (A/B/AB/O): ");
        Donor donor = new Donor(nama, umur, golongan, 0);
        bank.tambahDonor(donor);
        bank.terimaDonor(donor); 
    }

    static void updateDonor() {
        bank.lihatSemuaDonor();
        if (bank.getDaftarDonor().isEmpty()) return;
        int index = bacaInt("Index donor yang akan diupdate: ");
        String nama = bacaString("Nama baru     : ");
        int umur = bacaInt("Umur baru: ");
        String golongan = bacaString("Golongan darah baru: ");
        bank.updateDonor(index, nama, umur, golongan);
    }

    static void hapusDonor() {
        bank.lihatSemuaDonor();
        if (bank.getDaftarDonor().isEmpty()) return;
        int index = bacaInt("Index donor yang akan dihapus: ");
        bank.hapusDonor(index);
    }


    static void tambahPenerima() {
        String nama = bacaString("Nama penerima: ");
        int umur = bacaInt("Umur: ");
        String golongan = bacaString("Golongan darah dibutuhkan (A/B/AB/O): ");
        String rs = bacaString("Nama rumah sakit: ");
        Penerima penerima = new Penerima(nama, umur, golongan, rs);
        bank.tambahPenerima(penerima);
        bank.prosesPermintaan(penerima);
    }

    static void updatePenerima() {
        bank.lihatSemuaPenerima();
        if (bank.getDaftarPenerima().isEmpty()) return;
        int index = bacaInt("Index penerima yang akan diupdate: ");
        String nama = bacaString("Nama baru: ");
        int umur = bacaInt("Umur baru: ");
        String golongan = bacaString("Golongan darah baru: ");
        String rs = bacaString("Rumah sakit baru: ");
        bank.updatePenerima(index, nama, umur, golongan, rs);
    }

    static void hapusPenerima() {
        bank.lihatSemuaPenerima();
        if (bank.getDaftarPenerima().isEmpty()) return;
        int index = bacaInt("Index penerima yang akan dihapus: ");
        bank.hapusPenerima(index);
    }

    static String bacaString(String label) {
        System.out.print(label);
        return sc.nextLine();
    }

    static int bacaInt(String label) {
        System.out.print(label);
        while (!sc.hasNextInt()) {
            System.out.print("Masukkan angka yang valid: ");
            sc.next();
        }
        int nilai = sc.nextInt();
        sc.nextLine();
        return nilai;
    }
}