package com.example.referencebookcity;

import com.example.referencebookcity.models.City;
import com.example.referencebookcity.repository.CityRepository;
import com.example.referencebookcity.servicies.CityServicies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ReferenceBookCityApplication implements CommandLineRunner {
    private Scanner scan = new Scanner(System.in);
    private static ApplicationContext applicationContext;
    private CityServicies cityServicies;

    public ReferenceBookCityApplication(CityServicies cityServicies) {
        this.cityServicies = cityServicies;
    }

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(ReferenceBookCityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int opp = -1;

        while (opp != 0) {
            showMenu();
            opp = scan.nextInt();
            chooseMenu(opp);
        }
    }

    public void showMenu() {
        System.out.println("Reference Book of Cities. Choose the appropriate option (input the number)");
        System.out.println("1. List of cities;");
        System.out.println("0. Exit");
    }

    public void chooseMenu(int opp) {
        switch (opp) {
            case 0:
                System.out.println("See you soon!");
                cityServicies.exitApp(applicationContext);
                break;
            case 1 :
                for (City city : cityServicies.getCities())
                    System.out.println(city);
                break;
            default:
                System.out.println("Check your option!");
                break;
        }
    }
}
