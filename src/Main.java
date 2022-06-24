import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // WHAT ARE STREAMS
        // instead of being concerned with every small step (the loop, the variables, the conditional statement etc), we are concerned with the big picture
        // to move away from imperative programming, and towards declarative programming

        // imperative programming
        // us needing to declare every step of the process
        // declare array 1
        // declare array 2
        // declare the loop, the increments
        // declare the if statements and variables

        // declarative
        // no need to declare every step of the way
        // we simply ask for what we want and get it back

        // given an ArrayList of ages, calculate me the average age
        ArrayList<Integer> ages = new ArrayList<>(Arrays.asList(3, 4, 66, 50, 32, 10, 22, 78, 44, 40));

        // imperative
        int sum = 0;
        for (int i = 0; i < ages.size(); i++) {
            sum += ages.get(i);
        }
        int average = sum / ages.size();
        System.out.println(average);

        // declarative
        // 1. Always start with an implementation of a Collection
        // Arrays
        // Sets
        // Maps
        // Lists
        // 2. invoke our stream() method
        // from this point on, we can have as many streams as we want
        // a map
        // a filter, etc
        // these are called intermediate operators
        // 3. we are now done with our stream, and want to return to a concrete implementation (Int, String, List etc)
        // these are called terminal operators
        // collect(Collectors.toList())

//        Convert your list to a stream(ages.stream()) then map your age to double(mapToDouble())
//        then call average.
        double averageAge = ages.stream().mapToDouble(a -> a).average().getAsDouble();
        System.out.println(averageAge);

        System.out.println("----------------------------------------------------------------------");

        // given an ArrayList of words, return me an ArrayList of long words that have over 6 letters in them

        ArrayList<String> words = new ArrayList<>(Arrays.asList("pen", "custom", "orphanage",
                "forest", "bubble", "butterfly"));
        ArrayList<String> longWords = new ArrayList<>();

        //  int length = 0;
        for (int i = 0; i < words.size(); i++) {

            if (words.get(i).length() > 6) {
                longWords.add(words.get(i));
                //  System.out.println("contains names with more than 6 letters");
            }
        }
//        System.out.println("contain words with greater than 6 letters:" + longWords);

        List<String> result = words.stream().filter(word -> word.length() > 6)
                .collect(Collectors.toList());

        System.out.println(result);

        System.out.println("----------------------------------------------------------------------");
        // given an ArrayList of names, return me an ArrayList of long names that have over 4 letters in them

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Sam", "Andy", "Josie", "Ashlee", "Rob"));
        ArrayList<String> longNames = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 4) {
                longNames.add(name);
            }
        }
//        System.out.println(longNames);

        System.out.println("----------------------------------------------------------------------");
        // given an ArrayList of names, return me an ArrayList of long names that have over 4 letters in them
        List<String> lonngNames = names.stream().filter(name -> name.length() > 4).collect(Collectors.toList());
        System.out.println(lonngNames);

        System.out.println("----------------------------------------------------------------------");
        // return me a count of the names (how many there are)
        long countNames = names.stream().count();
        System.out.println(countNames);

        System.out.println("----------------------------------------------------------------------");
        // sout only the first 3 names
        List<String> threeNames = names.stream().limit(3).collect(Collectors.toList());
        System.out.println("First 3 names:" + threeNames);

        System.out.println("----------------------------------------------------------------------");
        // make a new ArrayList with each entry
        // 1. less than 5 characters, and
        // 2. prefixed with "Has less than 5 characters: ", e.g. "Has less than 5 characters: Sam"
        names.stream().filter(name -> name.length() < 5)
                .forEach(System.out::println);


        System.out.println("----------------------------------------------------------------------");
        // Names beginning with "A"
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);


        System.out.println("----------------------------------------------------------------------");
        // make a new ArrayList with each entry prefixed with "Coach called ", e.g. "Coach called Same"
        List<String> coach = names.stream().map(name -> "Coach called " + name).collect(Collectors.toList());
        System.out.println(coach);



        System.out.println("----------------------------------------------------------------------");
        System.out.println("WORKING WITH OBJECT");
        // WORKING WITH OBJECT

        List<Person> people = getPeople();

        // check if all items in the list meet condition
        boolean allVeryOld = people.stream().allMatch(person -> person.getAge() > 80);
        System.out.println(allVeryOld);

        // check if one item in the list meet condition
        boolean atLeastOneIsVeryOld = people.stream().anyMatch(person -> person.getAge() > 80);
        System.out.println(atLeastOneIsVeryOld);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Elon Musk", 49, "Male"),
                new Person("Donald Trump", 75, "Male"),
                new Person("Queen Elizabeth II", 94, "Female"),
                new Person("Mother Teresa", 87, "Female")
        );
    }
}



