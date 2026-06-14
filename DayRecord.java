public class DayRecord {
    private String month;
    private int day;
    private int temp;

    public DayRecord(String month, int day, int temp) {
        this.month = month;
        this.day = day;
        this.temp = temp;
    }


    public int getColor(int minTemp, int maxTemp) {
        float t = (float)(temp - minTemp) / (maxTemp - minTemp);
        int r = (int)(t * 255);
        int b = (int)((1 - t) * 255);
        int g = 0;
        return 0xFF000000 | (r << 16) | (g << 8) | b;
    }

    public String getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getTemperature() {
        return temp;
    }

    public String toString() {
        return month.substring(0, 1) + day + " " + temp;
    }


}