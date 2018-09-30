package Parse_Tree.Statements;

import Parse_Tree.Expressions.Node_Boolean_Expression;
import Parse_Tree.Node_Block;

public class Node_If_Statement {

    public class Node_Assignment_Statement {

        // Parent
        private String if_statement;

        // Children
        private Node_Boolean_Expression child_node_boolean_expression;
        private Node_Block child_node_block1, child_node_block2;

        // Variables
        private String child_if;
        private String child_boolean_expression;
        private String child_block1;
        private String child_else;
        private String child_block2;
        private String child_end;
        private boolean syntax_error;

        // Constructors
        public Node_Assignment_Statement(){}
        public Node_Assignment_Statement(String if_statement){
            // Store block string
            this.if_statement = if_statement.trim();

            // identify children
            if(this.if_statement.contains("if") && this.if_statement.contains("else")) {
                child_if = this.if_statement.substring(0, this.if_statement.indexOf(" ")).trim();
                child_boolean_expression = this.if_statement.substring(this.if_statement.indexOf(" "), this.if_statement.indexOf("\n")).trim();
                child_block1 = this.if_statement.substring(this.if_statement.indexOf("\n")+1).trim();
                child_else = "else";
                child_block2 = "";
                child_end = this.if_statement.substring(Math.max(this.if_statement.lastIndexOf(" "), this.if_statement.lastIndexOf("\n") )+1).trim();

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

}
