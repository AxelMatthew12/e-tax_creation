package Esamsat;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void register() {
        System.out.print("Masukkan ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("ID tidak boleh kosong.");
            return;
        }

        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine().trim();
        if (password.isEmpty()) {
            System.out.println("Password tidak boleh kosong.");
            return;
        }

        users.add(new User(id, password));
        System.out.println("Registrasi berhasil. Silakan login.");
    }

    private static void login() {
        if (users.isEmpty()) {
            System.out.println("Belum ada user yang terdaftar. Silakan registrasi terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine().trim();

        boolean idFound = false;
        for (User user : users) {
            if (user.getId().equals(id)) {
                idFound = true;
                if (user.checkPassword(password)) {
                    System.out.println("Login berhasil. Selamat datang!");
                    // Tambahkan kode untuk masuk ke menu selanjutnya di sini
                    return;
                } else {
                    System.out.println("Password salah. Silakan coba lagi.");
                    return;
                }
            }
        }

        if (!idFound) {
            System.out.println("ID tidak ditemukan. Silakan coba lagi.");
        }
    }
}
