public class Product {

    private String name;
    private int quantity;
    private double price;

    public Product(String productName, double productPrice, int productQuantity){
        this.name = productName;
        this.price = productPrice;
        this.quantity = productQuantity;
    }

    public void printProduct() {
        System.out.println(name + ", " + "price " + price + ", " + quantity + "pcs");
    }
}
