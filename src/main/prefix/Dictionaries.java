package prefix;

import java.util.Set;

public final class Dictionaries {
    private final Dictionary dictionary = new Dictionary();

    public void addName(String name) {
        dictionary.addName(name);
    }

    public Set<String> getNames() {
        return dictionary.getNames();
    }

    public Dictionary getDictionary(String prefix) {
        return dictionary.getDictionary(prefix);
    }
}
