import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        initUsers();
        System.out.println("Welcome to the library!!!");
        validateUser();
        startDialog();
    }

    private static void validateUser() {
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        if(isUserValid(name)){
         startDialog();
        }
        else{
            newUser();
        }
    }

    private static void newUser() {
     System.out.println("Create your users name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        users.add(new User(name, 2));
    }

    private static boolean isUserValid(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().contains(name)) {
                return true;
            }
        }
        return false;
    }

    private static void initUsers() {
        users.add(new User("Sasha", 1));
    }

    private static void startDialog() {

        System.out.println("To Add book enter 1, to view all books enter 2.");
        Scanner scanner = new Scanner(System.in);
        char choose = scanner.next().charAt(0);

        System.out.println(bookList.size());
        switch (choose) {
            case '1':
                bookList.add(createBook());
                break;
            case '2':
                printBoolList();
                break;
        }
        System.out.println("Add more book? Y/N");
        char bookAnswer = scanner.next().charAt(0);
        switch (bookAnswer) {
            case 'Y':
                startDialog();
                break;
            default:
                nextStep();
                break;
        }
        clearScreen();
    }

    private static void printBoolList() {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("Name " + bookList.get(i).getName() + ", Author " + bookList.get(i).getAuthor() + ", Type " + bookList.get(i).getType());
        }
    }

    private static void nextStep() {

    }

    private static Book createBook() {
        Book newBook = new Book("Bookvar", "Narod", "Tip");
        return newBook;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
