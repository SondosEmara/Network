


public class Area_Arguments_20190249 {

    public static void main(String[] args) {
        
        double Area,Lenght;
        String ShapeName;
        
        switch (args.length) {
            
            case 0:
                
                Area=4*4;
                System.out.println("The Lenght Of default  Square is:"+4);
                System.out.println("The Area Of Square is:"+Area);
                break;
                
            case 2:
            case 3:
                
                ShapeName=args[0];
                if (ShapeName.compareToIgnoreCase("Square")==0){
                    
                    System.out.println("The Lenght Of Square is:"+args[1]);
                    Lenght=Double.parseDouble(args[1]);
                    Area=Lenght*Lenght;
                    System.out.println("The Area Of Square is:"+Area);
                    
                }
                
                else if (ShapeName.compareToIgnoreCase("Rectangle")==0){
                    
                    System.out.println("The Lenght Of  Rectangle is:"+args[1]);
                    System.out.println("The Width Of  Rectangle is:"+args[2]);
                    Lenght=Double.parseDouble(args[1]);
                    double Width=Double.parseDouble(args[2]);
                    Area=Width*Lenght;
                    System.out.println("The Area Of Rectangle is:"+Area);
                    
                }
                
                else if(ShapeName.compareToIgnoreCase("Circle")==0){
                    
                    double Radies=Double.parseDouble(args[1]);
                    Area=3.14*Radies*Radies;
                    System.out.println("The Radies Of Circle  is:"+args[1]);
                    System.out.println("The Area Of Circle is:"+Area);
                    
                }
                else  System.out.println("The Shape Not Defines");
                break;
                
            default:
                System.out.println("Error,The Number of Arguments Not Correct,Try Again");
        }
    }
    
}


