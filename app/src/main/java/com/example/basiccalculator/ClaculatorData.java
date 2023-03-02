package com.example.basiccalculator;

import android.util.Log;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class ClaculatorData {

    String calculatedResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"javascript",1,null).toString();
            String removeZero = finalResult.substring(finalResult.length()-2);
            if(removeZero.equals(".0")){
                finalResult = finalResult.substring(0,finalResult.length()-2);
                return finalResult;
            }else {
                return finalResult;
            }

        }catch (Exception e){
            return e.toString();
        }
    }

}
