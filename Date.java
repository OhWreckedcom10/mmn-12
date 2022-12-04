
/**
 * Date class for Maman 12.
 *
 * @Eshed Porat
 * @1.0
 */
import java.util.* ;


public class Date
{
    private final int dayMin = 1;
    private int dayMax = 31;
    private final int monthMin = 1;
    private final int monthMax = 12;
    private final int yearMin = 0001;
    private final int yearMax = 9999;
    private final int dayDef = 1;
    private final int monthDef = 1;
    private final int yearDef = 2000;
    private int day;
    private int month;
    private int year;
    
    
    //main 
    public static void main(String [] args)
    {        
        Date d2 = new Date (10,10,2001);
        Date d3 = new Date (17,1,2004);
        Date d4 = new Date (10,10,2001);
        
        System.out.println(d2.getYear());
        System.out.println(d2.getMonth());
        System.out.println(d2.getDay());
        System.out.println(d2.equals(d4));
        System.out.println(d2.setDay(32));
        System.out.println(d2.before(d3));
        System.out.println(d2.after(d3));
        System.out.println(d3.after(d2));
        System.out.println(d2.equals(d3));
    }
        
    //date constructor day, month, year
    public Date(int day, int month, int year)
    {     
        
        if((year%4==0) && (month==2))
        {
            dayMax = 29;
        }
        
        else if ((year%4!=0) && (month==2))
        {
            dayMax = 28;
        }
        
        else if (month==4 || month==6 || month == 9 || month == 11)
        {
            dayMax = 30;
        }
        
        else if(day >= dayMin && day <= dayMax)
        {
            if(month >= monthMin && month <= monthMax)
            {
                if(year >= yearMin && year <= yearMax)
                {
                    day = day;
                    month = month;
                    year = year;
                }
            }
        }
        
        else if (day < dayMin || day > dayMax)
        {
            day = dayDef;
        }
        
        else if(month < monthMin || month > monthMax)
        {
            month = monthDef;
        }
        
        else if(year < yearMin || year > yearMax)
        {
            year = yearDef;
        }
    }
    
    
    //date copy constructor
    public Date (Date other)
    {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }
    
    
    //getters
    public int getDay()
    {
        return day;
    }
    
    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }
    
    //setters
    public int setDay(int dayToSet)
    {
        this.day = dayToSet;
        if((year%4==0) && (month==2))
        {
            dayMax = 29;
        }
        
        else if ((year%4!=0) && (month==2))
        {
            dayMax = 28;
        }
        
        else if (month==4 || month==6 || month == 9 || month == 11)
        {
            dayMax = 30;
        }
        
        else if(day >= dayMin && day <= dayMax)
        {
            if(month >= monthMin && month <= monthMax)
            {
                if(year >= yearMin && year <= yearMax)
                {
                    return dayToSet;
                }
            }
        }
        
        else if (day < dayMin || day > dayMax)
        {
            return dayDef;
        }
        return dayToSet;
    }
    
    public int setMonth(int monthToSet)
    {
        this.month = monthToSet;
        if(month < monthMin || month > monthMax)
        {
            return monthDef;
        }
        return monthToSet;
    }
    
    public int setYear(int yearToSet)
    {
        this.year = yearToSet;
        if(year < yearMin || year > yearMax)
        {
            return yearDef;
        }
        return yearToSet;
    }
    
    //more methods
    public boolean equals(Date other)
    {        
        if(this.day != other.day || this.month != other.month || this.year != other.year)return false;
        else return true;
    }
    
    public boolean before (Date other)
    {
        return calculateDate(this.day, this.month, this.year) > calculateDate(other.day, other.month, other.year);
    }
    
    public boolean after (Date other)
    {
        if(this.before(other) == true) return false;
        else return true;
    }
    
    private int calculateDate (int day, int month, int year)
    {
        if (month<3)
        {
            year--;
            month = month + 12;
        }
        return 365*year + year/4 - year/100 + year/400 + ((month+1)*306)/10 + (day-62);
    }
    
    public int difference(Date other)
    {
        if(this.before(other) == true)
        {
            return calculateDate(this.day, this.month, this.year) - calculateDate(other.day, other.month, other.year);
        }
        else
        {
            return calculateDate(other.day, other.month, other.year) - calculateDate(this.day, this.month, this.year);
        }
    }
    
    public String toString()
    {
        this.day = day;
        this.month = month;
        this.year = year;
        
        if(day >= dayMin && day <10)
        {
            return "0" + day;
        }
        
        if(month >= monthMin && month <10)
        {
            return "0" + month;
        }
        
        if(year >= yearMin && year <10)
        {
            return "000" + year;
        }
        
        if(year >= yearMin && year <100)
        {
            return "00" + year;
        }
        
        if(year >= yearMin && year <1000)
        {
            return "0" + year;
        }
        
        return day + "/" + month + "/" + year;
    }
    
    public Date tomorrow()
    {
        this.day = day;
        this.month = month;
        this.year = year;
        
        if((year%4==0) && (month==2))
        {
            dayMax = 29;
        }
        
        else if ((year%4!=0) && (month==2))
        {
            dayMax = 28;
        }
        
        else if (month==4 || month==6 || month == 9 || month == 11)
        {
            dayMax = 30;
        }
        
        if(day < dayMax)
        {
            day++;
        }
        else if (day == dayMax && month < monthMax)
        {
            day = dayMin;
            month++;
        }
        else if (day == dayMax && month == monthMax)
        {
            day = dayMin;
            month = monthMin;
            year++;
        }
        
        return new Date(day, month, year);
    }
}
