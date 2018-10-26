package Parse_Tree;

import Parse_Tree.Expressions.Node_Arithmetic_Expression;
import Parse_Tree.Tokens.Lexemes;

public class Node_Iter {

    // Parent
    private String iter;

    // Children
    private Node_Arithmetic_Expression child_node_arithmetic_expression1, child_node_arithmetic_expression2;

    // Variables
    private String child_arithmetic_expression1;
    private String child_arithmetic_op;
    private String child_arithmetic_expression2;
    private boolean syntax_error;

    public Node_Iter(){}
    public Node_Iter(String iter){
        syntax_error = false;

        this.iter = iter;
        // identify children
        if(this.iter.contains(":")){
            child_arithmetic_expression1 = this.iter.substring(0, this.iter.indexOf(":")).trim();
            child_arithmetic_op = "add_operator";
            child_arithmetic_expression2 = this.iter.substring(this.iter.indexOf(":") + 1).trim();
            syntax_error();
        }
        else
            syntax_error = true;

        if(!syntax_error)
            expand();
    }

    private boolean syntax_error(){
        return syntax_error;
    }


    // Create children
    private void expand(){
        child_node_arithmetic_expression1 = new Node_Arithmetic_Expression(child_arithmetic_expression1);
        child_node_arithmetic_expression2 = new Node_Arithmetic_Expression(child_arithmetic_expression2);
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
