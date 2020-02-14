package input.PersonExercise;

import input.PersonExercise.exception.InvalidCommandLineArguments;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

    static Map<String, Class> actionMapper = new HashMap<>();

    static{

        try {
            ShanFamilyTreeBuilder.build();
            actionMapper.put("GET_RELATIONSHIP", Class.forName("input.PersonExercise.GetRelationshipAction"));
            actionMapper.put("ADD_SPOUSE", Class.forName("input.PersonExercise.AddSpouseAction"));
            actionMapper.put("ADD_CHILD", Class.forName("input.PersonExercise.AddChildAction"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvalidCommandLineArguments {

        //Validation

        if(args[0] == null ) {
            throw new InvalidCommandLineArguments("Action Name Not Provided");
        }
        if(!actionMapper.containsKey(args[0])){
            throw new InvalidCommandLineArguments("Invalid Action");
        }

        Class actionClass = actionMapper.get(args[0]);
        Action action = (Action)actionClass.newInstance();
        action.performAction(args);


    }
}
