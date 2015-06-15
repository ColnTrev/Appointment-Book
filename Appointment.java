/**
 * The appointment class holds appointments made in an appointment book.
 * It stores the day, the time, and the appointment type.
 * @author Collin Gordon
 */

package hw3;

import static hw3.DayType.*;

public class Appointment {

    private DayType day;
    private String time;
    private String appt;
    

    public Appointment(){
        day  = DayType.MONDAY;
        time = "1200a";
        appt = "Exam Study";
    }
    
    /**
     * This method is a constructor for the Appointment class.
     * @param d - The day of the week
     * @param t - The time of the appointment
     * @param a - The type of appointment being made
     */
    public Appointment(DayType d, String t, String a){
        setDay(d);
        setTime(t);
        setAppt(a);
    }
    
    /**
     * This method sets the day of the week.
     * @param d - The day of the week 
     */
    public void setDay(DayType d){
        day = d;
    }
    
    /**
     * This method sets the time and throws an exception if the time is not
     * formatted correctly.
     * @param t 
     */
    public void setTime(String t){
        
        if(t.endsWith("a") || t.endsWith("p")){
            time = t;
        } else {
            throw new IllegalArgumentException("Time is invalid.");
        }
        
    }
    
    /**
     * This method sets the type of appointment
     * @param a 
     */
    public void setAppt(String a){
        appt = a;
    }
    
    /**
     * This method returns the day of the week that is currently set in 
     * the appointment class
     * @return The day stored in the Appointment class
     */
    public DayType getDay(){
        return day;
    }
    
    /**
     * This method returns the time that is currently set in the Appointment
     * class.
     * @return The time stored in the Appointment class 
     */
    public String getTime(){
        return time;
    }
    
    /**
     * This method returns the appointment type.
     * @return Appointment type stored in the Appointment class
     */
    public String getAppt(){
        return appt;
    }
            
}