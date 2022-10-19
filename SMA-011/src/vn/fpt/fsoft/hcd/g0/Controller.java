package vn.fpt.fsoft.hcd.g0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {
        
        public int getChoice() {
                System.out.print("Your option is: ");
                
                int choice = 0;
                boolean flag = false;
                
                while(flag == false ) {
                        Scanner sc = new Scanner(System.in);
                        String input = sc.nextLine();
                        flag = true;
                        try {
                                choice = Integer.parseInt(input);
                        }
                        catch (Exception e){
                                View.showMessage(View.MSG10);
                                flag = false;
                        }
                        if((choice >5 || choice < 1) && (choice != 0)){
                                View.showMessage(View.MSG10);
                                flag = false;
                        }
                }
                return choice;
        }
        
        public String getInput() {
                boolean flag = false;
                String input = null;
                Scanner sc = new Scanner(System.in);
                
                while(flag == false){
                        flag = true;
                        input = sc.nextLine();
                        if (input.equals("")) {
                                View.showMessage(View.MSG1);
                                flag = false;
                        }
                }
                return input;
        }
        
        public String getConfirm() {
                boolean flag = false;
                String input = null;
                Scanner sc = new Scanner(System.in);
                
                while(flag == false){
                        flag = true;
                        input = sc.nextLine();
                        if (input.equals("")) {
                                View.showMessage(View.MSG1);
                                flag = false;
                        }
                        if (!(input.toLowerCase().equals("y") || input.toLowerCase().equals("n"))) {
                                View.showMessage(View.MSG10);
                                flag = false;
                        }
                }
                return input.toUpperCase();
        }
        
        public boolean waitKeyPress() {
        	try {
        		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        		int key = in.read();
        		if(key != -1) {
        			return true;
        		}
        	}
        	catch(IOException io) {
        		io.printStackTrace();
        	}
        	
        	return false;
        }
        
        public String getGrade() {
                boolean flag = false;
                String input = null;
                Scanner sc = new Scanner(System.in);
                int grade = -1;
                
                while(flag == false){
                        flag = true;
                        input = sc.nextLine();
                        if (input.equals("")) {
                                View.showMessage(View.MSG1);
                                flag = false;
                                continue;
                        }
                        
                        try {
                                grade = Integer.parseInt(input);
                        }
                        catch(Exception e) {
                                View.showMessage(View.MSG13);
                                flag = false;
                                continue;
                        }
                        
                        if(grade > 10 || grade < 0) {
                                View.showMessage(View.MSG11);
                                flag = false;
                                continue;
                        }
                }
                return input;
        }
}
