public class TemperatureConverter {
    public String convertTemp (int temperature, char convertTo) {
        if (convertTo == 'F')
        {
//      temperature should be converted to Farengates
            temperature=temperature+32;
            System.out.println("Temperature is: " + temperature + " `F");
        }
        else if (convertTo == 'C')
        {
//      temperature should be converted to Celsius
            temperature=temperature-32;
            System.out.println("Temperature is: " + temperature + " `C");
        }
        else
            {
            System.out.println("Wrong temperature measure: " + convertTo);
        }
        return "Temperature is: " + temperature + convertTo;
    }
}
