import javax.swing.*;

public class Torre {
    private static int mov,discos;
    public static void startHanoi() {

        discos=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de discos"));
        if(discos<=0){
            JOptionPane.showMessageDialog(null,"Porfavor digite um valor acima de 0");
            startHanoi();
        }
        else{
            int coluna[][]= new int [discos+1][3];           
            coluna[0][0]=1;
            coluna[0][1]=2;
            coluna[0][2]=3;
            for(int i=1;(i<=discos);i++){    
                coluna[i][0]=i;
            }
        mover(coluna);
        hanoi(discos, 1,2,3,coluna);
        }
    }
    public static void hanoi(int discos, int O,  int T,int D,int coluna[][]) {
        if (discos>0) {
            hanoi((discos-1), O, D,T,coluna);
            coluna[discos][(D-1)]=coluna[discos][(O-1)];
            coluna[discos][(O-1)]=0;
            mover(coluna);
            hanoi((discos-1), T, O,D,coluna);    
        }
    }
    public static void mover(int coluna[][]){
        System.out.println("\n Movimento="+mov);
        for(int i=1;i<=discos;i++){
            System.out.println("| "+coluna[i][0]+" | "+coluna[i][1]+" | "+coluna[i][2]+" |");  
        }
        System.out.println(" ------------");
        System.out.println("| A | B | C |");
        mov++;
    }
}
