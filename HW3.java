/*
 * Collin Gordon
 * HW3 CIT 230
 * Appointment Book
 * This program is a GUI application that creates and saves appointments to an
 * ArrayList. The program can also clear the appointments as well as load stored
 * appointments into their respective day boxes.
 * THIS CLASS USES LAMBDAS JAVA 8 REQUIRED
 */
 
package hw3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static hw3.Appointment.*;
import static hw3.DayType.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class HW3 extends Application {
    
    private ArrayList<Appointment> holder = new ArrayList<Appointment>(); // holds appointments
    private HBox mainPane = new HBox(); // primary pane for GUI
	
    @Override
    public void start(Stage primaryStage) {
		
		mainPane.setSpacing(20); // making it pretty
		
		for(DayType day : DayType.values()){
			mainPane.getChildren().add(getVBox(day.toString())); // adding VBoxes to main pane
        }
		
        primaryStage.setTitle("Appointment Book");
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();

    }
        
	
	// This method finds an appointment in the ArrayList and returns to 
	// the calling program or method
	private Appointment find(DayType day){
	
		Appointment findMe = new Appointment(); // return value
		int i = 0; // counter
		boolean found = false;
		
		while(i < holder.size() && !found){
		
			if(holder.get(i).getDay() == day){
			
				findMe = holder.get(i);
				found = true;
				
			} else {
			
				i++;
				
			}
		}
		
		return findMe; 
    }
	
	// This method deletes previous appointment from holder
	private void findRemove(DayType day){
	
		int i = 0;
		boolean found = false;
		
		while(i < holder.size() && !found){
		
			if(holder.get(i).getDay() == day){
			
				holder.remove(i);
				found = true;
				
			} else {
			
				i++;
				
			}
		}
    }
	
	// This method adds VBoxes to the main pane. It includes several 
	// labels and buttons. Each button has a lambda method to handle 
	// events.
	private VBox getVBox(String s){
	
		VBox newBox = new VBox();
		Label dayLabel = new Label(s);
		Label appt = new Label("Appointment:");
		Label time = new Label("Time:");
		TextField apptField = new TextField();
		TextField timeField = new TextField();
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		Button open = new Button("Open");
		
		newBox.setSpacing(20); // making it pretty
		
		// adding features to the layout
		newBox.getChildren().addAll(dayLabel, appt, apptField, time, timeField, 
									submit, clear, open);
		
		// button listeners
		submit.setOnAction((e) -> {
			try{
			
				holder.add(new Appointment(DayType.valueOf(dayLabel.getText()), 
						timeField.getText(), apptField.getText()));
						
			} catch(IllegalArgumentException ex) {
			
				JOptionPane.showMessageDialog(null, ex);
				
			}
					   
		});
				
		clear.setOnAction((e) -> {
		
			timeField.setText("");
			apptField.setText("");
			findRemove(DayType.valueOf(dayLabel.getText()));
			
		});
			
		open.setOnAction((e) -> {
		
			Appointment found = find(DayType.valueOf(dayLabel.getText()));
			timeField.setText(found.getTime());
			apptField.setText(found.getAppt());
			
		});
		
		return newBox;
	}


}

    
