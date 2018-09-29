package Parse_Tree.Statements;

public class Node_Assignment_Statement {

    // Parent
    private String assign_statement;

    // Children

    // Variables
    private String child_id;
    private String child_assignment_operator;
    private String child_arithmetic_expression;

    // Constructors
    public Node_Assignment_Statement(){}
    public Node_Assignment_Statement(String assign_statement){
        // Store block string
        this.assign_statement = assign_statement.trim();

        // identify children
        if(this.assign_statement.contains("=")) {
            child_id = this.assign_statement.substring(0, this.assign_statement.indexOf("=")).trim();
            child_arithmetic_expression = "=";
            child_assignment_operator = this.assign_statement.substring(this.assign_statement.indexOf("=")+1).trim();
        }
        else {
            child_id = this.assign_statement.substring(0, 1);
            child_arithmetic_expression = this.assign_statement.substring(1);
        }
        expand();
    }

    // Create children
    public void expand(){

    }
}
