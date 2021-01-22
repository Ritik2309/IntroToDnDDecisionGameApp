package com.example.introtodnddecisiongame;

public class DecisionNode {

    int NodeID;
    String nodeDescription;
    int optionOneID;
    int optionTwoID;
    int optionThreeID;
    String optionOneQues;
    String optionTwoQues;
    String optionThreeQues;
    DecisionNode optionOneNode;
    DecisionNode optionTwoNode;
    DecisionNode optionThreeNode;

    DecisionNode linkedNode;

    public DecisionNode() {}

    public int getNodeID() {
        return NodeID;
    }

    public void setNodeID(int nodeID) {
        NodeID = nodeID;
    }

    public int getOptionOneID() {
        return optionOneID;
    }

    public void setOptionOneID(int optionOneID) {
        this.optionOneID = optionOneID;
    }

    public int getOptionTwoID() {
        return optionTwoID;
    }

    public void setOptionTwoID(int optionTwoID) {
        this.optionTwoID = optionTwoID;
    }

    public int getOptionThreeID() {
        return optionThreeID;
    }

    public void setOptionThreeID(int optionThreeID) {
        this.optionThreeID = optionThreeID;
    }

    public String getNodeDescription() {
        return nodeDescription;
    }

    public void setNodeDescription(String nodeDescription) {
        this.nodeDescription = nodeDescription;
    }

    public String getOptionOneQues() {
        return optionOneQues;
    }

    public void setOptionOneQues(String optionOneQues) {
        this.optionOneQues = optionOneQues;
    }

    public String getOptionTwoQues() {
        return optionTwoQues;
    }

    public void setOptionTwoQues(String optionTwoQues) {
        this.optionTwoQues = optionTwoQues;
    }

    public String getOptionThreeQues() {
        return optionThreeQues;
    }

    public void setOptionThreeQues(String optionThreeQues) {
        this.optionThreeQues = optionThreeQues;
    }

    public DecisionNode getOptionOneNode() {
        return optionOneNode;
    }

    public void setOptionOneNode(DecisionNode optionOneNode) {
        this.optionOneNode = optionOneNode;
    }

    public DecisionNode getOptionTwoNode() {
        return optionTwoNode;
    }

    public void setOptionTwoNode(DecisionNode optionTwoNode) {
        this.optionTwoNode = optionTwoNode;
    }

    public DecisionNode getOptionThreeNode() {
        return optionThreeNode;
    }

    public void setOptionThreeNode(DecisionNode optionThreeNode) {
        this.optionThreeNode = optionThreeNode;
    }

    public DecisionNode getLinkedNode() {
        return linkedNode;
    }

    public void setLinkedNode(DecisionNode linkedNode) {
        this.linkedNode = linkedNode;
    }




}
