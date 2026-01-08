package entities;

public class StringG {
    String stringG;

    public StringG (String stringG){
        this.stringG = stringG;
    }

    @Override
    public String toString(){
        return this.stringG;
    }

    @Override
    public int hashCode(){
        return this.stringG.hashCode() * 23 / 42;
    }

    public static void main(String[] args) {
        String str1 = new String("Maria");
        StringG str2 = new StringG("Maria");

        System.out.println(str1.hashCode() * 23 / 42);
        System.out.println(str2.hashCode());
    }
}
