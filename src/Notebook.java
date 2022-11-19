import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notebook {

    /*
    In this class, we added our computers according to our brands. We added three computers in advance so that we could check that our classroom was working correctly, and we wanted this to be printed out. In addition, our codes are written in a convenient way so that the user can have product deletion, product addition and product filtering features here.
     */

    private int id;
    private double unitPrice;
    private double discountRate;
    private int qualityInStock;
    private String productName;
    private String brandName;
    private int ram;
    private double screenSize;
    private int memory;


    public Notebook(int id, double unitPrice, double discountRate, int qualityInStock,
                    String productName, String brandName, int ram, double screenSize, int memory) {
        super();
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.qualityInStock = qualityInStock;
        this.productName = productName;
        this.brandName = brandName;
        this.ram = ram;
        this.screenSize = screenSize;
        this.memory = memory;
    }

    public static List<Notebook> notebook = new ArrayList<>();

    public static List<Notebook> add() {
        Scanner input = new Scanner(System.in);

        System.out.print("ÜrünAdı : ");
        String productName = input.next();
        System.out.println();

        System.out.print("Fiyat : ");
        double unitPrice = input.nextDouble();
        System.out.println();

        int i = 1;
        for (Brand brand : Brand.brands()) {
            System.out.println(i + brand.getName());
            i++;
        }
        System.out.println();

        System.out.print("Marka : ");
        int brandid = input.nextInt();
        System.out.println();

        System.out.print("Depolama : ");
        int memory = input.nextInt();
        System.out.println();

        System.out.print("Ekran : ");
        int screenSize = input.nextInt();
        System.out.println();

        System.out.print("Ram : ");
        int ram = input.nextInt();
        System.out.println();

        String brandname = null;
        for (Brand brand : Brand.brands()) {
            if (brand.getId() == brandid) {
                brandname = brand.getName();
            }
        }
        int id = 0;
        for (Notebook notebook : notebook) {
            if (notebook.getId() > id) {
                id = notebook.getId();
            }
        }
        id++;
        notebook.add(new Notebook(id, unitPrice, 0, 0, productName, brandname, ram, screenSize, memory));
        return notebook;
    }

    public static boolean remove(int id) {
        try {
            notebook.remove(id - 1);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static List<Notebook> filtreId(int id) {
        List<Notebook> filtreList = new ArrayList<>();
        for (Notebook notebook : notebook) {
            if (notebook.getId() == id) {
                filtreList.add(notebook);
            }
        }
        return filtreList;
    }

    public static List<Notebook> filtreBrand(int id) {

        List<Notebook> filtreList = new ArrayList<>();
        for (Notebook notebook : notebook) {
            if (notebook.getBrandName() == Brand.brand(id)) {
                filtreList.add(notebook);
            }
        }
        return filtreList;
    }

    public static List<Notebook> notebooks() {

        notebook.add(new Notebook(1, 3199.0, 0.0, 5, "HUAWEI Matebook D15", Brand.brand(4), 16, 14, 512));
        notebook.add(new Notebook(2, 7379.0, 0.0, 5, "LENOVO V15  ", Brand.brand(2), 8, 14, 1024));
        notebook.add(new Notebook(3, 4012.0, 0.0, 5, "ASUS Tuf Gaming F15", Brand.brand(6), 32, 15.6, 2048));
        return notebook;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getQualityInStock() {
        return qualityInStock;
    }

    public void setQualityInStock(int qualityInStock) {
        this.qualityInStock = qualityInStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }


}