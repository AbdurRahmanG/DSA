package Com.TechilyFly.DSA;

import java.util.Scanner;

public class Backtracking {
    
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter N Number: ");
        int n = userInput.nextInt();

        System.out.println("How many Cells you want to block, Choose From 1 to (N * N - 2)");
        int m = userInput.nextInt();

        userInput.close();

        if(m <= 1 && m >= n*n-2){
            
            System.exit(0);
        }

        
        int [][] grid = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                System.out.print(grid[i][j]);

            }
            System.out.println();
        }

        System.out.println("After Tracking");

        int block_number = 0;
        while(block_number < m){
            int x = (int) (Math.random() *n);
            int y = (int) (Math.random() *n);

            if(x == 0 && y == 0){
                continue;
            }
            if(x == n-1 && y == n-1){
                continue;
            }

            if(grid [x][y] == 1){
                continue;
            }

            grid[x][y] = 1;
            block_number++;

        }   


        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){

                System.out.print(grid[x][y]);

            }
            System.out.println();
        }   

        int [][] visited = new int[n][n];
        int [][] path = new int[n*n][2];

        path[0][0] = 0;
        path[0][1] = 0;
        
        int postion = 0;
        
        while(postion >= 0){
            
            int x = path[postion][0];
            int y = path[postion][1];

            // System.out.println("In loop: " + x + " " + y + " " + postion);

            // Visited Cells
            visited[x][y] = 1;

            if(x == n-1 && y == n-1){
                break;
            }

            // Right
            if(y != n-1 && grid[x][y+1] != 1 && visited[x][y+1] != 1){
                path[postion+1][0] = x;
                path[postion+1][1] = y+1;
                postion++;
                continue;
            }

            // Up
            if(x != 0 && grid[x-1][y] != 1 && visited[x-1][y] != 1){
                path[postion+1][0] = x-1;
                path[postion+1][1] = y;
                postion++;
                continue;
            }

            // Left
            if(y != 0 && grid[x][y-1] != 1 && visited[x][y-1] != 1){
                path[postion+1][0] = x;
                path[postion+1][1] = y-1;
                postion++;
                continue;
            }

            // Down
            if(x != n-1 && grid[x+1][y] != 1 && visited[x+1][y] != 1){
                path[postion+1][0] = x+1;
                path[postion+1][1] = y;
                postion++;
                continue;
            }

            postion--;

        }

        if(postion < 0){
            System.out.println("Path Does Not Exist!");
        } else {
            System.out.println("Congratulations! Your Path has been found...");

            for(int i = 0; i <= postion; i++){
                System.out.println("[ " + path[i][0] + ", " + path[i][1] + " ]");
            }

        }

        


    }
        
    
}
