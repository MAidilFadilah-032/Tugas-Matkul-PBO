# Tugas Mata Kuliah Pemograman Berbasis Objek
===============================================
<br>
Nama: Muhammad Aidil Fadilah<br>
Nim: 2509116032<br>
Kelas: Sistem Informasi (A) 2025<br>
<br>
## 1. Penjelasan Studi Kasus<br>
--------------------------------
Studi kasus yang dipilih adalah Sistem Donor Darah, sebuah program sederhana untuk mengelola data pendonor darah, data penerima atau pemohon darah, serta stok darah di sebuah bank darah.
<br>
Program ini mencakup tiga hal utama:<br>
a. Pengelolaan data orang yang terlibat dalam sistem, yaitu Donor, pihak yang menyumbangkan darah dan Penerima, pihak yang membutuhkan darah. Keduanya memiliki data dasar yang sama yaitu nama, umur, golongan darah namun juga punya data khusus masing-masing donor punya riwayat jumlah donor, penerima punya nama rumah sakit tujuan. Karena adanya kesamaan sekaligus perbedaan ini, hubungan keduanya dimodelkan dengan inheritance.<br>
b. Pengelolaan stok darah per golongan yaitu A, B, AB, O yang bertambah saat ada donor baru dan berkurang saat ada permintaan dari penerima.<br>
c. Operasi CRUD C(reate, Read, Update, Delete) untuk data donor dan penerima, dijalankan lewat menu interaktif di console.<br>
<br>
## 2. Hierarki Class<br>
--------------------------------
<img width="691" height="683" alt="image" src="https://github.com/user-attachments/assets/81e5984e-455b-48fd-9bfe-4fa6d1138fea" />
<br>
<img width="628" height="615" alt="image" src="https://github.com/user-attachments/assets/85ff88aa-1c00-4c78-a443-d6497e03b9fd" />
<br>
Penjelasan hierarki:<br>
a. Orang adalah superclass atau induk, bersifat abstract karena tidak pernah dibuat objeknya secara langsung, objek yang benar-benar dipakai selalu berupa Donor atau Penerima.<br>
b. Donor dan Penerima adalah subclass atau anak yang mewarisi seluruh atribut seperti nama, umur, golonganDarah dan method dari Orang, lalu masing-masing menambahkan data spesifiknya sendiri.<br>
c. BankDarah dan Main bukan bagian dari hierarki inheritance, melainkan class yang menggunakan has-a objek Donor atau Penerima untuk mengelola stok darah dan menjalankan operasi CRUD.<br>
<br>

## 3. Penjelasan Kode yang Menerapkan Inheritance<br>
--------------------------------
a. Penjelasan kode superclass Orang.java<br>
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
<br>
- Atribut dideklarasikan dengan modifier protected agar bisa diwarisi dan diakses langsung oleh subclass, bukan hanya lewat getter.<br>
- Method tampilkanInfo() berisi logika umum untuk menampilkan data dasar, yang nantinya dipakai ulang oleh semua subclass.<br>

<br>
b. Penjelasan kode Subclass Donor.java yang berelasi inheritance dengan extends<br>
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
<br>
- Kata kunci extends Orang membuat Donor mewarisi seluruh atribut dan method dari Orang.<br>
- super yaitu nama, umur, golonganDarah memanggil constructor superclass agar data dasar diisi oleh Orang, sehingga Donor tidak perlu menulis ulang logika penyimpanan data tersebut.<br>
- @Override tampilkanInfo() menunjukkan penerapan method overriding: Donor menyediakan tampilan versinya sendiri, tetapi tetap memanggil super.tampilkanInfo() untuk memakai ulang (reuse) logika dari superclass, lalu menambahkan info khusus donor.<br>

<br>
c. Penjelasan kode Subclass Penerima.java<br>
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
<br>
- Pola yang sama seperti Donor, extends Orang, memanggil super(...) di constructor, dan meng-override tampilkanInfo() sambil tetap memanggil super.tampilkanInfo().
- Ini membuktikan satu superclass Orang bisa diwarisi oleh lebih dari satu subclass (Donor dan Penerima), masing-masing dengan spesialisasinya sendiri, inti dari konsep inheritance.

<br>
## 4. Tangkapan Layar Program<br>
--------------------------------<br>
a. Data Donor<br>
<img width="484" height="426" alt="image" src="https://github.com/user-attachments/assets/63509b7c-992f-4335-b363-f3d6dc7a5ef5" />
<br>
Tampilan menu utama program, menampilkan seluruh pilihan CRUD untuk Donor, Penerima, serta menu lihat stok darah.<br>
<img width="584" height="178" alt="image" src="https://github.com/user-attachments/assets/004a66e9-fe0f-4401-a975-7f7f9d7e3934" />
<br>
Create, menambahkan data donor baru bernama Aidil, umur 20, golongan darah B. Stok darah golongan B otomatis bertambah setelah donor diterima.<br>
<img width="273" height="221" alt="image" src="https://github.com/user-attachments/assets/1f529d61-293d-4df8-8ba5-fe998cde6130" />
<br>
Read, menampilkan daftar donor, memperlihatkan data Aidil yang baru saja ditambahkan beserta riwayat Donor ke: 1.<br>
<img width="421" height="346" alt="image" src="https://github.com/user-attachments/assets/00dec6bd-a4b2-48cf-8040-497907bbe970" />
<br>
Update, mengubah data donor pada index 0, umur diperbarui dari 20 menjadi 21.<br>
<img width="246" height="223" alt="image" src="https://github.com/user-attachments/assets/d9b7340f-df56-48a2-9003-486507699b36" />
<br>
Read, memverifikasi perubahan data, umur donor Aidil kini tercatat 21.<br>
<img width="391" height="273" alt="image" src="https://github.com/user-attachments/assets/13db165b-0056-49bb-a124-d57f9994fd10" />
<br>
Delete, menghapus data donor pada index 0 yaitu Aidil.<br>
<img width="265" height="83" alt="image" src="https://github.com/user-attachments/assets/871fe9ea-0a4d-49c5-8d14-2a35c70fc7e6" />
<br>
Read, memverifikasi data donor sudah kosong setelah dihapus dan muncul output belum ada data donor.
<br><br>

b. Data Penerima<br>
<img width="581" height="194" alt="image" src="https://github.com/user-attachments/assets/ace2a41c-4648-4933-9fe6-95a47ac01b3f" />
<br>
Create, menambahkan data penerima baru bernama Fadil, umur 20, membutuhkan golongan darah B, dirawat di RS Dirgahayu. Permintaan langsung berhasil dipenuhi dari stok.<br>
<img width="290" height="220" alt="image" src="https://github.com/user-attachments/assets/75e4383b-d01c-4ffd-9c10-05ae84c3549a" />
<br>
Read, menampilkan daftar penerima, memperlihatkan data Fadil yang baru ditambahkan.<br>
<img width="481" height="384" alt="image" src="https://github.com/user-attachments/assets/5d8d8bc9-d225-4802-96e5-9031a789d6c2" />
<br>
Update, mengubah data penerima pada index 0, umur diperbarui dari 20 menjadi 21 untuk nama, golongan darah, dan rumah sakit tetap sama.<br>
<img width="296" height="226" alt="image" src="https://github.com/user-attachments/assets/fe0ceecc-ed43-4368-8a22-cd14892c245d" />
<br>
Read, memverifikasi perubahan data, umur penerima Fadil kini tercatat 21.<br>
<img width="444" height="273" alt="image" src="https://github.com/user-attachments/assets/0766185d-cee2-471f-a0d1-bef99ceee9bd" />
<br>
Delete, menghapus data penerima pada index 0 yaitu Fadil.<br>
<img width="308" height="90" alt="image" src="https://github.com/user-attachments/assets/ed4ffee4-a40b-4514-a018-de5da3e4886e" />
<br>
Read memverifikasi data penerima sudah kosong setelah dihapus dan hasil outputnya adalah belum ada data penerima.
<br><br>

c. Stok Darah & Keluar<br>
<img width="333" height="171" alt="image" src="https://github.com/user-attachments/assets/59bac9ae-dd36-412c-abca-0d420feaaf93" />
<br>
Menampilkan stok darah saat ini untuk tiap golongan, yaitu A, AB, B, O setelah seluruh proses CRUD dan transaksi donor atau permintaan di atas dijalankan.<br>
<img width="816" height="226" alt="image" src="https://github.com/user-attachments/assets/df439f9b-ba6e-425e-bb8e-5c57f198889b" />
<br>
Memilih menu 0 untuk keluar, program menampilkan pesan penutup dan proses build selesai (BUILD SUCCESS).<br>
