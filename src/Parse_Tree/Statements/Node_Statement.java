package Parse_Tree.Statements;

public class Node_Statement {

    // Parent
    private String statement;

    // Children
    private Node_Assignment_Statement child_node_assignment_statement;
    private Node_If_Statement child_node_if_statement;
    private Node_While_Statement child_node_while_statement;
    private Node_For_Statement child_node_for_statement;
    private Node_Print_Statement child_node_print_statement;

    // Variables
    private String child_type;
    private boolean syntax_error;
    private String if_statement;
    private String assignment_statement;
    private String while_statement;
    private String print_statement;
    private String for_statement;

    public Node_Statement(){}
    public Node_Statement(String statement){
        syntax_error = false;
        // Store block string
        this.statement = statement.trim();

        // identify children
        if(this.statement.contains("if ")) {
            if_statement = this.statement;
            child_type = "if";
            expand(if_statement);
        }
        else if(this.statement.contains(" while ") && this.statement.contains(" end ")){
            while_statement = this.statement;
            child_type = "while";
            expand(while_statement);
        }
        else if(this.statement.contains(" for ") && this.statement.contains(" end ")){
            for_statement = this.statement;
            child_type = "for";
            expand(for_statement);
        }
        else if(this.statement.contains(" print ")){
            print_statement = this.statement;
            child_type = "print";
            expand(print_statement);
        }
        else if(this.statement.contains(" = ")){
            assignment_statement = this.statement;
            child_type = "assign";
            expand(assignment_statement);
        }
        else
            syntax_error=true;
    }

    // Methods

    // Syntax check
    private boolean syntax_error(){
        return syntax_error;
    }
    private boolean statement_error(){return false;}

    // Create children
    private void expand(String expansion){
        if(child_type == null)
            return;
        else
        switch (child_type){
            case "if":
                child_node_if_statement = new Node_If_Statement(if_statement);
                break;
            case "while":
                child_node_while_statement = new Node_While_Statement(while_statement);
                break;
            case "for":
                child_node_for_statement = new Node_For_Statement(for_statement);
                break;
            case "print":
                child_node_print_statement = new Node_Print_Statement(print_statement);
                break;
            case "assign":
                child_node_assignment_statement = new Node_Assignment_Statement(assignment_statement);
                break;
            default:
                break;
        }
    }

    // Output
    public void display_node(){
        if(child_type == null)
            display_error();
        else
        switch (child_type){
            case "if":
                System.out.println("If Statement node, child:");
                System.out.printf("\tstatement: \'%s\'\n", if_statement);
                break;
            case "while":
                System.out.println("While Statement node, child:");
                System.out.printf("\tstatement: \'%s\'\n", while_statement);
                break;
            case "for":
                System.out.println("For Statement node, child:");
                System.out.printf("\tstatement: \'%s\'\n", for_statement);
                break;
            case "print":
                System.out.println("Print Statement node, child:");
                System.out.printf("\tstatement: \'%s\'\n", print_statement);
                break;
            case "assign":
                System.out.println("Assign Statement node, child:");
                System.out.printf("\tstatement: \'%s\'\n", assignment_statement);
                break;
            default:
                display_error();
                break;
        }




        display_error();

    }
    private void display_error(){
        if(!syntax_error())
            System.out.println("No errors found in Program Node");
        else {
            if(statement_error()) {
                System.out.println("Error in statement");
                System.out.printf("\tstatement: \'%s\' where it\'s supposed to be \'function'\n", statement);
            }
        }
    }
}
