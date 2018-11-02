import java.util.ArrayList;

public class Population {
    TestCities tc=new TestCities();
    ArrayList<City> cities = tc.getCities();
    ArrayList<City>[] population = new ArrayList[20];


    public void createPopulation(){
        for (int i=0; i<population.length; i++){
            population[i]=new ArrayList<City>();
            population[i].add(cities.get(0));
        }
        int rand;
        for (int i=0; i<population.length; i++){
            while (!containsAll(population[i])){
                rand=(int)(Math.random()*(cities.size()-1)+1);
                if (!population[i].contains(cities.get(rand))){
                    population[i].add(cities.get(rand));
                }
            }
            population[i].add(cities.get(0));
        }

    }

    public void display() {
        for (ArrayList<City> b : population) {
            System.out.println();
            for (City e : b) {
                System.out.print(e.getID() + " ");
            }
            System.out.println();

        }
    }

        public boolean containsAll (ArrayList < City > b) {
            boolean containsAll = true;
            for (int i = 0; i < cities.size(); i++) {
                if (!b.contains(cities.get(i))) {
                    containsAll = false;
                }
            }
            return containsAll;
        }

//

    }

