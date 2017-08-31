package prefix;

import java.util.*;

public class Dictionary {
    /**
     * hash set has some properties for prefix dictionary
     * 1. sort in alphabetically
     * 2. no duplicated word.
     */
    private Set<String> names = new HashSet<>();

    /**
     * hash map
     * key Character as the prefix
     * value the sub dictionary for it.
     */
    private Map<Character, Dictionary> prefixMap = new HashMap<>();

    Dictionary() {

    }

    void addName(String name) {
        if (name == null || name.length() == 0)
            throw new NullPointerException("name cannot be empty");

        char[] words = name.toCharArray();
        names.add(name);
        Dictionary dictionary = this;
        for (int i = 0; i < words.length; i++) {
            Character key =  Character.valueOf(words[i]);
            if (dictionary.prefixMap.containsKey(key) == false) {
                dictionary.prefixMap.put(key, new Dictionary());
            }
            dictionary.prefixMap.get(key).names.add(name);

            dictionary = dictionary.getDictionary(key);

        }

    }

    @Override
    public String toString() {
        return names.toString();
    }

    public Set<String> getNames() {
        return names;
    }

    public boolean isPrefixExist(Character prefix) {
        return prefixMap.containsKey(prefix);
    }

    public Dictionary getDictionary(Character prefix) {
        if (prefixMap.containsKey(prefix) == false) throw new NullPointerException("There is no names for this prefix");

        return prefixMap.get(prefix);
    }



}
