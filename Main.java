// Expense Tracker project
// A simple console-based tracker with budget, expenses, and summaries.
import java.util.*;
class Main
 {
   static Scanner sc=new Scanner(System.in);
   static int count=0;
   static int choice=0;
   static int budget=1000000; // default budget (so program doesn't warn at start)
   // Categories and amounts
   static String[] category={"Food", "Travel", "Shopping", "Other"};
   static int[] amount=new int[4];
   // Method to set budget
    public static void budget()
     {
      System.out.print("Enter your Budget: ");
      budget=sc.nextInt();
       System.out.println("Budget set successfully!");
     }
   // Method to add expense to chosen category
    public static void addExpense()
     {
      while(true) {
      System.out.print("Enter category (Food/Travel/Shopping/Other): ");
      String category=sc.next();
      if(category.equalsIgnoreCase("food")) {
        count=0;
        System.out.print("Enter amount: ");
        int temp=sc.nextInt();
        amount[count]+=temp;
        System.out.println("Expense Added!");
        break;
       }
      else if(category.equalsIgnoreCase("Travel")) {
        count=1;
        System.out.print("Enter amount: ");
        int temp=sc.nextInt();
        amount[count]+=temp;
        System.out.println("Expense Added!");
       break;
       }
      else if(category.equalsIgnoreCase("shopping")) {
        count=2;
        System.out.print("Enter amount: ");
        int temp=sc.nextInt();
        amount[count]+=temp;
        System.out.println("Expense Added!");
        break;
      }
      else if(category.equalsIgnoreCase("other")) {
        count=3;
        System.out.print("Enter amount: ");
        int temp=sc.nextInt();
        amount[count]+=temp;
        System.out.println("Expense Added!");
        break;
      }
      else {
        System.out.print("Invalid Category!\n");
      }
      }
    }
   // Method to view all expenses
    public static void viewExpense()
    {
      System.out.println("--- All Expenses ---");
      for(int i=0; i<category.length; i++) {
        System.out.println((i+1)+". "+category[i]+" - "+amount[i]);
      }
    }
   // Method to show monthly summary (total + category-wise)
    public static void monthSummary()
    {
      System.out.println("--- Monthly Summary ---");
      int total=0;
      for(int i=0; i<amount.length; i++) {
        total+=amount[i];
      }
      System.out.println("Total Expenses: "+total);
      for(int i=0; i<category.length; i++) {
        System.out.println((i+1)+". "+category[i]+" - "+amount[i]);
      }
      if(total>budget) {
        System.out.println("⚠️ Budget Exceeded! (Budget: "+budget+", Spent: "+total+")");
      }
    }
   // Method to display biggest expense
    public static void biggestExpense()
    {
      System.out.println("--- Biggest Expense ---");
      int max=amount[0];
      for(int i=0; i<amount.length; i++) {
        if(amount[i]>max) max=amount[i];
      }
      for(int i=0; i<amount.length; i++) {
        for(int j=i+1; j<amount.length; j++) {
        if(amount[i]>amount[j]) i=count;
        }
      }
      System.out.println(category[count]+" - "+max);
    }
   // Main menu-driven program
    public static void main(String[] args)
    {
      System.out.println("------- Expense Tracker -------");
       System.out.print("1. Add Expense\n2. View All Expenses\n3. Monthly Summary\n4. Biggest Expense\n5. Set Budget\n6. Exit");
      while(true) {
        System.out.print("\n\nEnter choice: ");
        choice=sc.nextInt();
      if(choice==1) addExpense();
      if(choice==2) viewExpense();
      if(choice==3) monthSummary();
      if(choice==4) biggestExpense();
      if(choice==5) budget();
      if(choice==6) {
        System.out.println("Exiting Expense Tracker... Bye👋");
        return;
      }
      else
        System.out.println("Invalid Choice!");
      }
    }
  }