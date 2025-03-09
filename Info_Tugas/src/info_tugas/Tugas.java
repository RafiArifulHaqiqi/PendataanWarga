/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info_tugas;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Tugas {

    // Konstanta untuk batas maksimal tugas
    private static final int MAX_TUGAS = 10;

    public static void main(String[] args) {
        // ArrayList untuk menyimpan daftar tugas
        ArrayList<Tugas> daftarTugas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        // Menu utama
        do {
            System.out.println("\n=== Aplikasi Pengelolaan Tugas Proyek ===");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Daftar Tugas");
            System.out.println("3. Tandai Tugas Selesai");
            System.out.println("4. Hapus Tugas");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    tambahTugas(daftarTugas, scanner);
                    break;
                case 2:
                    lihatDaftarTugas(daftarTugas);
                    break;
                case 3:
                    tandaiTugasSelesai(daftarTugas, scanner);
                    break;
                case 4:
                    hapusTugas(daftarTugas, scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);

        scanner.close();
    }

    // Method untuk menambah tugas
    private static void tambahTugas(ArrayList<Tugas> daftarTugas, Scanner scanner) {
        if (daftarTugas.size() >= MAX_TUGAS) {
            System.out.println("Daftar tugas sudah penuh!");
            return;
        }

        System.out.print("Masukkan nama tugas: ");
        String namaTugas = scanner.nextLine();
        daftarTugas.add(new Tugas(namaTugas));
        System.out.println("Tugas berhasil ditambahkan!");
    }

    // Method untuk melihat daftar tugas
    private static void lihatDaftarTugas(ArrayList<Tugas> daftarTugas) {
        if (daftarTugas.isEmpty()) {
            System.out.println("Daftar tugas kosong!");
            return;
        }

        System.out.println("\nDaftar Tugas:");
        for (int i = 0; i < daftarTugas.size(); i++) {
            Tugas tugas = daftarTugas.get(i);
            System.out.println((i + 1) + ". " + tugas.getNama() + " - " + (tugas.isSelesai() ? "Selesai" : "Belum Selesai"));
        }
    }

    // Method untuk menandai tugas selesai
    private static void tandaiTugasSelesai(ArrayList<Tugas> daftarTugas, Scanner scanner) {
        if (daftarTugas.isEmpty()) {
            System.out.println("Daftar tugas kosong!");
            return;
        }

        lihatDaftarTugas(daftarTugas);
        System.out.print("Pilih nomor tugas yang sudah selesai: ");
        int nomorTugas = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        if (nomorTugas < 1 || nomorTugas > daftarTugas.size()) {
            System.out.println("Nomor tugas tidak valid!");
        } else {
            Tugas tugas = daftarTugas.get(nomorTugas - 1);
            tugas.setSelesai(true);
            System.out.println("Tugas '" + tugas.getNama() + "' telah ditandai sebagai selesai!");
        }
    }

    // Method untuk menghapus tugas
    private static void hapusTugas(ArrayList<Tugas> daftarTugas, Scanner scanner) {
        if (daftarTugas.isEmpty()) {
            System.out.println("Daftar tugas kosong!");
            return;
        }

        lihatDaftarTugas(daftarTugas);
        System.out.print("Pilih nomor tugas yang ingin dihapus: ");
        int nomorTugas = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        if (nomorTugas < 1 || nomorTugas > daftarTugas.size()) {
            System.out.println("Nomor tugas tidak valid!");
        } else {
            Tugas tugas = daftarTugas.remove(nomorTugas - 1);
            System.out.println("Tugas '" + tugas.getNama() + "' telah dihapus!");
        }
    }
}

// Class Tugas untuk merepresentasikan sebuah tugas
class Tugas {
    private String nama;
    private boolean selesai;

    public Tugas(String nama) {
        this.nama = nama;
        this.selesai = false; // Default status: belum selesai
    }

    public String getNama() {
        return nama;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void setSelesai(boolean selesai) {
        this.selesai = selesai;
    }
}
