import java.util.Scanner;

public class Statics {
    public static int transaction = 1000;
    private static Scanner scan = new Scanner(System.in);

    public static void printMenu(){ //multiple uses in the ATM class
        System.out.println("You need to enter your PIN to access the main menu!!!");
        ATM.checkPIN();
        System.out.println("----------> MAIN MENU: <---------- ");
        System.out.println("1. Withdraw money\n" +
                "2. Deposit money\n" +
                "3. Transfer money between accounts\n" +
                "4. Get account balances\n" +
                "5. Change PIN\n" +
                "6. Exit\n");

    }


    public static double round(double num){
        return ((double)Math.round(num*100))/100;
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getTransaction(){
        return transaction;
    }


}
