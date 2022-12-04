/**
 * Car class for Maman 12.
 *
 * @Eshed Porat
 * @1.0
 */
import java.util.* ;

public class Car
{
    private int carID;
    private char type;
    private String brand;
    private boolean isManual;
    private final int idDef = 9999999;
    private final char typeDef = 'A';
    
    
    public static void main(String[] args)
    {
        Car c1 = new Car(1234567, 'C', "Mazda", false);
        Car c2 = new Car(2222222, 'B', "Mustang", true);
        Car c3 = new Car(1234568, 'C', "Mazda", false);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        c2.setType('D');
        c2.setIsManual(false);
        System.out.println(c2.toString());
        System.out.println(c1.equals(c3));
        System.out.println(c2.better(c3));
        System.out.println(c2.worse(c3));
    }
    
    public Car(int carID, char type, String brand, boolean isManual)
    {
        this.carID = carID;
        this.type = type;
        this.brand = brand;
        this.isManual = isManual;
        String gear;
        
        if(carID < 1000000)
        {
            carID = idDef;
        }
        else
        {
            carID = carID;
        }
        
        if(type != 'A' || type != 'B' || type != 'C' || type != 'D')
        {
            type = typeDef;
        }
        else
        {
            type = type;
        }
        
        if(brand == null)
        {
            brand = null;
        }
        else
        {
            brand = brand;
        }
        
        if(isManual == true)
        {
            gear = "manual";
        }
        else
        {
            gear = "auto";
        }
        
        
    }
    
    public Car(Car other)
    {
        this.carID = other.carID;
        this.type = other.type;
        this.brand = other.brand;
        this.isManual = other.isManual;
    }
    
    
    //getters
    public int getID()
    {
        return carID;
    }
    
    public char getType()
    {
        return type;
    }
    
    public String getBrand()
    {
        return brand;
    }
    
    public boolean getIsManual()
    {
        return isManual;
    }
    
    
    //setters
    public int setID(int carID)
    {
        this.carID = carID;
        if(carID < 1000000)
        {
            carID = idDef;
        }
        else
        {
            carID = carID;
        }
        return carID;
    }
    
    public char setType(char type)
    {
        this.type = type;
        if(type == 'A' || type == 'B' || type == 'C' || type == 'D')
        {
            type = type;
        }
        else
        {
            type = typeDef;
        }
        return type;
    }
    
    public String setBrand(String brand)
    {
        this.brand = brand;
        if(brand == null)
        {
            brand = null;
        }
        else
        {
            brand = brand;
        }
        return brand;
    }
    
    public boolean setIsManual(boolean isManual)
    {
        this.isManual = isManual;
        if(isManual == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String toString()
    {
        this.carID = carID;
        this.type = type;
        this.brand = brand;
        this.isManual = isManual;
        String gear;
        
        if(type == 'A' || type == 'B' || type == 'C' || type == 'D')
        {
            type = type;
        }
        else
        {
            type = typeDef;
        }
        
        if(isManual == true)
        {
            gear = "manual";
        }
        else
        {
            gear = "auto";
        }
        
        return "id: " + carID + " type: " + type + " brand: " + brand + " gear: " + gear;
    }
    
    public boolean equals(Car other)
    {
        if(this.type == other.type && (this.brand).equals(other.brand) && this.isManual == other.isManual)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean better(Car other)
    {
        if(this.type == 'D') return true;
        else if(this.type == 'C' && other.type == 'D') return false;
        else if(this.type == 'C' && other.type != 'D') return true;
        else if(this.type == 'B' && other.type == 'A') return true;
        else if(this.type == 'B' && other.type != 'A') return false;
        else if(this.type == 'A' && other.type != 'A') return false;
        else if(this.type == other.type && this.isManual == true && other.isManual == false) return true;
        else return false;
    }
    
    public boolean worse(Car other)
    {
        if(this.better(other)) return false;
        else return true;
    }
    
    
    
    
    
    
    
    
    
    
    
}
