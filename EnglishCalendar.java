import java.util.*;
class Main
{ 
   
    public static void main(String args[]) 
    { 
        
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Enter the year : "); 
        int yy = sc.nextInt(); 
        System.out.print("Enter month : "); 
        String[][] events = new String[32][2];
        int mm = sc.nextInt(); 
        int date = 1; 
        int month = 1; 
        int year = 1; 
        int day = 0; 

        String days[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" }; 
        String months[]= { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" }; 
        int totaldays[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 
       
        while (true) 
        { 
            if (date == 1 && month == mm && year == yy) 
            { 
                break; 
            } 
            if (year % 4 == 0 && year % 100 != 0|| year % 100 == 0) 
            { 
                totaldays[1] = 29; 
            } 
            else 
            { 
                totaldays[1] = 28; 
            } 
            day++; 
            date++; 
            if (date > totaldays[month - 1]) 
            { 
                month++; 
                date = 1; 
            } 
            if (month> 12) 
            { 
                month = 1; 
                year++; 
            } 
            if (day == 7) 
            { 
                day = 0; 
            } 
        } 
    
        boolean b= true;
        while (b) 
		{
            System.out.print("Enter the date for an event (1-" + totaldays[month - 1] + ") or 0 to finish: ");
            int dates = sc.nextInt();

            if (dates == 0)
			{
                b = false;
            }
			
			else 
			{
                System.out.print("Enter the event description: ");
                String description = sc.next();
				events[dates][0]=String.valueOf(dates);
                events[dates][1] = description; // Store event at the date index
            }
        }
        // Print the desired month of input year 
        System.out.println("MONTH:" + months[mm - 1]); 
        //for days
        for (int k = 0; k < 7; k++) 
        {  
            System.out.printf("%15s",days[k]); 
        } 
        System.out.println();
        
      

            // Print leading spaces for the first week
            for (int i = 0; i < day; i++) 
            {
                 System.out.print("               ");//15
            }
			
             // Printing the calendar with events
         for (int i = 1; i <= totaldays[mm - 1]; i++) 
         {
			 if (events[i] != null) 
			 { 
                if (events[i][1] != null) 
				{ 
                    System.out.print(events[i][0] + events[i][1]);
                } 
				else 
				{ 
                    System.out.printf("%15s",i);
                }
             } 
			 else 
			 {
                System.out.printf("%15s",i);
             }

                 // Check for line breaks after printing a day
                 if (((i + day) % 7 == 0) || (i == totaldays[mm - 1])) 
                 {
                    System.out.println();
                 }
         }
    }
}