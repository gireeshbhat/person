package input.PersonExercise;

public class AddChildAction implements Action{


    @Override
    public void performAction(String[] args) {
        String personName = args[1];
        String childName = args[2];
        String childGender = args[3];

        Person person = ShanFamilyTreeBuilder.personMap.get(personName.toLowerCase());
        Person child = ShanFamilyTreeBuilder.personMap.get(childName.toLowerCase());

        if (child == null){
            Gender gender = childGender.equalsIgnoreCase("Male")?Gender.Male:Gender.Female;
            child = new Person(childName, gender);
        }

        try {
            person.giveBirthTo(child);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(person.getChildren());
    }
}
