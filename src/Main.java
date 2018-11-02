public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        Population population=new Population();
        population.createPopulation();
        population.display();
        while(1!=2) {
            population.Update();
            population.display();
        }
    }
}
