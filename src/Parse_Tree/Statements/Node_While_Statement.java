package Parse_Tree.Statements;

import Parse_Tree.Expressions.Node_Boolean_Expression;
import Parse_Tree.Node_Block;

public class Node_While_Statement {

    // Parent
    private String while_statement;

    // Children
    private Node_Boolean_Expression child_node_boolean_expression;
    private Node_Block child_node_block;

    // Variables
    private String child_while;
    private String child_boolean_expression;
    private String child_block;
    private String child_end;
    private boolean syntax_error;

    // Constructors
    public Node_While_Statement(){}
    public Node_While_Statement(String while_statement){
        this.while_statement = while_statement.trim();

        // identify children
        if(this.while_statement.contains("while")) {
            child_while = this.while_statement.substring(0, this.while_statement.indexOf(" ")).trim();
            child_boolean_expression = this.while_statement.substring(this.while_statement.indexOf(" "), this.while_statement.indexOf("\n")).trim();
            child_block = this.while_statement.substring(this.while_statement.indexOf("\n")+1, Math.max(this.while_statement.lastIndexOf(" "), this.while_statement.lastIndexOf("\n"))).trim();
            child_end = this.while_statement.substring(Math.max(this.while_statement.lastIndexOf(" "), this.while_statement.lastIndexOf("\n"))).trim();
        }
        else {

        }
        expand();
    }

    private boolean syntax_error(){
        return syntax_error;
    }

    // Create children
    private void expand(){

    }

    // Output
    public void display_node(){

    }
    private void display_error(){
        if(!syntax_error());

        else {

        }
    }
}
