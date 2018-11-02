import java.util.*;

public class Population {
    TestCities tc = new TestCities();
    ArrayList<City> cities = tc.getCities();
    ArrayList<City>[] population = new ArrayList[20];


    public void createPopulation() {
        for (int i = 0; i < population.length; i++) {
            population[i] = new ArrayList<City>();
            population[i].add(cities.get(0));
        }
        int rand;
        for (int i = 0; i < population.length; i++) {
            while (!containsAll(population[i])) {
                rand = (int) (Math.random() * (cities.size() - 1) + 1);
                if (!population[i].contains(cities.get(rand))) {
                    population[i].add(cities.get(rand));
                }
            }
            population[i].add(cities.get(0));
        }

    }

    public void display() {
        int x=0;
        for (ArrayList<City> b : population) {
            System.out.println();
            x++;
            System.out.println("Number " + x + ":  ");
            for (City e : b) {
                System.out.print(e.getID() + " ");
            }
            System.out.println();
            System.out.println("Distance:" + getScore(b));

        }
    }

    public boolean containsAll(ArrayList<City> b) {
        boolean containsAll = true;
        for (int i = 0; i < cities.size(); i++) {
            if (!b.contains(cities.get(i))) {
                containsAll = false;
            }
        }
        return containsAll;
    }

    public int getScore(ArrayList<City> cit) {
        int sum = 0;
        for (int i = 0; i < cit.size() - 1; i++) {
            int xLength = Math.abs(cit.get(i).getX() - cit.get(i + 1).getX());
            int yLength = Math.abs(cit.get(i).getX() - cit.get(i + 1).getX());

            sum += Math.sqrt(xLength * xLength + yLength * yLength);
        }

        return sum;
    }

    public void Sort() { //the holy grail of computer science????
        List list = Arrays.asList(population); //OMIT
        Collections.sort(list, new Comparator<ArrayList<City>>() { //USE POPULATION INSTEAD OF LIST
            public int compare(ArrayList<City> o1, ArrayList<City> o2) {
                return getScore(o1) - getScore(o2);
            }
        });


        population = (ArrayList<City>[]) list.toArray(); //OMIT
//        for (int i = 0; i < backpacks.length / 2; i++) {
//            ArrayList<Element> temp = backpacks[i];
//            backpacks[i] = backpacks[backpacks.length - 1 - i];
//            backpacks[backpacks.length - 1 - i] = temp;
//        }
    }

    public void Update() {
        Sort();
        for (int i = population.length / 2; i < population.length; i++) {
            population[i]=Mutate(population[i-population.length/2]);
        }
    }

    public ArrayList<City> Mutate(ArrayList<City> g) {
        ArrayList<City> b = new ArrayList<>(g);
        int odds = (int) (Math.random() * 2);
        int rand;
        int rand2;
        City temp;
        if (odds==0){
            rand=(int)(Math.random()*(b.size()-2)+1);
            rand2=(int)(Math.random()*(b.size()-2)+1);
            temp=b.get(rand);
            b.set(rand, b.get(rand2));
            b.set(rand2, temp);
        }
        return b;
    }


}

