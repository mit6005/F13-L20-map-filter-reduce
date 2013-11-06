package hogwarts;

import javax.script.ScriptEngine;

import scripting.Python;

public class WizardProcs2 {
    public static void main(String[] args) {
        ScriptEngine engine = Python.makeScriptEngine();
        Python.runScriptFile(engine, "src/hogwarts/WizardProcs2.py");
    }
}
