package input.PersonExercise;

public class PersonUtil {

    public void findPerson(String name){
        findPersonRecursively(ShanFamilyTreeBuilder.KING_SHAN, name);
    }

    private Person findPersonRecursively(Person parent, String name){
        if (parent.getName() == name){
            return parent;
        }

        for (Person person : parent.getChildren()){
            findPersonRecursively(person, name);
        }
        return null;
    }
}
