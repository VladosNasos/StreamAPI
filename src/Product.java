public class Product {
    private String name;
    private String category;

    public Product(String name) {
        this.name = name;
        this.category = "";
    }

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
