import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = null;
        String path;
        if(args.length==0) {
            scan = new Scanner(System.in);
            System.out.print("Enter filename: ");
            path = scan.nextLine();
            scan.close();
        } else {
            path = args[0];
        }
        File file = new File(path);
        Money money = new Money(0);
        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                if(line.contains("amount")) {
                    String amount = line.substring(line.lastIndexOf("@") + 8, line.length()-3);
                    amount = amount.replace(",", "");
                    amount = amount.replace(".", "");
                    money.add(new Money(Long.parseLong(amount)));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect filename!");
        } finally {
            if(scan!=null) {
                scan.close();
            }
        }
        System.out.println("Total amount: " + money);
    }
}
