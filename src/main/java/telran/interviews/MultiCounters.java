package telran.interviews;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MultiCounters {

    HashMap<Object, Integer> items = new HashMap<>();
    TreeMap<Integer, Set<Object>> counters = new TreeMap<>();

    public int addCounter(Object item) {
        int res = items.merge(item, 1, Integer::sum);
        if (res > 1) {
            removeItemFromCounter(item, res - 1);
        }
        counters.computeIfAbsent(res, k -> new HashSet<>());
        return res;
    }

    public void removedItem(Object item) throws NoSuchAlgorithmException {
        int counter = getCounter(item);
        items.remove(item);
        Set<Object> itemsWithCounter = counters.get(counter);
        itemsWithCounter.remove(item);
        counters.remove(counter);

    }

    public int getCounter(Object item) throws NoSuchAlgorithmException {
        int counter = items.getOrDefault(item, 0);
        if (counter == 0) {
            throw new NoSuchAlgorithmException();
        }
        return counter;
    }

    public Set<Object> getItemsByCounter(int counterFrom, int counterTo) {
        return counters.subMap(counterFrom, true, counterTo, true).values().stream().flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public Set<Object> getItemsMaxCounter() {
        return counters.lastEntry().getValue();
    }

    private void removeItemFromCounter(Object item, int counter) {
        Set<Object> itemsWithCounter = counters.get(counter);
        itemsWithCounter.remove(item);
        counters.remove(counter);
    }

}