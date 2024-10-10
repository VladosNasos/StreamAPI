import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectorAnalysis {

    private List<Projector> projectors;

    public ProjectorAnalysis(List<Projector> projectors) {
        this.projectors = projectors;
    }

    public void showAllProjectors() {
        System.out.println("All Projectors:");
        projectors.forEach(System.out::println);
    }

    public void showProjectorsByManufacturer(String manufacturer) {
        System.out.println("\nProjectors by manufacturer '" + manufacturer + "':");
        projectors.stream()
                .filter(p -> p.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(System.out::println);
    }

    public void showProjectorsOfCurrentYear() {
        int currentYear = java.time.Year.now().getValue();
        System.out.println("\nProjectors from the current year (" + currentYear + "):");
        projectors.stream()
                .filter(p -> p.getYear() == currentYear)
                .forEach(System.out::println);
    }

    public void showProjectorsMoreExpensiveThan(double price) {
        System.out.println("\nProjectors more expensive than " + price + ":");
        projectors.stream()
                .filter(p -> p.getPrice() > price)
                .forEach(System.out::println);
    }

    public void showProjectorsSortedByPriceAscending() {
        System.out.println("\nProjectors sorted by price (ascending):");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);
    }

    public void showProjectorsSortedByPriceDescending() {
        System.out.println("\nProjectors sorted by price (descending):");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .forEach(System.out::println);
    }

    public void showProjectorsSortedByYearAscending() {
        System.out.println("\nProjectors sorted by year (ascending):");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYear))
                .forEach(System.out::println);
    }

    public void showProjectorsSortedByYearDescending() {
        System.out.println("\nProjectors sorted by year (descending):");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYear).reversed())
                .forEach(System.out::println);
    }

    // For testing purposes
    public static void main(String[] args) {
        List<Projector> projectorList = List.of(
                new Projector("Projector A", 2022, 799.99, "Epson"),
                new Projector("Projector B", 2023, 899.99, "Sony"),
                new Projector("Projector C", 2023, 999.99, "Epson"),
                new Projector("Projector D", 2021, 699.99, "BenQ"),
                new Projector("Projector E", 2023, 849.99, "Sony")
        );

        ProjectorAnalysis analysis = new ProjectorAnalysis(projectorList);
        analysis.showAllProjectors();
        analysis.showProjectorsByManufacturer("Sony");
        analysis.showProjectorsOfCurrentYear();
        analysis.showProjectorsMoreExpensiveThan(800);
        analysis.showProjectorsSortedByPriceAscending();
        analysis.showProjectorsSortedByPriceDescending();
        analysis.showProjectorsSortedByYearAscending();
        analysis.showProjectorsSortedByYearDescending();
    }
}
