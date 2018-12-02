package com.zte.sunquan.demo.actor.linecount;

import akka.actor.Props;
import akka.actor.UntypedActor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 10184538 on 2016/10/25.
 */
public class FileCounterActor extends UntypedActor {

    private boolean running = false;
    private int totalLines = 0;
    private int linesProcessed = 0;
    private int result = 0;


    public List<String> getFileLines(String fileName) {
        List<String> list = new ArrayList<String>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String tempString = null;
            while ((tempString = bufferedReader.readLine()) != null) {
                list.add(tempString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void onReceive(Object msg) {
        //start file processing
        if (msg instanceof StartFileCalculateMsg) {
            StartFileCalculateMsg startProcessFileMsg = (StartFileCalculateMsg) msg;
            if (running) {
                System.out.println("Warning: duplicate start message received");
            } else {
                running = true;

                String filepath = startProcessFileMsg.getPath();
                FileReader fileReader = null;
                try {
                    fileReader = new FileReader(filepath);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String tempString = null;
                    while ((tempString = bufferedReader.readLine()) != null) {
                        getContext().actorOf(Props.create(LineCounterActor.class)).tell(new LineCalculatingMsg(tempString), this.self());
                        totalLines += 1;//record lines
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fileReader != null)
                            fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//                getFileLines(startProcessFileMsg.getPath()).forEach((line)->{
//                    getContext().actorOf(Props.create(LineCounterActor.class)).tell(new LineCalculatingMsg(line),this.self());
//                    totalLines+=1;
//                });
            }
        } else if (msg instanceof LineCalculatedMsg) {
            LineCalculatedMsg stringProcessedMsg = (LineCalculatedMsg) msg;
            result += stringProcessedMsg.getWords();
            linesProcessed += 1;
            if (linesProcessed == totalLines) {
                System.out.println("Total words is " + result);
//                getContext().system().shutdown();
            }

        }
    }
}
