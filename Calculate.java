package Calculator;


public class Calculate{    
    double num1;
    double num2;
    double result;
    
    public Calculate(){
        num1 = 0;
        num2 = 0;
        result = 0;
    }
    
    public double add(double num1, double num2){
        return result = num1 + num2;
    }
    
    public double subtract(double num1, double num2){
        return result = num1 - num2;
    }
    
    public double multiply(double num1, double num2){
        return result = num1 * num2;
    }
    
    public float divide(double num1, double num2){
        result = num1 / num2;
        return (float)result;
    }
    
    public double squareRoot(double num1){
        return result = StrictMath.sqrt(num1);
    }
    
    public double modulo(double num1, double num2){
        return result = num1 % num2;

    }
    
    public double exponential(double num1, double num2){
        return result = StrictMath.pow(num1, num2);
    }
    
    public double percent(double num1){
        return result = (num1 / 100);
    }
}
