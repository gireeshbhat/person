package input.PersonExercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetRelationshipAction implements Action{

    static Map<String, String> relationshipMethodMapper = new HashMap<String, String>();

    static {
        relationshipMethodMapper.put("Maternal-Aunt", "getMaternalAunts");
        relationshipMethodMapper.put("Maternal-Uncle", "getMaternalUncles");
    }

    @Override
    public void performAction(String[] args){
        String personName = args[1];
        String relationship = args[2];
        String methodName  = relationshipMethodMapper.get(relationship);
        Person person = ShanFamilyTreeBuilder.personMap.get(personName.toLowerCase());

        try{
            Method method = Person.class.getMethod(methodName);
            List<Person> maternalAunts = (List<Person>) method.invoke(person);
            System.out.println(maternalAunts);
        }catch (NoSuchMethodException e){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
