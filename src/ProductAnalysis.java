import java.util.*;
import java.util.stream.Collectors;

public class ProductAnalysis {

    private List<Product> products;

    public ProductAnalysis(List<Product> products) {
        this.products = products;
    }

    public void showAllProducts() {
        System.out.println("All Products:");
        products.stream()
                .map(Product::getName)
                .forEach(System.out::println);
    }

    public void showProductsWithNameLengthLessThan(int length) {
        System.out.println("\nProducts with name length less than " + length + ":");
        products.stream()
                .map(Product::getName)
                .filter(name -> name.length() < length)
                .forEach(System.out::println);
    }

    public void countProductOccurrences(String productName) {
        long count = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .count();
        System.out.println("\nProduct '" + productName + "' occurs " + count + " times.");
    }

    public void showProductsStartingWith(char letter) {
        System.out.println("\nProducts starting with '" + letter + "':");
        products.stream()
                .map(Product::getName)
                .filter(name -> name.startsWith(String.valueOf(letter)))
                .forEach(System.out::println);
    }

    public void showProductsFromCategory(String category) {
        System.out.println("\nProducts from category '" + category + "':");
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .map(Product::getName)
                .forEach(System.out::println);
    }

    // For testing purposes
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product("Milk", "Dairy"),
                new Product("Bread", "Bakery"),
                new Product("Cheese", "Dairy"),
                new Product("Butter", "Dairy"),
                new Product("Apple", "Fruit"),
                new Product("Banana", "Fruit"),
                new Product("Milk", "Dairy")
        );

        ProductAnalysis analysis = new ProductAnalysis(productList);
        analysis.showAllProducts();
        analysis.showProductsWithNameLengthLessThan(5);
        analysis.countProductOccurrences("Milk");
        analysis.showProductsStartingWith('B');
        analysis.showProductsFromCategory("Dairy");
    }
}
