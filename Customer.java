package simpleBank;

import java.util.ArrayList;

public class Customer {
    static ArrayList <Customer> list = new ArrayList<>();

    private String name;
    private String mobNumber;
    private String userId;
    private String password;
    private double bal;

    public Customer(String name, String mobNumber,String id,String pass){
        this.name = name;
        this.mobNumber = mobNumber;
        this.userId = id;
        this.password = pass;
        this.bal =0;
        
    }
   
    public String getName(){
        return this.name;
    }
    public String getMob(){
        return this.mobNumber;
    }
    public String  getId() {
        return this.userId ;
    }
    public String getPass(){
        return this.password;
    }
    public double getAmount(){
        return this.bal;
    }
    public void updateAmount(double money){
        this.bal += money;
    }

    //ADDING CUSTOMER TO THE ARRAY LIST  
    public void addCustomer(Customer C){
        list.add(C);
    }


    static int i = 0; // THIS i INDICATE THE CURRENT VERIFIED CUSTOMER INDEX NO.

    //CHECKING USER_ID AND PASSOWRD WITH THE AVAILABLE LIST
    public static boolean checkValidate(String id, String pass,int count){
        for (i =0;i<count;i++){
            // System.out.println(list.get(i).getId() +"  "+list.get(i).getPass());
            // list.get(i).getId();list.get(i).getPass();
            if(id.equals(list.get(i).getId()) && pass.equals(list.get(i).getPass()) ){
                return true;
            }
        }
        return false;
    }

    public static void showDetails(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Name: "+list.get(i).getName()+"\tMob: "+list.get(i).getMob()+"\tUserID: "+list.get(i).getId() +"\tPassW: "+list.get(i).getPass()+"\tBal: "+list.get(i).getAmount());
        System.out.println("-------------------------------------------------------------------------------");
    }
    public static void addBal(double money){
        list.get(i).updateAmount(money);
    }
    public static void withdraw(double money){
        if(list.get(i).getAmount() < money){
            System.out.println("\tSorry! low balence");
            return;
        }
        list.get(i).updateAmount(-money);
        
    }


    
}
