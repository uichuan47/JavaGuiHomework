package uichuan;

import sun.awt.WindowClosingListener;

import java.awt.*;
import java.awt.event.*;

public class Demo1 {
    public static void main(String[] args) {
        new Caculator().loadFrame();
    }
}

class Caculator extends Frame {
    public void loadFrame() {
        start();
        close();

        // 中心面板容器
        Panel panelContainer = new Panel();
        Panel labelContainer = new Panel();
        panelContainer.setBackground(Color.WHITE);
        labelContainer.setBackground(Color.WHITE);
        panelContainer.setBounds(50, 200, 400, 60);
        labelContainer.setBounds(50, 140, 400, 30);
        add(panelContainer);
        add(labelContainer);

        // 创建中心面板容器的表格布局（1*4）
        panelContainer.setLayout(new GridLayout(1, 4));

        //创建标题
        Label msg = new Label("选择要计算的功能");
        labelContainer.add(msg);

        // 创建按钮
        Button button1 = new Button("最大公约数");
        Button button2 = new Button("最小公倍数");
        Button button3 = new Button("水仙花数");
        Button button4 = new Button("完数");
        panelContainer.add(button1);
        panelContainer.add(button2);
        panelContainer.add(button3);
        panelContainer.add(button4);

        // 事件监听
        MyActionListener1 myActionListener1 = new MyActionListener1();
        button1.addActionListener(myActionListener1);
        MyActionListener2 myActionListener2 = new MyActionListener2();
        button2.addActionListener(myActionListener2);
        MyActionListener3 myActionListener3 = new MyActionListener3();
        button3.addActionListener(myActionListener3);
        MyActionListener4 myActionListener4 = new MyActionListener4();
        button4.addActionListener(myActionListener4);

    }

    public void start() {
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(300, 300, 500, 600);
        this.setBackground(Color.GRAY);
    }

    public void close() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyActionListener1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        MySonFrame mySonFrame = new MySonFrame(1);
        mySonFrame.loadSonFrame();

    }
}

class MyActionListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MySonFrame mySonFrame = new MySonFrame(2);
        mySonFrame.loadSonFrame();
    }
}

class MyActionListener3 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MySonFrame mySonFrame = new MySonFrame(3);
        mySonFrame.loadSonFrame();
    }
}

class MyActionListener4 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MySonFrame mySonFrame = new MySonFrame(4);
        mySonFrame.loadSonFrame();
    }
}


class MySonFrame extends Frame {
    private void start() {
        this.setLayout(null);
        this.setVisible(false);
        this.setBounds(300, 300, 500, 600);
        this.setBackground(Color.GRAY);
    }

    private int type;

    public MySonFrame(int type) {
        this.type = type;
        start();
        addWindowListener(new SonActionListener());
        if (type == 1) {
            process_1();
        } else if (type == 2) {
            process_2();
        }else if (type == 3){
            process_3();
        } else if (type == 4) {
            process_4();
        }
    }

    // 创建数学计算对象
    Process math_master = new Process();

    public void process_1() {
        // 新建一个容器
        Panel BtnContainer1 = new Panel();
        BtnContainer1.setBounds(50, 140, 400, 50);
        BtnContainer1.setBackground(Color.WHITE);
        add(BtnContainer1);

        // 新建三个输入框
        TextField num1 = new TextField(3);
        TextField num2 = new TextField(3);
        TextField num3 = new TextField(8);
        Button resbutton1 = new Button("->");
        Label label = new Label("最大公约数");
        //布局
        BtnContainer1.setLayout(new FlowLayout());
        BtnContainer1.add(num1);
        BtnContainer1.add(num2);
        BtnContainer1.add(label);
        BtnContainer1.add(resbutton1);
        BtnContainer1.add(num3);

        // ->按钮添加事件
        ProcessLinstener1 processLinstener1 = new ProcessLinstener1(num1, num2, num3);
        resbutton1.addActionListener(processLinstener1);

    }

    public void process_2() {
        // 新建一个容器
        Panel BtnContainer2 = new Panel();
        BtnContainer2.setBounds(50, 140, 400, 50);
        BtnContainer2.setBackground(Color.WHITE);
        add(BtnContainer2);

        // 新建三个输入框
        TextField num1 = new TextField(3);
        TextField num2 = new TextField(3);
        TextField num3 = new TextField(8);
        Button resbutton1 = new Button("->");
        Label label = new Label("最小公倍数");
        //布局
        BtnContainer2.setLayout(new FlowLayout());
        BtnContainer2.add(num1);
        BtnContainer2.add(num2);
        BtnContainer2.add(label);
        BtnContainer2.add(resbutton1);
        BtnContainer2.add(num3);

        // ->按钮添加事件
        ProcessLinstener2 processLinstener2 = new ProcessLinstener2(num1, num2, num3);
        resbutton1.addActionListener(processLinstener2);

    }
    public void process_3() {
        // 新建一个容器
        Panel BtnContainer2 = new Panel();
        BtnContainer2.setBounds(50, 140, 400, 50);
        BtnContainer2.setBackground(Color.WHITE);
        add(BtnContainer2);

        // 新建一个输入框
        TextField num = new TextField(18);
        Label label = new Label("水仙花数有：");
        Label labe2 = new Label("153  370  371  407");
        //布局
        BtnContainer2.setLayout(new FlowLayout());
        BtnContainer2.add(label);
        BtnContainer2.add(labe2);
        // ->按钮添加事件

    }
    public void process_4() {
        // 新建一个容器
        Panel BtnContainer2 = new Panel();
        BtnContainer2.setBounds(50, 140, 400, 50);
        BtnContainer2.setBackground(Color.WHITE);
        add(BtnContainer2);

        // 新建一个输入框
        TextField num = new TextField(18);
        Label label = new Label("1000以内的完数有：");
        Label labe2 = new Label("6 28 496");
        //布局
        BtnContainer2.setLayout(new FlowLayout());
        BtnContainer2.add(label);
        BtnContainer2.add(labe2);
        // ->按钮添加事件

    }

    class ProcessLinstener1 implements ActionListener {
        private TextField num1;
        private TextField num2;
        private TextField num3;

        public ProcessLinstener1(TextField num1, TextField num2, TextField num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            int res = math_master.CaculateModel1(n1, n2);
            num3.setText("" + (n1 + n2));
            // 3.清楚前两个框
            num1.setText("");
            num2.setText("");
        }
    }

    class ProcessLinstener2 implements ActionListener {
        private TextField num1;
        private TextField num2;
        private TextField num3;

        public ProcessLinstener2(TextField num1, TextField num2, TextField num3) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            int res = math_master.CaculateModel2(n1, n2);
            num3.setText(""+res);
            // 3.清楚前两个框
            num1.setText("");
            num2.setText("");
        }
    }

    public void loadSonFrame() {
        setVisible(true);
    }

    public class SonActionListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false);
        }
    }
}

class Process {
    public int CaculateModel1(int number1, int number2) {
        while (number2 != 0) {
            int temp = number1 % number2;
            number1 = number2;
            number2 = temp;
        }
        return number1;
    }

    public int CaculateModel2(int m, int n) {
        for (int i = (m > n ? m : n); i <= m * n; i++) {

            if (i % n == 0 && i % m == 0) {
                return i;
            }
        }
        return -1;
    }
}