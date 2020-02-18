public class Driver {
    public static void main(String[] args) {
        Model hana = new Model("Susan", "Smith", 70, 120, false, true);

        hana.printDetails();
        System.out.println();
        hana.displayModelDetails();
        System.out.println(hana.getWeightKg());
    }
}
