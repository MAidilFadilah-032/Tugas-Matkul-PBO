import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankDarah {
    private Map<String, Integer> stokDarah;
    private List<Donor> daftarDonor;
    private List<Penerima> daftarPenerima;

    public BankDarah() {
        stokDarah = new HashMap<>();
        stokDarah.put("A", 5);
        stokDarah.put("B", 5);
        stokDarah.put("AB", 3);
        stokDarah.put("O", 5);

        daftarDonor = new ArrayList<>();
        daftarPenerima = new ArrayList<>();
    }

    public void tambahDonor(Donor donor) {
        daftarDonor.add(donor);
        System.out.println(">> Data donor " + donor.getNama() + " berhasil ditambahkan.");
    }

    public void lihatSemuaDonor() {
        System.out.println("=== Daftar Donor ===");
        if (daftarDonor.isEmpty()) {
            System.out.println("(belum ada data donor)");
            return;
        }
        for (int i = 0; i < daftarDonor.size(); i++) {
            System.out.println("[" + i + "]");
            daftarDonor.get(i).tampilkanInfo();
        }
    }

    public void updateDonor(int index, String namaBaru, int umurBaru, String golonganBaru) {
        if (index < 0 || index >= daftarDonor.size()) {
            System.out.println(">> Data donor dengan index tersebut tidak ditemukan.");
            return;
        }
        Donor donor = daftarDonor.get(index);
        donor.setNama(namaBaru);
        donor.setUmur(umurBaru);
        donor.setGolonganDarah(golonganBaru);
        System.out.println(">> Data donor index " + index + " berhasil diupdate.");
    }

    public void hapusDonor(int index) {
        if (index < 0 || index >= daftarDonor.size()) {
            System.out.println(">> Data donor dengan index tersebut tidak ditemukan.");
            return;
        }
        Donor dihapus = daftarDonor.remove(index);
        System.out.println(">> Data donor " + dihapus.getNama() + " berhasil dihapus.");
    }

    
    public void tambahPenerima(Penerima penerima) {
        daftarPenerima.add(penerima);
        System.out.println(">> Data penerima " + penerima.getNama() + " berhasil ditambahkan.");
    }

    public void lihatSemuaPenerima() {
        System.out.println("=== Daftar Penerima ===");
        if (daftarPenerima.isEmpty()) {
            System.out.println("(belum ada data penerima)");
            return;
        }
        for (int i = 0; i < daftarPenerima.size(); i++) {
            System.out.println("[" + i + "]");
            daftarPenerima.get(i).tampilkanInfo();
        }
    }

    public void updatePenerima(int index, String namaBaru, int umurBaru, String golonganBaru, String rsBaru) {
        if (index < 0 || index >= daftarPenerima.size()) {
            System.out.println(">> Data penerima dengan index tersebut tidak ditemukan.");
            return;
        }
        Penerima penerima = daftarPenerima.get(index);
        penerima.setNama(namaBaru);
        penerima.setUmur(umurBaru);
        penerima.setGolonganDarah(golonganBaru);
        penerima.setNamaRumahSakit(rsBaru);
        System.out.println(">> Data penerima index " + index + " berhasil diupdate.");
    }

    public void hapusPenerima(int index) {
        if (index < 0 || index >= daftarPenerima.size()) {
            System.out.println(">> Data penerima dengan index tersebut tidak ditemukan.");
            return;
        }
        Penerima dihapus = daftarPenerima.remove(index);
        System.out.println(">> Data penerima " + dihapus.getNama() + " berhasil dihapus.");
    }

    
    public List<Donor> getDaftarDonor() {
        return daftarDonor;
    }

    public List<Penerima> getDaftarPenerima() {
        return daftarPenerima;
    }

    public void terimaDonor(Donor donor) {
        String gol = donor.getGolonganDarah();
        stokDarah.put(gol, stokDarah.getOrDefault(gol, 0) + 1);
        donor.tambahRiwayatDonor();
        System.out.println(">> Donor darah dari " + donor.getNama() + " diterima. Stok " + gol + " bertambah.");
    }

    public void prosesPermintaan(Penerima penerima) {
        String gol = penerima.getGolonganDarah();
        int stok = stokDarah.getOrDefault(gol, 0);
        if (stok > 0) {
            stokDarah.put(gol, stok - 1);
            System.out.println(">> Permintaan darah untuk " + penerima.getNama() + " (" + gol + ") berhasil dipenuhi.");
        } else {
            System.out.println(">> Maaf, stok darah golongan " + gol + " sedang kosong untuk " + penerima.getNama() + ".");
        }
    }

    public void tampilkanStok() {
        System.out.println("=== Stok Darah Saat Ini ===");
        for (Map.Entry<String, Integer> entry : stokDarah.entrySet()) {
            System.out.println("Golongan " + entry.getKey() + " : " + entry.getValue() + " kantong");
        }
    }
}