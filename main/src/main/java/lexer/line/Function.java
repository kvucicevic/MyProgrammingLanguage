package lexer.line;

import lexer.word.TokenType;

import java.util.HashMap;
import java.util.Map;

public class Function extends Line {

    /**
     * Function isHigher with number a , number b as arguments and return type number :
     * Function isVowel with letter let as argument and return type number :
     * Function removeDuplicates with word "word" as argument and no return value :
     * Function main with no arguments and return type number :
     */

    private final LineType type = LineType.Function;
    private Map<String, TokenType> map;

    public Function(String inputLine) {
        super(inputLine);
    }

    @Override
    public void analyzeLine(String inputLine) {
        String[] words = inputLine.split(" ");
        this.map = new HashMap<>();

        this.map.put(words[1], TokenType.FunctionName);

        if(inputLine.contains("no arguments")) {
            this.map.put(words[6], TokenType.Return);
            this.map.put(words[8], TokenType.DataType);
            return;
        }

        this.map.put(words[3], TokenType.DataType);
        this.map.put(words[4], TokenType.VarName);

        if(inputLine.contains("arguments")){
            this.map.put(words[5], TokenType.Punctuation);
            this.map.put(words[6], TokenType.DataType);
            this.map.put(words[7], TokenType.VarName);

            if(inputLine.contains("no")){
                this.map.put(words[12], TokenType.Return);
                this.map.put(words[13], TokenType.Punctuation);
            } else {
                this.map.put(words[11], TokenType.Return);
                this.map.put(words[13], TokenType.DataType);
                this.map.put(words[14], TokenType.Punctuation);
            }

        } else {
            if(inputLine.contains("no")){
                this.map.put(words[9], TokenType.Return);
                this.map.put(words[10], TokenType.Punctuation);
            } else {
                this.map.put(words[8], TokenType.Return);
                this.map.put(words[10], TokenType.DataType);
                this.map.put(words[11], TokenType.Punctuation);
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        for(String str : map.keySet()){
            res = res.concat("KeyWord: " + "\"" + str + "\"" + " is of type: " + map.get(str) + "\n");
        }

        return res;
    }

    public LineType getType() {
        return type;
    }
}
