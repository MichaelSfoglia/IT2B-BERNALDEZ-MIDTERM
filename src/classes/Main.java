package classes;

import java.util.Scanner;

public class Main {
    public static Scanner in_scan = new Scanner(System.in);
    config con = new config();
    
    public static void main(String[] args) {
        Main m_function = new Main();
        int action;
        
        do{
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("FEEDBACK");
            System.out.println("---------------------------------------------------------------------------------------------");
            
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT\n");
            
            System.out.print("Enter action: ");
            action = in_scan.nextInt();
            
            switch(action){
                case 1:
                    m_function.addFeedback();
                    break;
                    
                case 2:
                    m_function.viewFeedback();
                    break;
                    
                case 3:
                    m_function.updateFeedback();
                    break;
                    
                case 4:
                    m_function.deleteFeedback();
                    break;
                    
                case 5:
                    System.out.println("Program exited.");
                    break;
                    
                default:
                    System.out.println("Invalid Program.");
            }
        }while(action != 5);
    }
    
    public void addFeedback(){
        System.out.print("Feedback: ");
        String feedback = in_scan.next();
        
        System.out.print("Date: ");
        String date = in_scan.next();
        
        System.out.print("Rating: ");
        int rating = in_scan.nextInt();
        
        String sql = "INSERT INTO tbl_feedback (feedback_text, feedback_date, rating) VALUES (?, ?, ?)";
        
        con.addRecord(sql, feedback, date, rating);
    }
    
    public void viewFeedback() {
        String feedbackQuery = "SELECT * FROM tbl_feedback";
        String[] feedbackHeaders = {"ID", "Feedback", "Date", "Rating"};
        String[] feedbackColumns = {"feedback_id", "feedback_text", "feedback_date", "rating"};

        con.viewRecords(feedbackQuery, feedbackHeaders, feedbackColumns);
    }
    
    public void updateFeedback(){
        System.out.print("Enter target id: ");
        int feedbackId = in_scan.nextInt();
        
        System.out.print("Enter new feedback ");
        String newFeedback = in_scan.next();
        
        System.out.print("Enter new rating: ");
        int newRating = in_scan.nextInt();
        
        
        String sqlUpdate = "UPDATE tbl_feedback SET feedback_text = ?, rating = ? WHERE feedback_id = ?";
        con.updateRecord(sqlUpdate, newFeedback, newRating, feedbackId);
    }
    
    public void deleteFeedback(){
        System.out.print("Enter target id: ");
        int feedbackDeleteId = in_scan.nextInt();

        String sqlDelete = "DELETE FROM tbl_feedback WHERE feedback_id = ?";
        con.deleteRecord(sqlDelete, feedbackDeleteId);
    }
}
