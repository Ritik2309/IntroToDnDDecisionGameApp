package com.example.introtodnddecisiongame;


import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.Integer.*;

public class DecisionMap {

    DecisionNode head;
    DecisionNode tail;

    public DecisionMap(BufferedReader csvFile) {
        try {
            buildUnorderedList(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildOrderedMap();

    }

    public void buildUnorderedList(BufferedReader csvFile) throws IOException {

        String line;
        DecisionNode node;
        int numOfNodes = 0;
        do {
            line = csvFile.readLine();
            try {
                node = buildNode(line);
                append(node);
            } catch (emptyLineErrorHandling emptyLineErrorHandling) {
                Log.w("CSVLineIsBlank",emptyLineErrorHandling);
            }
            numOfNodes++;
        }while(numOfNodes != 54);
    }


    private void append(DecisionNode newNode) {

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode(null);
            return;
        }

        this.tail.setLinkedNode(newNode);
        this.tail = newNode;
    }



    private void buildOrderedMap() {

        if (head == null) {return;}

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {

            int optionOneID = nodeLinker.getOptionOneID();
            int optionTwoID = nodeLinker.getOptionTwoID();
            int optionThreeID = nodeLinker.getOptionThreeID();

            DecisionNode optionOne = nodeFetch(optionOneID);
            DecisionNode optionTwo = nodeFetch(optionTwoID);
            DecisionNode optionThree = nodeFetch(optionThreeID);

            nodeLinker.setOptionOneNode(optionOne);
            nodeLinker.setOptionTwoNode(optionTwo);
            nodeLinker.setOptionThreeNode(optionThree);

            nodeLinker = nodeLinker.getLinkedNode();

        }
        cleanup();

    }

    private void cleanup(){
        if (head == null) {return;}

        DecisionNode currentNode = head;
        DecisionNode nextNode = head.getLinkedNode();

        while (nextNode != null) {

            currentNode.setLinkedNode(null);

            currentNode = nextNode;
            nextNode = currentNode.getLinkedNode();
        }
    }

    private DecisionNode buildNode(String line) throws emptyLineErrorHandling {
        if(line.equals("")){
            throw new emptyLineErrorHandling("Oh no you have an empty line in your CSV!");
        }
        String[] stringArray = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        DecisionNode n = new DecisionNode();

        n.setNodeID(parseInt(stringArray[0]));
        n.setNodeDescription(stringArray[1]);

        n.setOptionOneID(parseInt(stringArray[2]));
        n.setOptionTwoID(parseInt(stringArray[4]));
        n.setOptionThreeID(parseInt(stringArray[6]));

        n.setOptionOneQues(stringArray[3]);
        n.setOptionTwoQues(stringArray[5]);
        n.setOptionThreeQues(stringArray[7]);

        return n;
    }

    public DecisionNode entryPoint() {
        return head;
    }

    private DecisionNode nodeFetch(int nodeID) {

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            if(nodeLinker.getNodeID() == nodeID){ break ;}
            nodeLinker = nodeLinker.getLinkedNode();
        }

        return nodeLinker;
    }


    private boolean isEmpty() {
        return this.head == null;
    }
}
