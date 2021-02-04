package com.example.finclaw.blImpl.kubefate;

import com.example.finclaw.bl.kubefate.KubefateService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @Author: LLY
 * @Date:   2021-2-3
 */

@Service
public class KubefateServiceImpl implements KubefateService {
    private static String DEPLOY_ERROR = "部署失败";
    private static String DEPLOY_SUCCESS = "部署成功";
    private static String TRAIN_ERROR = "启动训练失败";
    private static String TRAIN_SUCCESS = "成功开始训练";

    private static String cmdPrefix = "python3 /finclaw/kubefate/docker-deploy/script.py -f";
    @Override
    public ResponseVO deploy(Integer projectID) {
        StringBuilder sb = new StringBuilder(cmdPrefix);
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
