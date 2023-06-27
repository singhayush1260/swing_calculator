/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 *
 * @author Ayush Singh
 */
public class EvaluateExpression {
    public String calculate(String exp) {
        String result="";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            Object res = engine.eval(exp);
            result=res.toString();
            System.out.println(result); // Output: 7
        } catch (ScriptException e) {
            System.out.println("error");
            result="SE";
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String args[]){
        EvaluateExpression ob=new EvaluateExpression();
        ob.calculate("1+3*ff(4");
    }
}
