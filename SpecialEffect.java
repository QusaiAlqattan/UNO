public class SpecialEffect {
    String Description;
    String Name;

    SpecialEffect(String description, String name) {
        Description = description;
        Name = name;
    }

    void effect(){
        System.out.println(Description);
    }
}
