package pl.sda.libraryapp;

import java.util.Scanner;

public class UserInput {
    private Scanner input = new Scanner(System.in);

    public String getStringFromUser() throws NoInputValueException {
        System.out.println("To exit press ENTER");
        String string = input.nextLine();
        if(string.equals("")){
            throw new NoInputValueException();
        }
        return string;
    }

    public int getIntegerNumberFromUser() throws NoInputValueException {
        while(true){
            System.out.println("To exit press ENTER");
            String number = input.nextLine();
            if(number.equals("")){
                throw new NoInputValueException();
            }
            try{
                return Integer.parseInt(number);
            }
            catch (IllegalArgumentException e){
                System.out.println("Wrong input type. Choose a number");
                continue;
            }
        }
    }

    public double getDoubleNumberFromUser() throws NoInputValueException {
        while(true){
            System.out.println("To exit press ENTER");
            String number = input.nextLine();
            if(number.equals("")){
                throw new NoInputValueException();
            }
            try{
                return Double.parseDouble(number);
            }
            catch (IllegalArgumentException e){
                System.out.println("Wrong input type. Choose a number");
                continue;
            }
        }
    }

    public String getDefaultStringValue(){
        return null;
    }

    public int getDefaultIntegerValue(){
       return 0;
    }
}
