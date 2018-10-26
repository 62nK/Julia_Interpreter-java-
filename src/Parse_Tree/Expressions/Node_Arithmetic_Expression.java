package Parse_Tree.Expressions;

import Parse_Tree.Tokens.Lexical_Analyzer;

public class Node_Arithmetic_Expression {

    // Parent
    private String arithmetic_expression;

    // Children
    private Node_Boolean_Expression child_node_boolean_expression;

    // Variables
    private String child_id;
    private String child_literal_integer;
    private String child_binary_expression;
    private boolean syntax_error;

    public Node_Arithmetic_Expression(){}
    public Node_Arithmetic_Expression(String arithmetic_expression){
        this.arithmetic_expression = arithmetic_expression.trim();

        // identify children
        Lexical_Analyzer lexical_analyzer = new Lexical_Analyzer(this.arithmetic_expression);
        switch (lexical_analyzer.get_type()){
            case "id":
                child_id = this.arithmetic_expression;
                break;
            case "literal_integer":
                child_literal_integer = this.arithmetic_expression;
                break;
            case "invalid":
                break;
            default:
                break;
        }
        this.arithmetic_expression = child_binary_expression;
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
