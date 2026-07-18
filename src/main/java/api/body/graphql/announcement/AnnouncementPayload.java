package api.body.graphql.announcement;

import java.util.HashMap;
import java.util.Map;

public class AnnouncementPayload {
    public static Map<String, Object> getLoginPayload(String email, String password) {
        String query = "mutation Login($input: LoginInput!) { " +
                "  login(input: $input) { " +
                "    token " +
                "  } " +
                "}";

        Map<String, Object> inputVariables = new HashMap<>();
        inputVariables.put("email", email);
        inputVariables.put("password", password);

        Map<String, Object> variables = new HashMap<>();
        variables.put("input", inputVariables);

        Map<String, Object> body = new HashMap<>();
        body.put("query", query);
        body.put("variables", variables);
        return body;
    }
}
