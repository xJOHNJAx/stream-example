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
        task1();
        List<Animal> animals = Util.getAnimals();
        List<Animal> youngAnimalsSorted = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .toList();
        System.out.println("Животные от 10 до 20 лет:");
        youngAnimalsSorted.forEach(System.out::println);
        List<Animal> animalsForThirdZoo = youngAnimalsSorted.stream()
                .skip(14)
                .limit(7)
                .toList();
        System.out.println("Животные из третьего зоопарка:");
        animalsForThirdZoo.forEach(System.out::println);
    }

//    public static void main(String[] args) throws IOException {
//        task2();
//        List<Animal> animals = Util.getAnimals();
//        animals.stream()
//                .filter(animal -> "Japanese".equals(animal.getOrigin()))
//                .map(animal -> {
//                    String breed = "Female".equals(animal.getGender()) ? animal.getbreed()
//                            .toUpperCase() : animal.getbreed();
//                    return new Animal(animal.getId(), breed, animal.getAge(), animal.getOrigin(), animal.getGender());
//                })
//                .forEach(animal -> System.out.println(animal.getbreed()));
//    }

//    public static void main(String[] args) throws IOException {
//        task3();
//        List<Animal> animals = Util.getAnimals();
//        List<String> countriesStartingWithA = animals.stream()
//                .filter(animal -> animal.getAge() > 30)
//                .map(Animal::getOrigin)
//                .filter(origin -> origin.startsWith("A"))
//                .map(String::toUpperCase)
//                .distinct()
//                .toList();
//        countriesStartingWithA.forEach(System.out::println);
//    }
////
//    public static void main(String[] args) throws IOException {
//        task4();
//        List<Animal> animals = Util.getAnimals();
//        long femaleCount = animals.stream()
//                .filter(animal -> "Female".equals(animal.getGender()))
//                .count();
//        System.out.println("Количество животных женского пола: " + femaleCount);
//    }
//
//    public static void main(String[] args) throws IOException {
//        task5();
//        List<Animal> animals = Util.getAnimals();
//        boolean hasHungarian = animals.stream()
//                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
//                .anyMatch(animal -> "Hungarian".equals(animal.getOrigin()));
//        System.out.println("Среди животных возрастом 20-30 лет есть хоть одно из Венгрии: " + hasHungarian);
//    }
//
//    public static void main(String[] args) throws IOException {
//        task6();
//        List<Animal> animals = Util.getAnimals();
//        boolean allMaleOrFemale = animals.stream()
//                .allMatch(animal -> "Male".equals(animal.getGender()) || "Female".equals(animal.getGender()));
//        System.out.println("Все животные имеют пол Male или Female: " + allMaleOrFemale);
//    }
//
//    public static void main(String[] args) throws IOException {
//        task7();
//        List<Animal> animals = Util.getAnimals();
//        boolean noneFromOceania = animals.stream()
//                .noneMatch(animal -> "Oceania".equals(animal.getOrigin()));
//        System.out.println("Ни одно животное не имеет страну происхождения Oceania: " + noneFromOceania);
//    }
//
//    public static void main(String[] args) throws IOException {
//        task8();
//        List<Animal> animals = Util.getAnimals();
//        List<Animal> sortedAnimals = animals.stream()
//                .sorted(Comparator.comparing(Animal::getbreed))
//                .limit(100)
//                .toList();
//        int oldestAge = sortedAnimals.stream()
//                .mapToInt(Animal::getAge)
//                .max()
//                .orElse(-1);
//        System.out.println("Возраст самого старого животного среди первых 100: " + oldestAge);
//    }
//
//    public static void main(String[] args) throws IOException {
//        task9();
//        List<Animal> animals = Util.getAnimals();
//        Map<String, Integer> breedLengths = animals.stream()
//                .map(Animal::getbreed)
//                .collect(Collectors.toMap(
//                        breed -> breed,
//                        String::length,
//                        (existing, replacement) -> existing
//                ));
//        Optional<Integer> shortestBreedLength = breedLengths.values().stream()
//                .min(Integer::compare);
//        System.out.println("Длина самого короткого массива символов: " +
//                shortestBreedLength.orElse(0));
//    }
//
//    public static void main(String[] args) throws IOException {
//        task10();
//        List<Animal> animals = Util.getAnimals();
//        int totalAge = animals.stream()
//                .mapToInt(Animal::getAge)
//                .sum();
//        System.out.println("Суммарный возраст всех животных: " + totalAge);
//    }
//
//    public static void main(String[] args) throws IOException {
//        task11();
//        List<Animal> animals = Util.getAnimals();
//        OptionalDouble averageAge = animals.stream()
//                .filter(animal -> "Indonesian".equals(animal.getOrigin()))
//                .mapToInt(Animal::getAge)
//                .average();
//        System.out.println("Средний возраст всех животных из Индонезии: " +
//                (averageAge.isPresent() ? averageAge.getAsDouble() : "Нет данных по животным из Индонезии."));
//    }
////
//    public static void main(String[] args) throws IOException {
//        task12();
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
//        public static void main(String[] args) throws IOException {
//        task13();
//        List<House> houses = Util.getHouses();
//        int retirementAge = 65;
//        LocalDate currentDate = LocalDate.now();
//        List<Person> evacuated = houses.stream()
//                .flatMap(house -> house.getPersonList().stream())
//                .map(person -> new AbstractMap.SimpleEntry<>(
//                        person,
//                        Period.between(person.getDateOfBirth(), currentDate)
//                                .getYears()))
//                .sorted(Comparator
//                        .comparing((AbstractMap.SimpleEntry<Person, Integer> entry) -> entry
//                                .getKey().getRecruitmentGroup() != 1)
//                        .thenComparing(entry -> {
//                            int age = entry.getValue();
//                            return age < 18 || age >= retirementAge;
//                        })
//                        .thenComparingInt(entry -> entry.getKey().getId()))
//                .limit(500)
//                .map(AbstractMap.SimpleEntry::getKey)
//                .toList();
//        evacuated.forEach(System.out::println);
//    }
//
//    public static void main(String[] args) throws IOException {
//        task14();
//        List<Car> cars = Util.getCars();
//        Map<Integer, Double> echelonsMass = cars.stream()
//                .collect(Collectors.groupingBy(
//                        car -> Stream.of(
//                                        new AbstractMap.SimpleEntry<>(1, car.getCarMake()
//                                                .equals("Jaguar") || car.getColor().equals("White")),
//                                        new AbstractMap.SimpleEntry<>(2, car
//                                                .getMass() <= 1500 && Stream
//                                                .of("BMW", "Lexus", "Chrysler", "Toyota")
//                                                .anyMatch(brand -> brand.equals(car.getCarMake()))),
//                                        new AbstractMap.SimpleEntry<>(3, car
//                                                .getColor().equals("Black") && car.getMass() > 4000 ||
//                                                Stream.of("GMC", "Dodge")
//                                                        .anyMatch(brand -> brand.equals(car.getCarMake()))),
//                                        new AbstractMap.SimpleEntry<>(4, car
//                                                .getReleaseYear() < 1982 || Stream.of("Civic", "Cherokee")
//                                                .anyMatch(model -> model.equals(car.getCarModel()))),
//                                        new AbstractMap.SimpleEntry<>(5, Stream
//                                                .of("Yellow", "Red", "Green", "Blue")
//                                                .noneMatch(color -> color.equals(car.getColor())) ||
//                                                car.getPrice() > 40000),
//                                        new AbstractMap.SimpleEntry<>(6, car
//                                                .getVin().contains("59")))
//                                .filter(AbstractMap.SimpleEntry::getValue)
//                                .findFirst()
//                                .map(AbstractMap.SimpleEntry::getKey)
//                                .orElse(0),
//                        Collectors.summingDouble(Car::getMass)
//                ));
//        echelonsMass.remove(0);
//        double costPerTonne = 7.14;
//        double totalRevenue = 0;
//        for (Map.Entry<Integer, Double> entry : echelonsMass.entrySet()) {
//            double cost = (entry.getValue() / 1000) * costPerTonne;
//            totalRevenue += cost;
//            System.out.println("Эшелон " + entry.getKey() + ": " + cost + " $");
//        }
//        System.out.println("Общая выручка: " + totalRevenue + " $");
//    }
//
//    public static void main(String[] args) throws IOException {
//        task15();
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
//        String totalCost = calculateTotalCost(sortedAndFilteredFlowers);
//        System.out.println("Общая стоимость обслуживания выбранных растений: $" + totalCost);
//    }
//
//    private static String calculateTotalCost(List<Flower> flowers) {
//        double cost = 0;
//        for (Flower flower : flowers) {
//            double waterCost = flower.getWaterConsumptionPerDay() * 5 * 365 * 1.39;
//            cost += flower.getPrice() + waterCost;
//        }
//        return String.format("%.2f", cost);
//    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
    }
}

