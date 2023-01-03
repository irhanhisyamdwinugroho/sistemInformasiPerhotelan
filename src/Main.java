import java.util.ArrayList;
import java.util.Scanner;

// Kelas Customer untuk menyimpan data customer
class Customer {
    private String name;
    private String address;
    private String phone;
    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

// Kelas Room untuk menyimpan data kamar
class Room {
    private int number;
    private String type;
    private int price;

    public Room(int number, String type, int price) {
        this.number = number;
        this.type = type;
        this.price = price;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

// Kelas Hotel untuk mengelola data customer, kamar, dan pemesanan
class Hotel {
    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;

    public Hotel() {
        customers = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    // Method untuk menambahkan customer baru
    public void addCustomer(String name, String address, String phone) {
        Customer newCustomer = new Customer(name, address, phone);
        customers.add(newCustomer);
    }

    // Method untuk menampilkan data customer
    public void showCustomers() {
        for (Customer c : customers) {
            System.out.println("Nama: " + c.getName());
            System.out.println("Alamat: " + c.getAddress());
            System.out.println("Telepon: " + c.getPhone());
            System.out.println();
        }
    }

    // Method untuk menambahkan kamar baru
    public void addRoom(int number, String type, int price) {
        Room newRoom = new Room(number, type, price);
        rooms.add(newRoom);
    }

    // Method untuk menampilkan data kamar
    public void showRooms() {
        for (Room r : rooms) {
            System.out.println("Nomor Kamar: " + r.getNumber());
            System.out.println("Tipe Kamar: " + r.getType());
            System.out.println("Harga Kamar: " + r.getPrice());
            System.out.println();
        }
    }

    // Method untuk melakukan pemesanan kamar
    public void bookRoom(int roomNumber, String customerName, int days) {
        // Cari kamar yang akan dipesan
        Room bookedRoom = null;
        for (Room r : rooms) {
            if (r.getNumber() == roomNumber) {
                bookedRoom = r;
                break;
            }
        }

        // Cari customer yang akan memesan
        Customer bookedCustomer = null;
        for (Customer c : customers) {
            if (c.getName().equals(customerName)) {
                bookedCustomer = c;
                break;
            }
        }

        if (bookedRoom != null && bookedCustomer != null) {
            // Beri tahu customer bahwa kamar telah dipesan
            System.out.println("Kamar nomor " + bookedRoom.getNumber() + " telah dipesan oleh " + bookedCustomer.getName() + " selama " + days + " hari.");

            // Hitung harga yang harus dibayar oleh customer
            int totalPrice = bookedRoom.getPrice() * days;
            System.out.println("Total harga yang harus dibayar adalah: " + totalPrice);
        } else {
            System.out.println("Maaf, kamar atau customer tidak ditemukan.");
        }
    }

    // Method untuk menampilkan jumlah pendapatan hotel
    public void showIncome() {
        int totalIncome = 0;
        for (Room r : rooms) {
            totalIncome += r.getPrice();
        }
        System.out.println("Jumlah pendapatan hotel adalah: " + totalIncome);
    }
}

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.println();
        System.out.println("##Welcome to Program Perhotelan ##");
        System.out.println();
        System.out.println("Pilih Akun Kamu :");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.print("Masukan pilihan : ");
        int akun = scanner.nextInt();
        switch (akun) {
            case 1:

                System.out.println();
                System.out.println("Welcome Admin Hotel Singaraja");
                System.out.println("==============================");
                System.out.println();
                System.out.println("1. Tampilkan data customer");
                System.out.println("2. Tambah Kamar");
                System.out.println("3. tambah pelanggan");
                System.out.println("4. Jumlah pendapatan hotel");
                System.out.println("5. tampilkan data kamar");
                System.out.println("6. Tampilkan data customer");
                System.out.println("7. Keluar");
                System.out.print("Masukan pilihan : ");
                int menu1 = scanner.nextInt();

                switch (menu1) {

                    case 1:
                        hotel.showCustomers();
                        break;

                    case 2:
                        System.out.print("Masukkan nomor kamar: ");
                        int number = scanner.nextInt();
                        System.out.print("Masukkan tipe kamar: ");
                        String type = scanner.next();
                        System.out.print("Masukkan harga kamar: ");
                        int price = scanner.nextInt();
                        hotel.addRoom(number, type, price);
                        System.out.println("Kamar berhasil ditambahkan.");
                        break;

                    case 3:
                        System.out.print("Masukkan nama customer: ");
                        String name = scanner.next();
                        System.out.print("Masukkan alamat customer: ");
                        String address = scanner.next();
                        System.out.print("Masukkan nomor telepon customer: ");
                        String phone = scanner.next();
                        hotel.addCustomer(name, address, phone);
                        System.out.println("Customer berhasil ditambahkan.");
                        break;
                    case 4:
                        hotel.showIncome();
                        break;
                    case 5:
                        hotel.showRooms();
                        break;
                    case 6:
                        hotel.showCustomers();
                        break;
                    case 7:
                        //keluar program
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                        break;
                }
                break;

            case 2:

                System.out.println();
                System.out.println();
                System.out.println("Welcome Customer  Hotel Singaraja");
                System.out.println("==============================");
                System.out.println();
                System.out.println("1. cari Kamar");
                System.out.println("2. tampilkan data customer");
                System.out.println("3. keluar");
                System.out.print("masukkan pilihan : ");
                int menu2 = scanner.nextInt();

                switch (menu2) {
                    case 1:
                        System.out.print("Masukkan nomor kamar: ");
                        int number = scanner.nextInt();
                        System.out.print("Masukkan nama customer: ");
                        String name = scanner.next();
                        System.out.print("Masukkan jumlah hari: ");
                        int days = scanner.nextInt();
                        hotel.bookRoom(number, name, days);
                        break;
                    case 2:
                        //keluar program
                        hotel.showCustomers();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Menu yang anda pilih tidak tersedia");
                        break;
                }
             }
        }
    }
}
