import java.awt.*;  
import java.awt.event.*;  

class MyCalc extends WindowAdapter implements ActionListener { 
    Frame f; 
    Label l1;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    Button badd,bsub,bmult,bdiv,bmod,bcalc,bclr,bpts,bneg,bback;
    double xd;
    double num1,num2,check;

    MyCalc(){  
        f = new Frame("MY CALCULATOR");

        // ===== DISPLAY =====
        l1 = new Label(); 
        l1.setBounds(50,50,260,60);
        l1.setBackground(Color.BLACK);
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font("Arial", Font.BOLD, 24));

        // ===== NUMBER BUTTONS =====
        b1=new Button("1"); b1.setBounds(50,340,50,50);
        b2=new Button("2"); b2.setBounds(120,340,50,50);
        b3=new Button("3"); b3.setBounds(190,340,50,50);
        b4=new Button("4"); b4.setBounds(50,270,50,50);
        b5=new Button("5"); b5.setBounds(120,270,50,50); 
        b6=new Button("6"); b6.setBounds(190,270,50,50);
        b7=new Button("7"); b7.setBounds(50,200,50,50);
        b8=new Button("8"); b8.setBounds(120,200,50,50);
        b9=new Button("9"); b9.setBounds(190,200,50,50);
        b0=new Button("0"); b0.setBounds(120,410,50,50);

        bneg=new Button("+/-"); bneg.setBounds(50,410,50,50);
        bpts=new Button("."); bpts.setBounds(190,410,50,50);
        bback=new Button("←"); bback.setBounds(120,130,50,50);

        // ===== OPERATION BUTTONS =====
        badd=new Button("+"); badd.setBounds(260,340,50,50);
        bsub=new Button("-"); bsub.setBounds(260,270,50,50);
        bmult=new Button("*"); bmult.setBounds(260,200,50,50);
        bdiv=new Button("/"); bdiv.setBounds(260,130,50,50);
        bmod=new Button("%"); bmod.setBounds(190,130,50,50);
        bcalc=new Button("="); bcalc.setBounds(245,410,65,50);
        bclr=new Button("CE"); bclr.setBounds(50,130,65,50);

        // ===== ACTION LISTENERS =====
        Button[] all = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,
                        badd,bsub,bmult,bdiv,bmod,bcalc,bclr,bpts,bneg,bback};

        for(Button b : all){
            b.addActionListener(this);
            b.setFont(new Font("Arial", Font.BOLD, 16));
        }

        f.addWindowListener(this);

        // ===== COLORS =====
        f.setBackground(new Color(30,30,30)); // dark background

        Color numColor = new Color(0, 188, 212);   // cyan
        Color opColor  = new Color(255, 87, 34);  // orange
        Color eqColor  = new Color(76, 175, 80);  // green
        Color clrColor = new Color(244, 67, 54);  // red

        // Number buttons
        Button[] nums = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9};
        for(Button b : nums){
            b.setBackground(numColor);
            b.setForeground(Color.BLACK);
        }

        // Operators
        Button[] ops = {badd,bsub,bmult,bdiv,bmod};
        for(Button b : ops){
            b.setBackground(opColor);
            b.setForeground(Color.WHITE);
        }

        bcalc.setBackground(eqColor);
        bcalc.setForeground(Color.WHITE);

        bclr.setBackground(clrColor);
        bclr.setForeground(Color.WHITE);

        bpts.setBackground(Color.YELLOW);
        bneg.setBackground(Color.MAGENTA);
        bback.setBackground(Color.LIGHT_GRAY);

        // ===== ADD TO FRAME =====
        f.add(l1);
        for(Button b : all) f.add(b);

        f.setSize(360,500);  
        f.setLayout(null);  
        f.setVisible(true);  
    } 

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public void actionPerformed(ActionEvent e){ 
        String z,zt;

        if(e.getSource()==b1){ z=l1.getText()+"1"; l1.setText(z); }
        if(e.getSource()==b2){ z=l1.getText()+"2"; l1.setText(z); }
        if(e.getSource()==b3){ z=l1.getText()+"3"; l1.setText(z); }
        if(e.getSource()==b4){ z=l1.getText()+"4"; l1.setText(z); }
        if(e.getSource()==b5){ z=l1.getText()+"5"; l1.setText(z); }
        if(e.getSource()==b6){ z=l1.getText()+"6"; l1.setText(z); }
        if(e.getSource()==b7){ z=l1.getText()+"7"; l1.setText(z); }
        if(e.getSource()==b8){ z=l1.getText()+"8"; l1.setText(z); }
        if(e.getSource()==b9){ z=l1.getText()+"9"; l1.setText(z); }
        if(e.getSource()==b0){ z=l1.getText()+"0"; l1.setText(z); }

        if(e.getSource()==bpts){ l1.setText(l1.getText()+"."); }
        if(e.getSource()==bneg){ l1.setText("-"+l1.getText()); }

        if(e.getSource()==bback){
            zt=l1.getText();
            if(zt.length()>0)
                l1.setText(zt.substring(0,zt.length()-1));
        }

        if(e.getSource()==badd){ num1=Double.parseDouble(l1.getText()); l1.setText(""); check=1; }
        if(e.getSource()==bsub){ num1=Double.parseDouble(l1.getText()); l1.setText(""); check=2; }
        if(e.getSource()==bmult){ num1=Double.parseDouble(l1.getText()); l1.setText(""); check=3; }
        if(e.getSource()==bdiv){ num1=Double.parseDouble(l1.getText()); l1.setText(""); check=4; }
        if(e.getSource()==bmod){ num1=Double.parseDouble(l1.getText()); l1.setText(""); check=5; }

        if(e.getSource()==bcalc){
            num2=Double.parseDouble(l1.getText());
            if(check==1) xd=num1+num2;
            if(check==2) xd=num1-num2;
            if(check==3) xd=num1*num2;
            if(check==4) xd=num1/num2;
            if(check==5) xd=num1%num2;
            l1.setText(String.valueOf(xd));
        }

        if(e.getSource()==bclr){
            num1=num2=check=xd=0;
            l1.setText("");
        }
    }

    public static void main(String args[]){  
        new MyCalc();  
    }
}
