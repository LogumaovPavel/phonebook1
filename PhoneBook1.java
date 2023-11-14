import java.util.*;

public class PhoneBook1 {
    private static HashMap<String, ArrayList> contacts = new HashMap<>();

    public static void addContacts(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            ArrayList phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }else {
            ArrayList phoneNumbers = new ArrayList();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }
    public static void printContacts(){
        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        for (Map.Entry<String, ArrayList> entry: list){
            System.out.println(entry.getKey()+": " + entry.getValue());
        }
    }
    public static void main (String[] args){
        addContacts("Иванов", "223-22-11");
        addContacts("Иванов", "331-23-12");
        addContacts("Петров", "221-10-15");
        addContacts("Ильин", "221-25-01");
        addContacts("Иванов", "223-22-11");
        addContacts("Сергеев", "102-22-41");
        addContacts("Петров", "912-31-45");
        addContacts("Павлов", "412-74-12");

        printContacts();
    }
}
