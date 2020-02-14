package input.PersonExercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AddSpouseAction implements Action {

    @Override
    public void performAction(String[] args) {
        String personName = args[1];
        String spouseName = args[2];

        Person person = ShanFamilyTreeBuilder.personMap.get(personName.toLowerCase());
        Person spouse = ShanFamilyTreeBuilder.personMap.get(spouseName.toLowerCase());

        if (spouse == null){
            Gender gender = person.getGender()==Gender.Male?Gender.Female:Gender.Male;
            spouse = new Person(spouseName, gender);
        }

        person.registerMarriageWith(spouse);

        System.out.println(person.getSpouse());
    }
}
