import java.util.Scanner;

public class MockRepo {
    
    public static void main(String [] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the repo Name: ");
        String name = kb.next();
        Analysis an = new Analysis(name);
        System.out.print("Choose what to display: \n 1: Comments \n 2: Commits \n 4: Colaborators ");
        int var = nextInt();
    }
}
