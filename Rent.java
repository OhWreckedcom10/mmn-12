
/**
 * Rent class for Maman 12.
 *
 * @Eshed Porat
 * @1.0
 */
import java.util.* ;
    
    
public class Rent
{
    private String custName;
    private Car car;
    private Date pickDate;
    private Date returnDate;
    private final int classADay = 100;
    private final int classBDay = 150;
    private final int classCDay = 180;
    private final int classDDay = 240;
    
    public static void main(String[] args)
    {
        
    }
    
    public Rent (String custName, Car car, Date pickDate, Date returnDate)
    {
        this.custName = custName;
        this.car = car;
        this.pickDate = pickDate;
        this.returnDate = returnDate;
        
        if(pickDate.before(returnDate))
        {
            pickDate.tomorrow();
        }
        else
        {
            returnDate = returnDate;
        }
        
    }
    
    public Rent(Rent other)
    {
        this.custName = custName;
        this.car = car;
        this.pickDate = pickDate;
        this.returnDate = returnDate;
    }
    
    public boolean equals (Rent other)
    {
        if((this.custName).equals(other.custName) && this.car.equals(other.car) && this.pickDate.equals(other.pickDate) && this.returnDate.equals(other.returnDate)) return true;
        else return false;
    }
    
    public int howManyDays()
    {
        return returnDate.difference(pickDate);
    }
    
    public int getPrice()
    {
        this.pickDate = pickDate;
        this.returnDate = returnDate;
        
        int day = returnDate.difference(pickDate);
        int weeks = day/7;
        
        if(car.getType() == 'A' && day < 7) return classADay * day;
        else if(car.getType() == 'A' && day >= 7) return classADay * day - classADay/10*weeks;
        else if(car.getType() == 'B' && day < 7) return classBDay * day;
        else if(car.getType() == 'B' && day >= 7) return classBDay * day - classBDay/10*weeks;
        else if(car.getType() == 'C' && day < 7) return classCDay * day;
        else if(car.getType() == 'C' && day >= 7) return classCDay * day - classCDay/10*weeks;
        else if(car.getType() == 'D' && day < 7) return classDDay * day;
        else if(car.getType() == 'D' && day >= 7) return classDDay * day - classDDay/10*weeks;
        else return 0;
    }
    
    public int upgrade(Car newCar)
    {      
        Rent rent = new Rent(custName, car, pickDate, returnDate);
        Rent newRent = new Rent(custName, newCar, pickDate, returnDate);
               
        if(newCar.better(car) == true)
        {
            return rent.getPrice() - newRent.getPrice();
        }
        else
        {
            return 0;
        }
        
    }
    
    public Rent overlap (Rent other)
    {
        if(this.returnDate.after(other.pickDate) == true)
        {
            return new Rent(custName , car , this.pickDate , other.returnDate);
        }
        else if(this.returnDate.before(other.pickDate) == true)
        {
            return null;
        }
        else if(this.returnDate.equals(other.pickDate) == true)
        {
            return new Rent(custName , car , this.pickDate , other.returnDate);
        }
        else
        {
            return new Rent(custName , car , this.pickDate , this.returnDate);
        }
    }
    
    public String toString()
    {
        this.custName = custName;
        this.pickDate = pickDate;
        this.returnDate = returnDate;
        this.car = car;
        
        return "Name:" + custName + " From:" + pickDate + " To:" + returnDate + " Type:" + car.getType() + " Days:" + returnDate.difference(pickDate) + " Price:" + getPrice();
    }
    
    
    
    
    
    
    
    
    
    
    
}
