interface Animal{
    public String feature();
}

abstract class Bird implements Animal {
    abstract int fly(int hour);
}

class Swallow extends Bird {
    @Override
    public String feature() {
        return "medium size";
    }
    @Override
    int fly(int hour) {
        int s = 150*hour;
        System.out.println("Swallow with " + this.feature() + " and " + hour 
                + " hours flying about " + s + " kilometers.");
        return s;
    }
}

class Hummingbird extends Bird {
    @Override
    public String feature() {
        return "small size";
    }
    @Override
    int fly(int hour) {
        int s = 50*hour;
        System.out.println("Hummingbird with " + this.feature() + " and " + hour  
                + " hours flying about " + s + " kilometers.");
        return s;
    }
    
}

class Eagle extends Bird {
    @Override
    public String feature() {
        return "large size";
    }
    @Override
    int fly(int hour) {
        int s = 100*hour;
        System.out.println("Eagle with " + this.feature() + " and " + hour  
                + " hours flying about " + s + " kilometers.");
        return s;
    }    
}

public class PA4 {    
    public static int distance;    
    public int getDistance() {    
        Swallow sw = new Swallow();
        distance += sw.fly(1);
        Hummingbird hu = new Hummingbird();
        distance += hu.fly(2);
        Eagle ea = new Eagle();
        distance += ea.fly(2);    
        return distance;
    }
    public static void main(String[] args) {
        System.out.println("The birds relay fly distance about " 
                + new PA4().getDistance() + " kilometers.");
    }
}
