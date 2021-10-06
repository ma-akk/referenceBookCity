package com.example.referencebookcity.data;

import com.example.referencebookcity.models.City;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class InputData {
    public List<City> inputCities() throws Exception {
        List<City> cities = new ArrayList<City>();
        String dateStr;
        DateFormat format = new SimpleDateFormat("yyyy", Locale.ENGLISH);

        File fileName = new File("src/main/java/com/example/referencebookcity/data/test.txt");
        Scanner scanner = new Scanner(fileName);
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            City city = new City();
            city.setId(scanner.nextLong());
            city.setName(scanner.next());
            city.setRegion(scanner.next());
            city.setDistrict(scanner.next());
            city.setPopulation(scanner.nextInt());
            dateStr = scanner.next();
            city.setFoundation(format.parse(dateStr));
            cities.add(city);
        }
        return cities;
    }
}
