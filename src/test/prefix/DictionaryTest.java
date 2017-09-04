package prefix;

public class DictionaryTest {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addName("aple");
        dictionary.addName("bk");
        dictionary.addName("bkc");
        dictionary.addName("appl");
        dictionary.addName("apler");
        dictionary.addName("bo");
        dictionary.addName("bk1");
        dictionary.addName("bk1113");

        System.out.println(dictionary);
        System.out.println(dictionary.getDictionary('a'));
        System.out.println(dictionary.getDictionary('b'));
        System.out.println(dictionary.getDictionary('a').getDictionary('p').getDictionary('l'));
        System.out.println(dictionary.getDictionary('b').getDictionary('k'));
        System.out.println(dictionary.getDictionary('b').getDictionary('k').getDictionary('c'));
        System.out.println(dictionary.getDictionary('b').getDictionary('k').getDictionary('1'));

    }
}
