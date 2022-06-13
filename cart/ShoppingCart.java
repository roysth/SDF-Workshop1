package cart;

import java.io.Console;
import java.util.*;
//insead of importing all the java.util.LinkList, java.util.List, can just use * to represent everything


public class ShoppingCart {

    public static void main (String[] args){
        System.out.println("Welcome to your shopping cart");
        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        boolean stop = false;
        String input;

        while(!stop){
            input = cons.readLine("> ");
            System.out.printf("READ: %s\n", input);
            String originalString = input;
            String removeTheComma = originalString.replace(",","");
            String[] fruits = removeTheComma.split(" ");
            String cmd = fruits[0];

            switch(cmd){
                case "add":
                    for(int i = 1; i < fruits.length; i++){ //start with i =1 so as to avoid 'add"'
                        boolean found = false;
                        for(int j = 0; j < cart.size(); j++){
                            if(fruits[i].toUpperCase().equals(cart.get(j).toUpperCase())){
                                found = true;
                                break;
                            }   
                        }

                        if(!found){
                            cart.add(fruits[i]);
                            System.out.printf("%s added to the cart\n", fruits[i]);     
                        }
                        else {
                            System.out.printf("You have %s in your cart\n", fruits[i]);
                        }
                    }
                    break;

                case "list":   
                    if(cart.size()> 0){
                        for(int i=0; i < cart.size(); i++){
                            System.out.printf("%d. %s\n", (i +1), cart.get(i));
                        }   
                    }
                    else {
                        System.out.println("Your cart is empty!");
                    }
                    break;
                
                case "delete":
                    if(fruits.length < 2){
                        System.out.println("Please provide an index in order to delete");
                    }
                    else {
                        try{
                            int deleteIndex = Integer.parseInt(fruits[1]) - 1;
                            if(deleteIndex >= 0 &&  deleteIndex < cart.size()){
                                cart.remove(deleteIndex);
                                System.out.printf("Deleted %s from cart\n", cart.get(deleteIndex));
                            }
                            else {
                                System.out.println("No such item to delete");
                            }
                        }
                        catch(Exception e){
                            System.out.println("No such item to delete");
                        }
                    }
                    break;
                
                case "end":
                    stop = true;
                    break;

                default:
                System.out.println("Invalid Command");
            }
        }
        System.out.println("Thank you for shopping with us");
    }
}