package vn.fpt.fsoft.hcd.g0;

public class MainProgram {
	
        static View screen = new View();
        static Controller control = new Controller();
        static Model connector = new Model();
        
	public static void main(String[] args) {
	        
	        startUp();
	}
	
	public static void startUp() {
	            screen.showMainMenu();
                int choice =  control.getChoice();
                
                switch(choice) {
                case 1: // manage class
                	screen.showClassMenu();
        	        int choice1= control.getChoice();
        	        
        	        switch(choice1) {
	        	        case 1: addNewClass();
	        	                break;
	        	        case 2: updateClass();
	        	                break;
	        	        case 3: deleteClass();
	        	                break;
	        	        case 4: listAllClass();
	        	                break;
	        	        case 5: System.exit(0);
	                        break;
        	        }
        	         break ;
                case 2: // manage subject
                	 screen.showSubjectMenu();
         	        int choice2 = control.getChoice();
         	        
         	        switch(choice2) {
	         	        case 1: addNewSubject();
	         	                break;
	         	        /*case 2: updateSubject();
	         	                break;
	         	        case 3: deleteSubject();
	         	                break;
	         	        case 4: listAllSubject();
	         	                break;
	         	        case 5: System.exit(0);
	         	                break;*/
         	        }
                        break;
                case 3: //manage student
                	  screen.showStudentMenu();
          	          int choice3 = control.getChoice();
                      break;
                case 4: //manage report
                	    screen.showReportMenu();
         	            int choice4 = control.getChoice(); 
                        break;
                case 5: System.exit(0);
                        break;
                }
	}
	
	
	public static void addNewClass() {
	        boolean flag = true;
	        String classID = null;
	        String className = null;
	        
	        while(flag) {
	                screen.showAddClass();
	                classID = control.getInput();
	                if ((flag = connector.isExistedClass(classID))) {
	                        View.showMessage(View.MSG2);
	                }
	        }
	        
	        View.showMessage("Input class name: ");
	        className = control.getInput();
	        connector.addClassToFile(classID, className);
	        View.showMessage(View.MSG3);
	        control.waitKeyPress();
	        startUp();
	}
	
	public static void updateClass() {
		
		boolean flag = false;
		String classID = null;
		String className = null;
		
		while(!flag) {
			screen.showUpdateClass();
			classID = control.getInput();
			if (!(flag = connector.isExistedClass(classID))) {
				View.showMessage(View.MSG4);
			}
		}
			
		View.showMessage("Input new class name: ");
		className = control.getInput();
		connector.renameClass(classID, className);
		View.showMessage(View.MSG3);
                control.waitKeyPress();
                startUp();
	}
	
	public static void deleteClass() {
	        
	        boolean flag = false;
	        String classID = null;
	        String confirm = null;
	        
	        while(!flag) {
	                screen.showDeleteClass();
	                classID = control.getInput();
	                flag = true;
	                
	                if (!connector.isExistedClass(classID)) {
                                View.showMessage(View.MSG4);
                                flag = false;
                        }
	                if(!connector.isEmptyClass(classID)) {
	                        View.showMessage(View.MSG5);
	                        flag = false;
	                }
	        }
	        
	        View.showMessage("Are you sure want to delete this(Y/N)? ");
	        confirm = control.getConfirm();
	        if (confirm.equals("N")) {
	                startUp();
	                return;
	                
	        }
	        else {
	                connector.deleteClass(classID);
	                View.showMessage(View.MSG3);
	                control.waitKeyPress();
	                startUp();
	        }
	}
	
	public static void listAllClass() {
	        screen.showListAllClass();
	        connector.listAllClass();
	        View.showMessage(View.MSG3);
                control.waitKeyPress();
                startUp();
	}
	
	public static void addNewSubject() {
	        
	}
	
	public static void searchStudent() {
	        
	        String keyword = null;
	        
	        screen.showSearchStudent();
	        keyword = control.getInput();
	        connector.searchStudent(keyword);
	        View.showMessage(View.MSG3);
	        control.waitKeyPress();
	        startUp();
	}
	
	public static void inputStudentGrade() {
	        
	        String studentID = null;
	        String subjectID = null;
	        String grade = null;
	        boolean flag = true;
	        
	        screen.showInputStudentGrade();
	        
	        while(flag) {
	                do {
	                        View.showMessage("Select Student: ");
	                        studentID = control.getInput();
	                        if(!connector.isExistedStudent(studentID)) {
	                                View.showMessage(View.MSG9);
	                        }
	                }
	                while(!(connector.isExistedStudent(studentID)));
	                do {
	                        View.showMessage("Select subject: ");
	                        subjectID = control.getInput();
	                        if(!connector.isExistedSubject(subjectID)) {
	                                View.showMessage(View.MSG7);
	                        }
	                }
	                while(!connector.isExistedSubject(subjectID));
	                if((connector.isExistedGrade(studentID, subjectID))) {
	                        View.showMessage(View.MSG12);
	                        continue;
	                }
	                flag = false;	                
	        }
	        
	        View.showMessage("Input grade: ");
	        grade = control.getGrade();
	        connector.addGradeToFile(studentID, subjectID, grade);
	        View.showMessage(View.MSG3);
	        control.waitKeyPress();
	        startUp();
	}

}