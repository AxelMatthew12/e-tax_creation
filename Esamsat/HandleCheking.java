package Esamsat;

import java.util.HashMap;
import java.util.Scanner;

public class HandleCheking {
    // Simulasi database kendaraan terdaftar
    private static HashMap<String, Vehicle> vehicleDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HandleCheking handleCheking = new HandleCheking();
        handleCheking.run();
    }

    public void run() {
        System.out.println("Selamat datang di Sistem Esamsat!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cek Kendaraan");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    checkVehicle();
                    break;
                case 2:
                    System.out.println("Terima kasih telah menggunakan Sistem Esamsat.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void checkVehicle() {
        System.out.print("Masukkan nomor polisi: ");
        String plateNumber = scanner.nextLine();

        System.out.print("Masukkan ID pengguna: ");
        String userId = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        // Cek apakah kendaraan sudah terdaftar
        if (vehicleDatabase.containsKey(plateNumber)) {
            Vehicle vehicle = vehicleDatabase.get(plateNumber);

            // Cek apakah ID pengguna dan password sesuai
            if (vehicle.getUserId().equals(userId) && vehicle.getPassword().equals(password)) {
                System.out.println("Kendaraan ditemukan: " + vehicle);
            } else {
                System.out.println("ID pengguna atau password salah.");
            }
        } else {
            System.out.println("Kendaraan belum terdaftar. Silakan lakukan registrasi.");
            // Panggil metode registrasi kendaraan di kelas lain
            registerVehicle(plateNumber, userId, password);
        }
    }

    private void registerVehicle(String plateNumber, String userId, String password) {
        // Logika registrasi kendaraan
        // Misalnya, panggil kelas lain yang menangani registrasi kendaraan
        // Simulasi registrasi kendaraan
        Vehicle newVehicle = new Vehicle(plateNumber, userId, password);
        vehicleDatabase.put(plateNumber, newVehicle);
        System.out.println("Registrasi kendaraan berhasil.");
    }
}

class Vehicle {
    private String plateNumber;
    private String userId;
    private String password;

    public Vehicle(String plateNumber, String userId, String password) {
        this.plateNumber = plateNumber;
        this.userId = userId;
        this.password = password;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
