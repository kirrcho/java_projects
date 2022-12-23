import com.sun.source.tree.BinaryTree;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
        List<String> arr = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/common/MOCK_DATA.csv"))) {
            String DELIMITER = ",";
            String line;

            int i = 1;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(DELIMITER);
                var row = String.join(", ", columns);
                ht1.put(i, row);
                lhm.put(i, row);
                arr.add(row);
                linkedList.add(row);
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        var random = new Random();
        var index = random.nextInt(0,49999);
        var randomValue = arr.get(index);

        System.out.println(index);

        var ht1getValueStart = System.currentTimeMillis();
        var ht1El = ht1.containsValue(randomValue);
        var ht1getValueEnd = System.currentTimeMillis();
        var ht1elapsedTime = ht1getValueEnd - ht1getValueStart;
        System.out.println("hash table miliseconds to find if element exists: " + ht1elapsedTime);

        var ht1deleteValueStart = System.currentTimeMillis();
        var ht1delEl = ht1.values().remove(randomValue);
        var ht1deleteValueEnd = System.currentTimeMillis();
        var ht1deleteelapsedTime = ht1deleteValueEnd - ht1deleteValueStart;
        System.out.println("hash table miliseconds to delete element by value: " + ht1deleteelapsedTime);

        var lhmgetValueStart = System.currentTimeMillis();
        var lhmEl = lhm.containsValue(randomValue);
        var lhmgetValueEnd = System.currentTimeMillis();
        var lhmelapsedTime = lhmgetValueEnd - lhmgetValueStart;
        System.out.println("linked hash map miliseconds to find if element exists: " + lhmelapsedTime);

        var lhmdeleteValueStart = System.currentTimeMillis();
        var lhmdelEl = lhm.values().remove(randomValue);
        var lhmdeleteValueEnd = System.currentTimeMillis();
        var lhmdeleteelapsedTime = lhmdeleteValueEnd - lhmdeleteValueStart;
        System.out.println("linked hash map miliseconds to delete element by value: " + lhmdeleteelapsedTime);

        var arrgetValueStart = System.currentTimeMillis();
        var arrEl = arr.indexOf(randomValue);
        var arrgetValueEnd = System.currentTimeMillis();
        var arrelapsedTime = arrgetValueEnd - arrgetValueStart;
        System.out.println("ArrayList miliseconds to find if element exists: " + arrelapsedTime);

        var arrdeleteValueStart = System.currentTimeMillis();
        var arrdelEl = arr.remove(randomValue);
        var arrdeleteValueEnd = System.currentTimeMillis();
        var arrdeleteelapsedTime = arrdeleteValueEnd - arrdeleteValueStart;
        System.out.println("ArrayList miliseconds to delete element by value: " + arrdeleteelapsedTime);

        var linkedListgetValueStart = System.currentTimeMillis();
        var linkedListEl = linkedList.indexOf(randomValue);
        var linkedListgetValueEnd = System.currentTimeMillis();
        var linkedListelapsedTime = linkedListgetValueEnd - linkedListgetValueStart;
        System.out.println("LinkedList miliseconds to find if element exists: " + linkedListelapsedTime);

        var linkedListdeleteValueStart = System.currentTimeMillis();
        var linkedListdelEl = linkedList.remove(randomValue);
        var linkedListdeleteValueEnd = System.currentTimeMillis();
        var linkedListdeleteelapsedTime = linkedListdeleteValueEnd - linkedListdeleteValueStart;
        System.out.println("LinkedList miliseconds to delete element by value: " + linkedListdeleteelapsedTime);
    }
}