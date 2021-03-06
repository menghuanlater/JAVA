package DAGH_Fork;

import MysqlAssist.SearchBetweenNameID;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 止水清潇 on 2017-02-02.
 * 字典树构造类
 */
class NodeUserInfo{
    private final int CODE_DEFAULT = 0;
    private int userCode;
    private String userName;
    private boolean exist;
    private List<String> sameFork;
    private int count;
    public NodeUserInfo(){
        userCode = CODE_DEFAULT;
        userName = null;
        exist = false;
        sameFork = new ArrayList<>();
        count = 0;//计数器初始化
    }

    public int getUserCode() {
        return userCode;
    }

    protected void setUserCodeAndName(int userCode) {
        this.userCode = userCode;
        SearchBetweenNameID temp = new SearchBetweenNameID();
        temp.set(userCode);
        userName = temp.getUserName();
        this.exist = true;
    }

    protected boolean isExist() {
        return exist;
    }

    public String getUserName() {
        return userName;
    }

    protected void selfUpCounter(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public void addSameFollowing(String addObject){
        sameFork.add(addObject);
    }
    public List<String> getSameFollowing(){
        return sameFork;
    }
}

public class DictTreeNode {
    static final int ARRAY_LENGTH = 10;
    //flagNodeArray数组用来表示10个link结点是否实际存在
    private boolean flagNodeArray[] = new boolean[ARRAY_LENGTH];
    //linkNodeArray数组表示是个link结点，不存在则表示为null
    private DictTreeNode linkNodeArray[] = new DictTreeNode[ARRAY_LENGTH];
    private NodeUserInfo nodeUser = new NodeUserInfo();

    //构造函数
    public DictTreeNode() {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            flagNodeArray[i] = false;
            linkNodeArray[i] = null;
        }
    }
    //create一个新的分支结点
    public void createLinkNode(int position){
        linkNodeArray[position] = new DictTreeNode();
        flagNodeArray[position] = true;
    }
    //查询状态以及深度优先遍历所需的访问操作
    public boolean getFlag(int position){
        return flagNodeArray[position];
    }
    public DictTreeNode getNextDictTreeNode(int position){
        return linkNodeArray[position];
    }
    //final user信息的build
    public NodeUserInfo getNodeUser(){
        return nodeUser;
    }
}
