import java.util.List;
import java.util.stream.Collectors;

public class DeviceAnalysis {

    private List<Device> devices;

    public DeviceAnalysis(List<Device> devices) {
        this.devices = devices;
    }

    public void showAllDevices() {
        System.out.println("All Devices:");
        devices.forEach(System.out::println);
    }

    public void showDevicesByColor(String color) {
        System.out.println("\nDevices with color '" + color + "':");
        devices.stream()
                .filter(d -> d.getColor().equalsIgnoreCase(color))
                .forEach(System.out::println);
    }

    public void showDevicesByYear(int year) {
        System.out.println("\nDevices from year " + year + ":");
        devices.stream()
                .filter(d -> d.getYear() == year)
                .forEach(System.out::println);
    }

    public void showDevicesMoreExpensiveThan(double price) {
        System.out.println("\nDevices more expensive than " + price + ":");
        devices.stream()
                .filter(d -> d.getPrice() > price)
                .forEach(System.out::println);
    }

    public void showDevicesByType(String type) {
        System.out.println("\nDevices of type '" + type + "':");
        devices.stream()
                .filter(d -> d.getType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    public void showDevicesByYearRange(int startYear, int endYear) {
        System.out.println("\nDevices released between " + startYear + " and " + endYear + ":");
        devices.stream()
                .filter(d -> d.getYear() >= startYear && d.getYear() <= endYear)
                .forEach(System.out::println);
    }

    // For testing purposes
    public static void main(String[] args) {
        List<Device> deviceList = List.of(
                new Device("Device A", 2019, 299.99, "Black", "Smartphone"),
                new Device("Device B", 2020, 499.99, "White", "Laptop"),
                new Device("Device C", 2021, 199.99, "Black", "Tablet"),
                new Device("Device D", 2020, 399.99, "Silver", "Laptop"),
                new Device("Device E", 2018, 149.99, "Black", "Smartphone")
        );

        DeviceAnalysis analysis = new DeviceAnalysis(deviceList);
        analysis.showAllDevices();
        analysis.showDevicesByColor("Black");
        analysis.showDevicesByYear(2020);
        analysis.showDevicesMoreExpensiveThan(200);
        analysis.showDevicesByType("Laptop");
        analysis.showDevicesByYearRange(2019, 2021);
    }
}
