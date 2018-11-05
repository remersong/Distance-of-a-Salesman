public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        Population population=new Population();
        population.createPopulation();
        population.display();
        for (int i=0; i<2000; i++) {
            population.Update();
            population.display();
        }
    }
}
