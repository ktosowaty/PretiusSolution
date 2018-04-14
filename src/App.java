import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan;
        File file;
        String path;
        if(args.length==0) {
            scan = new Scanner(System.in);
            System.out.print("Podaj nazwę pliku: ");
            path = scan.nextLine();
        } else {
            path = args[0];
        }
        file = new File(path);
        scan = new Scanner(file);
        double result = 0.00;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            if(line.contains("amount")) {
                String amount = line.substring(line.lastIndexOf("@") + 8, line.length()-3);
                amount = amount.replace(',', '.');
                result += Double.parseDouble(amount);
                System.out.println(amount);
            }
        }
        scan.close();
        System.out.printf("Total amount: %.2f\n", result);
    }
}
