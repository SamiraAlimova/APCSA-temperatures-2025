import java.util.ArrayList;
import processing.core.PApplet;
import java.util.Scanner;
import java.io.File;

public class Sketch extends PApplet {
    ArrayList<DayRecord> dayList = new ArrayList<DayRecord>();
    //ArrayList<DayRecord> days;
    //String[] List = new String[1000];
    int minTemp = 100;
    int maxTemp = 0;
    int currentIndex = 0;
    int i = 0;

    
    public void settings() {
        size(600, 600);
        
    }
    public void setup() {
        
        try {
            Scanner sc = new Scanner(new File("temps.txt"));
            
            while (sc.hasNextLine()) {
                //read the next line of the text
                String line = sc.nextLine();

                int firstSpace = line.indexOf(" ");
                
                String month = line.substring(0, firstSpace);
                System.out.println(month);

                int secondSpace = line.indexOf(" ", firstSpace + 1);
                int day = Integer.parseInt(line.substring(firstSpace+1, secondSpace));
                System.out.println(day);

                //to get landamrk index values (last space, degree symbol)
                int from = line.lastIndexOf(" ")+1;
                int to = line.indexOf("°");

                //use landmarks to parse the value we care about
                int temperature  = Integer.parseInt(line.substring(from, to));
                //System.out.println(temperature);

                //saving the data into object and add it ot the list
                DayRecord dr = new DayRecord(month, day, temperature);
                dayList.add(dr);

                //min and max 
                if (temperature < minTemp) {
                    minTemp = temperature;
                }
                if (temperature > maxTemp){
                    maxTemp = temperature;
                } 
            }
            sc.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw() {
        //next we should create the squares here!!!
        background(0, 0, 50);

        int size = 38;
        int spacing = 2;
        int columns = 25;

        for (int j = 0; j < dayList.size(); j++) {
            DayRecord dr = dayList.get(j);

            //math to calc grid of rect
            int x = (j % columns) * (size + spacing);
            int y = (j / columns) * (size + spacing);

            //seatting the color for this day
            fill(dr.getColor(minTemp, maxTemp));
            rect(x, y, size, size);

            //  //text
            //  fill(255,100);
            //  textSize(60);
            //  textAlign(CENTER, CENTER);
            // // text(dr.getTemperature(), x + size/2, y + size/2);

        }      
     noLoop(); 
        
    }

}