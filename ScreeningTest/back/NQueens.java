package ScreeningTest.back;
import java.util.*;
public class NQueens {
    public static void solve(int n){
        char[][] grid = new char[n][n];
        for(char[] row : grid)Arrays.fill(row,'.');
        backtrack(0,grid);
    }
    public static void backtrack(int row,char[][] grid){
        if(row == grid.length){
            print(grid);
            return;
        }
        for(int col = 0;col<grid.length;col++){
            if(isSafe(row,col,grid)){
                grid[row][col] = 'Q';
                backtrack(row+1,grid);
                grid[row][col] = '.';
            }
        }
    }
    public static boolean isSafe(int row,int col,char[][] grid){
        for(int i=0;i<row;i++){//col
            if(grid[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row-1,j = col-1;i>=0 && j>=0;i--,j--){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }
        for(int i= row-1,j = col+1;i>=0&& j<grid.length ;i--,j++){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void print(char grid[][]){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        solve(n);
    }
}
