import java.util.Scanner;
public class Tic_Tac_Toe {
    public static void printboard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" |");
            }
            System.out.println();
        }
    }
    public static boolean havewon(char board[][],String Player) {
        //secondary diagonal
        if(board[0][2]==Player.charAt(0)&&board[1][1]==Player.charAt(0)&&board[2][0]==Player.charAt(0))
        return true;
        //primary diagonal
        if(board[0][0]==Player.charAt(0)&&board[1][1]==Player.charAt(0)&&board[2][2]==Player.charAt(0))return true;
        //row
        for(int i=0;i<3;i++){
            if(board[i][0]==Player.charAt(0)&&board[i][1]==Player.charAt(0)&&board[i][2]==Player.charAt(0))return true;
            else if(board[0][i]==Player.charAt(0)&&board[1][i]==Player.charAt(0)&&board[2][i]==Player.charAt(0))return true;
        }
        return false;
    }
    public static void main(String args[]){
        char board[][]=new char[3][3];
        Scanner sc=new Scanner(System.in);
        //initialize board as empty
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //make board empty
              board[i][j]=' ';
            }
        }
        String player="X";
        boolean gameover=false;
        while(!gameover){
            printboard(board);
            System.out.print("Player"+player+" Enter Cell Number(row,col) : ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            //check if can insert at that cell or nor
            if(row>=3&&col>=3)System.out.println("OOps! Invalid Move Try Again ");
            if(board[row][col]==' '){
                board[row][col]=player.charAt(0);
                printboard(board);
                //check as enter player wins or not
                gameover=havewon(board,player);
                if(gameover)System.out.println(player+" havewon!");
                else{
                    //give chance to next player
                    player=(player=="X"?"O":"X");
                }
            }
            else{
                System.out.println("Match Draw");
                return ;
            }

            System.out.println();
        }
        sc.close();
    }
}
