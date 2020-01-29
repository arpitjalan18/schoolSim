package schoolSim;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.*;

public class AStar {
    public static final int DIAGONAL_COST = 141;
    public static final int V_H_COST = 100 ;
    
    static class Cell{  
        int heuristicCost = 0; //Heuristic cost
        int finalCost = 0; //G+H
        int i, j;
        Cell parent; 
        
        Cell(int i, int j){
            this.i = i;
            this.j = j; 
        }
        
        @Override
        public String toString(){
            return "["+this.i+", "+this.j+"]";
        }
    }
    
    //Blocked cells are just null Cell values in grid
    static Cell [][] grid = new Cell[113][100];
    
    static PriorityQueue<Cell> open;
     
    static boolean closed[][];
    static int startI, startJ;
    static int endI, endJ;
            
    public static void setBlocked(int i, int j){
        grid[i][j] = null;
    }
    
    public static void setStartCell(int i, int j){
        startI = i;
        startJ = j;
    }
    
    public static void setEndCell(int i, int j){
        endI = i;
        endJ = j; 
    }
    
   public static void checkAndUpdateCost(Cell current, Cell t, int cost){
        if(t == null || closed[t.i][t.j])return;
        int t_final_cost = t.heuristicCost+cost;
        
        boolean inOpen = open.contains(t);
        if(!inOpen || t_final_cost<t.finalCost){
            t.finalCost = t_final_cost;
            t.parent = current;
            if(!inOpen)open.add(t);
        }
    }
    
    public static void AStar(){ 
        
    	
        //add the start location to open list.
        open.add(grid[startI][startJ]);
        
        Cell current;
        
        while(true){ 
            current = open.poll();
        
            if(current==null)break;
            closed[current.i][current.j]=true; 

            if(current.equals(grid[endI][endJ])){
                return; 
            } 

            Cell t;  
            if(current.i-1>=0){
                t = grid[current.i-1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 

                if(current.j-1>=0){                      
                    t = grid[current.i-1][current.j-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }

                if(current.j+1<grid[0].length){
                    t = grid[current.i-1][current.j+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }
            } 

            if(current.j-1>=0){
                t = grid[current.i][current.j-1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 
            }

            if(current.j+1<grid[0].length){
                t = grid[current.i][current.j+1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 
            }

            if(current.i+1<grid.length){
                t = grid[current.i+1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 

                if(current.j-1>=0){
                    t = grid[current.i+1][current.j-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }
                
                if(current.j+1<grid[0].length){
                   t = grid[current.i+1][current.j+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }  
            }
        } 
    }
    

    public static ArrayList<Point> test(int xStart, int yStart, int xDest,int yDest, int floorNum){
    	
	    	
			int x = 113; int y = 100;
           grid = new Cell[x][y];
           closed = new boolean[x][y];
           open = new PriorityQueue<>((Object o1, Object o2) -> {
                Cell c1 = (Cell)o1;
                Cell c2 = (Cell)o2;

                return c1.finalCost<c2.finalCost?-1:
                        c1.finalCost>c2.finalCost?1:0;
            });
           
          
           for(int i=0;i<x;++i){
              for(int j=0;j<y;++j){
                  grid[i][j] = new Cell(i, j);
                  grid[i][j].heuristicCost = Math.abs(i-endI)+Math.abs(j-endJ);                
              }
           }
           grid[xDest][yDest].finalCost = 0;
           readExcel reader = new readExcel();
			Color[][] mapColor = new Color[113][100];
			try {
				mapColor = reader.readFromExcel(floorNum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();  
			}
			for (int i = 0; i < 113; i++) {
				for (int j = 0; j < 100; j++) {
					
					if ( mapColor[i][j].getBlue() == 102 &&  mapColor[i][j].getRed() == 102 && mapColor[i][j].getGreen() == 102) {
						setBlocked(i, j);
						
					}
	
				}
			}
         
			
			//Set start position
	           setStartCell(xStart, yStart);  //Setting to 0,0 by default. Will be useful for the UI part
	           
	          //Set End Location
	           setEndCell(xDest, yDest); 
        AStar(); 
        ArrayList<Point> path = new ArrayList<>();
        if(closed[endI][endJ]){
            //Trace back the path 
             
             Cell current = grid[endI][endJ];
             path.add(new Point(current.i, current.j));
             while(current.parent!=null){
             	 path.add(new Point(current.i, current.j));
                 current = current.parent;
             } 
    
        }
     
        return path;	
       
    }   
}
