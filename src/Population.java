import java.util.ArrayList;

public class Population {
    TestCities tc = new TestCities();
    ArrayList<City> cities = tc.getCities();
    ArrayList<City>[] population = new ArrayList[20];

    public int getScore(ArrayList<City> cit){
        int sum = 0;
        for (int i = 0; i < cit.size() - 1; i++) {
            int xLength = Math.abs(cit.get(i).getX() - cit.get(i + 1).getX());
            int yLength = Math.abs(cit.get(i).getX() - cit.get(i + 1).getX());

            sum += Math.sqrt(xLength * xLength + yLength * yLength);
        }

        return sum;
    }


}
