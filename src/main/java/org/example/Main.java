package org.example;

import org.example.model.*;
import org.example.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();}

//        task2();}
//
//        task3();}
//
//        task4();}
//
//        task5();}
//
//        task6();}
//
//        task7();}
//
//        task8();}
//
//        task9();}
//
//        task10();}
//
//        task11();}
//
//        task12();}
//
//        task13();}
//
//        task14();}
//
//        task15();}

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        List<Animal> animalsForThirdZoo = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .skip(14)
                .limit(7)
                .toList();

        System.out.println("Животные от 10 до 20 лет:");
        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .forEach(System.out::println);

        System.out.println("Животные из третьего зоопарка:");
        animalsForThirdZoo.forEach(System.out::println);
    }

//    private static void task2() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        animals.stream()
//                .filter(animal -> "Japanese".equals(animal.getOrigin()))
//                .map(animal -> {
//                    return !"Female".equals(animal.getGender()) ? animal.getBreed() : animal
//                            .getBreed().toUpperCase();
//                })
//                .forEach(System.out::println);
//    }
//
//    private static void task3() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        animals.stream()
//                .filter(animal -> animal.getAge() > 30)
//                .map(Animal::getOrigin)
//                .filter(origin -> origin.startsWith("A"))
//                .distinct()
//                .forEach(System.out::println);
//    }
//
//    private static void task4() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        long femaleCount = animals.stream()
//                .filter(animal -> "Female".equals(animal.getGender()))
//                .count();
//        System.out.println("Количество животных женского пола: " + femaleCount);
//    }
//
//    private static void task5() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        boolean hasHungarian = animals.stream()
//                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
//                .anyMatch(animal -> "Hungarian".equals(animal.getOrigin()));
//        System.out.println("Среди животных возрастом 20-30 лет есть хоть одно из Венгрии: " + hasHungarian);
//    }
//
//    private static void task6() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        boolean allMaleOrFemale = animals.stream()
//                .allMatch(animal -> "Male".equals(animal.getGender()) || "Female".equals(animal.getGender()));
//        System.out.println("Все животные имеют пол Male или Female: " + allMaleOrFemale);
//    }
//
//    private static void task7() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        boolean noneFromOceania = animals.stream()
//                .noneMatch(animal -> "Oceania".equals(animal.getOrigin()));
//        System.out.println("Ни одно животное не имеет страну происхождения Oceania: " + noneFromOceania);
//    }
//
//    private static void task8() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        int oldestAge = animals.stream()
//                .sorted(Comparator.comparing(Animal::getBreed))
//                .limit(100)
//                .mapToInt(Animal::getAge)
//                .max()
//                .orElse(-1);
//        System.out.println("Возраст самого старого животного среди первых 100: " + oldestAge);
//    }
//
//    private static void task 9()throws
//
//    IOException {
//        List<Animal> animals = Util.getAnimals();
//        int shortestBreedLength = animals.stream()
//                .map(Animal::getBreed)
//                .mapToInt(String::length)
//                .min()
//                .orElse(0);
//        System.out.println("Длина самого короткого массива символов: " + shortestBreedLength);
//    }
//
//    private static void task10() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        int totalAge = animals.stream()
//                .mapToInt(Animal::getAge)
//                .sum();
//        System.out.println("Суммарный возраст всех животных: " + totalAge);
//    }
//
//    private static void task11() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        OptionalDouble averageAge = animals.stream()
//                .filter(animal -> "Indonesian".equals(animal.getOrigin()))
//                .mapToInt(Animal::getAge)
//                .average();
//        System.out.println("Средний возраст всех животных из Индонезии: " +
//                (averageAge.isPresent() ? averageAge.getAsDouble() : "Нет данных по животным из Индонезии."));
//    }
//
//    private static void task12() throws IOException {
//        List<Person> recruits = Util.getPersons();
//        LocalDate now = LocalDate.now();
//        List<Person> selectedRecruits = recruits.stream()
//                .filter(person -> person.getGender().equalsIgnoreCase("male"))
//                .filter(person -> Period.between(person.getDateOfBirth(), now).getYears() >= 18)
//                .filter(person -> Period.between(person.getDateOfBirth(), now).getYears() <= 27)
//                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
//                .limit(200)
//                .toList();
//        selectedRecruits.forEach(System.out::println);
//    }
//
//    private static void task13() throws IOException {
//        List<House> houses = Util.getHouses();
//        int retirementAge = 65;
//        LocalDate currentDate = LocalDate.now();
//        List<Person> evacuated = houses.stream()
//                .flatMap(house -> house.getPersonList().stream())
//                .map(person -> new AbstractMap.SimpleEntry<>(
//                        person,
//                        Period.between(person.getDateOfBirth(), currentDate).getYears()))
//                .sorted(Comparator
//                        .comparing((AbstractMap.SimpleEntry<Person, Integer> entry) -> entry.getKey()
//                                .getRecruitmentGroup())
//                        .thenComparing(entry -> {
//                            int age = entry.getValue();
//                            return !(age < 18 || age >= retirementAge);
//                        })
//                        .thenComparingInt(entry -> entry.getKey().getId()))
//                .limit(500)
//                .map(AbstractMap.SimpleEntry::getKey)
//                .toList();
//        evacuated.forEach(System.out::println);
//    }
//
//    private static void task14() throws IOException {
//        List<Car> cars = Util.getCars();
//        double costPerTonne = 7.14;
//        double totalRevenue = cars.stream()
//                .collect(Collectors.groupingBy(
//                        car -> car.getCarMake().equals("Jaguar") || car.getColor().equals("White") ? 1 :
//                                car.getMass() <= 1500 && Arrays.asList("BMW", "Lexus", "Chrysler", "Toyota")
//                                        .contains(car.getCarMake()) ? 2 :
//                                        car.getColor().equals("Black") && car.getMass() > 4000 || Arrays
//                                                .asList("GMC", "Dodge").contains(car.getCarMake()) ? 3 :
//                                                car.getReleaseYear() < 1982 || Arrays.asList("Civic", "Cherokee")
//                                                        .contains(car.getCarModel()) ? 4 :
//                                                        !Arrays.asList("Yellow", "Red", "Green", "Blue")
//                                                                .contains(car.getColor()) || car
//                                                                .getPrice() > 40000 ? 5 :
//                                                                car.getVin().contains("59") ? 6 : 0,
//                        Collectors.summingDouble(Car::getMass)))
//                .entrySet().stream()
//                .filter(entry -> entry.getKey() != 0)
//                .mapToDouble(entry -> {
//                    double cost = (entry.getValue() / 1000) * costPerTonne;
//                    System.out.println("Эшелон " + entry.getKey() + ": " + cost + " $");
//                    return cost;
//                })
//                .sum();
//
//        System.out.println("Общая выручка: " + totalRevenue + " $");
//    }
//
//    private static void task15() throws IOException {
//        List<Flower> flowers = Util.getFlowers();
//        List<Flower> sortedAndFilteredFlowers = flowers.stream()
//                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
//                        .thenComparing(Flower::getPrice).reversed()
//                        .thenComparing(Comparator.comparing(Flower::getWaterConsumptionPerDay).reversed()))
//                .filter(flower -> flower.getCommonName().toUpperCase().charAt(0) <= 'S')
//                .filter(flower -> flower.getCommonName().toUpperCase().charAt(0) >= 'C')
//                .filter(Flower::isShadePreferred)
//                .filter(flower -> flower.getFlowerVaseMaterial().stream().anyMatch(material ->
//                        material.equalsIgnoreCase("glass") ||
//                                material.equalsIgnoreCase("aluminum") ||
//                                material.equalsIgnoreCase("steel")))
//                .collect(Collectors.toList());
//
//        double totalCost = calculateTotalCost(sortedAndFilteredFlowers);
//        System.out.println("Общая стоимость обслуживания выбранных цветов: $" + String.format("%.2f", totalCost));
//    }
//
//    private static double calculateTotalCost(List<Flower> flowers) {
//        return flowers.stream()
//                .mapToDouble(flower -> flower.getPrice() + (flower.getWaterConsumptionPerDay() * 5 * 365 * 1.39))
//                .sum();
//    }
}

