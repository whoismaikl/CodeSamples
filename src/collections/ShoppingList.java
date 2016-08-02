package collections;
import java.io.*;

/**
 * Created by mihails_nikitins on 02.08.2016.
 */
public class ShoppingList {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String[] itemArray = new String[0];

    public static void main(String[] args) throws IOException {
        printMessage();
    }

    public static void printMessage() throws IOException {
        System.out.println("This is a shopping list application. Enter your choice: ");
        System.out.println("1 - Add an item.");
        System.out.println("2 - List items.");
        System.out.println("3 - Delete an item.");
        System.out.println("4 - Save list to file.");
        System.out.println("5 - Load list from file.");
        System.out.println("6 - Exit.");
        readChoice();
    }

    public static void readChoice() throws IOException{
        String userChoiceString = reader.readLine();
        Integer userChoice = Integer.parseInt(userChoiceString);
        switch (userChoice) {
            case 1:
                addItem(itemArray);
                break;
            case 2:
                listItems(itemArray);
                break;
            case 3:
                deleteItem(itemArray);
                break;
            case 4:
                writeFile("C:\\ShoppingList.txt",itemArray);
                break;
            case 5:
                readFile("C:\\ShoppingList.txt");
                break;
            case 6:
                System.out.println("Good bye!");
                break;
            default:
                System.out.println("Invalid input.");
                printMessage();
                break;
        }
    }

    private static void listItems(String[] localItemArray) throws IOException {
        System.out.println("Currently added items: ");
        for (int i=0;i<localItemArray.length;i++){
            System.out.println(i + " " + localItemArray[i]);
        }
        System.out.println("End of list.");
        System.out.println();
        printMessage();
    }

    private static void addItem(String[] localItemArray) throws IOException {
        int i=0;
        itemArray = new String[itemArray.length+1];
        for (i=0;i<localItemArray.length;i++){
            itemArray[i] = localItemArray[i];
        }
        System.out.print("Enter item to add: ");
        itemArray[i] = reader.readLine();
        System.out.println("Item Added: " +  itemArray[i]);
        printMessage();
    }

    private static void deleteItem(String[] localItemArray) throws IOException {
        String arrayValues = "";
        int deleteCount =0;

        System.out.println("Enter item name to delete: ");
        String itemToDelete = reader.readLine();

        for (int i=0; i<localItemArray.length;i++){
            if (localItemArray[i].equals(itemToDelete)){
                localItemArray[i] = "";
                System.out.println("Item removed from list");
                deleteCount++;
                break;
            }
        }

        if (deleteCount !=0) {
            for (int i=0; i<localItemArray.length;i++){
                if (!"".equals(localItemArray[i])){
                    if(arrayValues.length()>0){
                        arrayValues += "|" + localItemArray[i];
                    }else{
                        arrayValues += localItemArray[i];
                    }
                }
            }
            itemArray = new String[itemArray.length-deleteCount];
            itemArray = arrayValues.split("\\|",-1);

        }else{
            System.out.println("Item not found! See items in list");
        }
        printMessage();
    }

    public static void writeFile (String filePathName, String[]localItemArray) throws IOException{

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filePathName));
        for (int i = 0; i < localItemArray.length; i++) {
            outputWriter.write(localItemArray[i]);
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
        System.out.println("Shopping list exported to file: " + filePathName);
        printMessage();
    }
    public static void readFile (String filePathName) throws IOException{
        String arrayValues = "";
        int readCount = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filePathName));

        while ((reader.readLine()) != null) {
            if(arrayValues.length()>0){
                arrayValues += "|" + reader.readLine();
            }else{
                arrayValues += reader.readLine();
            }
            readCount++;
        }
        itemArray = new String[readCount];
        itemArray = arrayValues.split("\\|",-1);
        System.out.println("Shopping list added from file C:\\ShoppingList.txt");
        reader.close();
        printMessage();
    }

}
