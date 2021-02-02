package com.example.finclaw.util;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

@Service
public class KubefateServiceImpl implements KubefateService {

    private static String cmdPrefix = "python3 /finclaw/kubefate/docker-deploy/script.py -f";

    @Override
    public boolean deploy(String[] userID, String[] password, String[] ip, String[] filepath, String projectName) {
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" deploy -pw ");
        appendArg(password, sb);
        sb.append("-id ");
        appendArg(userID, sb);
        sb.append("-ip ");
        appendArg(ip, sb);
        sb.append("-p ");
        appendArg(filepath, sb);
        sb.append("-proj ");
        sb.append(projectName);
        String cmd = sb.toString();
        int retCode = execCommand(cmd);
        if (retCode >= 0) {
            return true;
        } else return false;
    }

    @Override
    public boolean submit(String algorithm, String projectName) {
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" submit -alg ");
        sb.append(algorithm);
        sb.append(" -proj ");
        sb.append(projectName);
        String cmd = sb.toString();
        int retCode = execCommand(cmd);
        if (retCode >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete() {
        return true;
    }

    @Override
    public boolean bind(String modelID, String modelVersion, String modelName) {
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" load_bind -mid ");
        sb.append(modelID);
        sb.append(" -mver ");
        sb.append(modelVersion);
        sb.append(" -mname ");
        sb.append(modelName);
        String cmd = sb.toString();
        int retCode = execCommand(cmd);
        if (retCode >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double predict(String modelName, String[] args) {
        StringBuilder sb = new StringBuilder(cmdPrefix);
        sb.append(" predict -mname ");
        sb.append(modelName);
        sb.append(" -params ");
        appendArg(args, sb);
        String cmd = sb.toString();
        //return execPredict(cmd);
        return 0;
    }

    private int execCommand(String cmd) {
        System.out.println("the cmd is: " + cmd);
        int retCode = 0;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            retCode = process.waitFor();
            getOutput(process);
        } catch (IOException | InterruptedException e) {
            retCode = -1;
            e.printStackTrace();
        }
        return retCode;

    }

    private void getOutput(Process process) throws IOException {
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = input.readLine()) != null) {
            output.append(line).append("\n");
        }
        System.out.println(output.toString());
        input.close();
        ir.close();
    }

    private void appendArg(String[] args, StringBuilder s) {
        for (String arg : args) {
            s.append(arg);
            s.append(" ");
        }
    }
}
